package com.example.demo3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.BindingResult;


import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter
@Setter
@Entity
public class CommentInquiry {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
 
    // 必須入力、文字列が20文字まで。
 	@NotBlank
 	@Size(min = 1, max = 20)
 	private String name;
 	
 	// 必須入力、Email形式であること、文字列が30文字まで。
 	@NotBlank
 	@Email
 	@Size(min = 1, max = 30)
 	private String email;
 	
 	// 必須入力、文字列が1024文字まで。
 	@NotBlank
 	@Size(min = 1, max = 1024)
 	private String content;
}
