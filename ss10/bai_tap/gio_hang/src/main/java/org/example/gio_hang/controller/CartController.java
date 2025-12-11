package org.example.gio_hang.controller;

import jakarta.servlet.http.HttpSession;
import org.example.gio_hang.entity.Cart;
import org.example.gio_hang.entity.CartItem;
import org.example.gio_hang.entity.Order;
import org.example.gio_hang.entity.Product;
import org.example.gio_hang.service.IOrderService;
import org.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    private Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("CART");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("CART", cart);
        }
        return cart;
    }

    // 1. Thêm sản phẩm vào giỏ
    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") Long productId,
                            @RequestParam(value = "quantity", defaultValue = "1") int quantity,
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
        Product product = productService.findById(productId);
        Cart cart = getCart(session);
        cart.addProduct(product, quantity);
        redirectAttributes.addFlashAttribute("message", "Đã thêm sản phẩm vào giỏ hàng");
        return "redirect:/products"; // sau khi add xong quay lại trang mua sắm
    }


    // 2. Xem giỏ hàng
    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        Cart cart = getCart(session);
        model.addAttribute("cart", cart);
        return "cart/cart"; // view
    }

    // 3. Thay đổi số lượng sản phẩm trong giỏ
    @PostMapping("/update")
    public String updateQuantity(@RequestParam("productId") Long productId,
                                 @RequestParam("quantity") int quantity,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        Cart cart = getCart(session);
        cart.updateQuantity(productId, quantity);
        redirectAttributes.addFlashAttribute("message", "Cập nhật số lượng thành công");
        return "redirect:/cart";
    }

    // 4. Xóa sản phẩm khỏi giỏ
    @PostMapping("/remove")
    public String removeItem(@RequestParam("productId") Long productId,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        Cart cart = getCart(session);
        cart.removeProduct(productId);
        redirectAttributes.addFlashAttribute("message", "Đã xóa sản phẩm khỏi giỏ");
        return "redirect:/cart";
    }

    // 5. Xem chi tiết một sản phẩm trong giỏ
    @GetMapping("/item/{productId}")
    public String viewCartItem(@PathVariable Long productId,
                               HttpSession session,
                               Model model) {
        Cart cart = getCart(session);
        CartItem item = cart.getItems().stream()
                .filter(ci -> ci.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (item == null) {
            return "redirect:/cart";
        }

        model.addAttribute("item", item);
        return "cart/item-detail";
    }

    // 6. Trang thanh toán (form thông tin khách hàng)
    @GetMapping("/checkout")
    public String checkoutForm(HttpSession session, Model model) {
        Cart cart = getCart(session);
        if (cart.isEmpty()) {
            return "redirect:/cart";
        }
        model.addAttribute("cart", cart);
        return "cart/checkout";
    }

    // 7. Xử lý thanh toán
    @PostMapping("/checkout")
    public String processCheckout(@RequestParam String name,
                                  @RequestParam String email,
                                  @RequestParam String address,
                                  HttpSession session,
                                  Model model) {
        Cart cart = getCart(session);
        if (cart.isEmpty()) {
            return "redirect:/cart";
        }

        Order order = orderService.createOrderFromCart(cart, name, email, address);

        // clear cart
        session.removeAttribute("CART");

        model.addAttribute("order", order);
        return "cart/checkout-success";
    }

}
