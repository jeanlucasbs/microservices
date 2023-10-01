package com.jeanlucas.bookservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanlucas.bookservice.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
