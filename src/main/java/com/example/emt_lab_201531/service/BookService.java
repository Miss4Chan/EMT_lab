package com.example.emt_lab_201531.service;

import com.example.emt_lab_201531.model.Book;
import com.example.emt_lab_201531.model.dto.BookDTO;
import com.example.emt_lab_201531.model.enums.BookCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> create(BookDTO bookDTO);

    void deleteById(Long bookId);

    Optional<Book> edit(Long bookId,BookDTO bookDTO);

    Optional<Book> markAsTaken(Long bookId);

    Optional<Book> findById(Long bookId);

    List<Book> findAll();
}
