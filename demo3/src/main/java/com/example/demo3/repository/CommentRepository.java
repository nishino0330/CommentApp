package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo3.model.CommentInquiry;

public interface CommentRepository extends JpaRepository <CommentInquiry, Long> {

}
