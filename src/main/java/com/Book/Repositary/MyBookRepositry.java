package com.Book.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Book.Entity.MyBook;

public interface MyBookRepositry extends JpaRepository<MyBook, Integer> {

}
