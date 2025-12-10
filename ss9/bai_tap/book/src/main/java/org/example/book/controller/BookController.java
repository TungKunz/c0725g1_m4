package org.example.book.controller;


import jakarta.validation.Valid;
import org.example.book.dto.BorrowingCardDTO;
import org.example.book.entity.Book;
import org.example.book.entity.BorrowingCard;
import org.example.book.service.IBookService;
import org.example.book.service.IBorrowingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowingService borrowingService;

    @GetMapping(value = "/book")
    public String showList(@RequestParam(name = "page", required = false, defaultValue ="0") int page,
                           @RequestParam(name = "size", required = false, defaultValue = "3") int size,
                           @RequestParam(name = "searchName", required = false, defaultValue = "") String searchName,
                           Model model) {
        Sort sort = Sort.by("author").ascending().and(Sort.by("title").descending());
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> bookPage = bookService.findAll(searchName, pageable);
        model.addAttribute("bookPage", bookPage);
        model.addAttribute("searchName", searchName);
        return "book/list";
    }
    @GetMapping(value = "/borrow")
    public String showBorrow(@RequestParam(name = "id") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String save(@RequestParam int id,RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        BorrowingCard borrowingCard = new BorrowingCard();
        borrowingCard.setBook(book);
        String code = borrowingService.generateBorrowCode();
        borrowingCard.setCode(code);
        bookService.updateBook("borrow", book);
        borrowingService.addBorrow(borrowingCard);
        redirectAttributes.addAttribute("code",code);
        return "redirect:/book";
    }

    @GetMapping(value = "/book-borrow")
    public String showListBorrow(@RequestParam(name = "page", required = false, defaultValue ="0") int page,
                                 @RequestParam(name = "size", required = false, defaultValue = "3") int size,
                                 @RequestParam(name = "searchName", required = false, defaultValue = "") String searchName,
                                 Model model) {
        Sort sort = Sort.by("code").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<BorrowingCard> cardPage = borrowingService.findAll(searchName, pageable);
        model.addAttribute("cardPage", cardPage);
        model.addAttribute("searchName", searchName);
        return "book/book-borrow";
    }
    @GetMapping("/return")
    public String showReturnForm(Model model) {
        model.addAttribute("borrowingCard", new BorrowingCard());
        return "book/return-form";
    }
    @PostMapping("/return/search")
    public String searchForReturn(@ModelAttribute BorrowingCard card, Model model, RedirectAttributes redirectAttributes) {
        String code = card.getCode();
        BorrowingCard foundCard = borrowingService.findByCode(code);
        Book book = bookService.findById(foundCard.getBook().getId());
        if (foundCard == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy thẻ mượn với mã: " + code);
            return "redirect:/books/return";
        }

        model.addAttribute("borrowingCard", foundCard);
        model.addAttribute("book",book);

        return "book/return-detail";
    }

    @PostMapping("/return/confirm")
    public String confirmReturn(@RequestParam("borrowCode") String code, RedirectAttributes redirectAttributes) {
        try {
            borrowingService.returnBook(code);
            redirectAttributes.addFlashAttribute("successMessage", "Trả sách thành công! Mã mượn: " + code);
            return "redirect:/book";

        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi trả sách: " + e.getMessage());
            return "redirect:/book";
        }
    }
    @ExceptionHandler(RuntimeException.class)
    public String handleError(RuntimeException e, Model model) {
        System.err.println("Lỗi Tổng Quát (Global Handler): " + e.getMessage());
        model.addAttribute("errorCode", 500);
        model.addAttribute("errorTitle", "Lỗi Hệ Thống");
        model.addAttribute("errorMessage", "Đã xảy ra lỗi không mong muốn. Vui lòng thử lại hoặc kiểm tra mã mượn. Chi tiết: " + e.getMessage());
        return "book/error-page";
    }
}
