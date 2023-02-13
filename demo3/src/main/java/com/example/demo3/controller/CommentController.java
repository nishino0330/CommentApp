package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org. springframework.validation. annotation. Validated;
import org. springframework.web.bind.annotation.GetMapping;
import org. springframework.web.bind.annotation.ModelAttribute;
import org. springframework.web.bind.annotation.PostMapping;

import com.example.demo3.model.CommentInquiry;
import com.example.demo3.repository.CommentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CommentController {

    private final CommentRepository repository;
    Logger logger = LoggerFactory.getLogger(CommentController.class);

    //@Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getAllComments(@ModelAttribute CommentInquiry commentInquiry, Model model) {
        // COMMENTテーブル：レコード全件取得
        model.addAttribute("comments", repository.findAll());
        model.addAttribute("commentInquiry", commentInquiry);
        return "list";
    }

    @PostMapping("/add")
    public String addComment(@Validated @ModelAttribute CommentInquiry commentInquiry, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("comments", repository.findAll());
            return "list";
        }
        // COMMENTテーブル：コメント登録
        repository.save(commentInquiry);
        // ルートパス("/") にリダイレクトします
        return "redirect:/";
    }
    
    @GetMapping("/delete")
    public String deleteComment(@Validated @ModelAttribute CommentInquiry comment, BindingResult result, Model model) {
        model.addAttribute("comments", repository.findAll());
        model.addAttribute("comment", comment);
        // COMMENTテーブル：レコード削除
        repository.deleteById(comment.getId());
        // ルートパス("/") にリダイレクトします
        return "redirect:/";
    }

}
