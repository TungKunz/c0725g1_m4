package org.example.demoduan.controller;

import org.example.demoduan.service.IDistanceService;
import org.example.demoduan.service.IShippingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CheckoutController {
    @Autowired
    private IDistanceService distanceService;
    @Autowired
    private IShippingFeeService shippingFeeService;

    // URL: / (Hiển thị form checkout)
    @GetMapping
    public String redirectToCheckout() {
        return "redirect:/checkout"; // Chuyển hướng từ / sang /checkout
    }

    @GetMapping("/checkout")
    public String showCheckoutForm() {
        return "checkout"; // Phương thức này hiển thị form
    }

    // URL: / (Xử lý form submit)
    @PostMapping
    public String handleCheckout(
            @RequestParam String address,
            @RequestParam double latitude,
            @RequestParam double longitude,
            Model model
    ) {
        // Toạ độ cửa hàng (demo)
        // Đây là tọa độ Bưu điện Trung tâm Sài Gòn
        double storeLat = 10.776889;
        double storeLng = 106.700806;

        double distance = distanceService.distanceInKm(storeLat, storeLng, latitude, longitude);
        int fee = shippingFeeService.calculateFee(distance);

        model.addAttribute("address", address);
        model.addAttribute("distance", distance);
        model.addAttribute("fee", fee);

        return "result"; // Trả về trang hiển thị kết quả
    }
}