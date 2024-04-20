package com.Book.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Book.Entity.Book;

public interface BookRepositry extends JpaRepository<Book, Integer> {

}
