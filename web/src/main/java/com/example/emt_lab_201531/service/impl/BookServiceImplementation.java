package com.example.emt_lab_201531.service.impl;

import com.example.emt_lab_201531.model.Author;
import com.example.emt_lab_201531.model.Book;
import com.example.emt_lab_201531.model.dto.BookDTO;
import com.example.emt_lab_201531.model.enums.BookCategory;
import com.example.emt_lab_201531.model.exceptions.AuthorNotFoundException;
import com.example.emt_lab_201531.model.exceptions.BookNotFoundException;
import com.example.emt_lab_201531.model.exceptions.NoAvailableCopiesException;
import com.example.emt_lab_201531.repository.AuthorRepository;
import com.example.emt_lab_201531.repository.BookRepository;
import com.example.emt_lab_201531.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> create(BookDTO bookDTO) {
        BookCategory cat = BookCategory.valueOf(bookDTO.getCategory().toString());
        Author author = authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(AuthorNotFoundException::new);
        Book book =  new Book(bookDTO.getName(), cat,author, bookDTO.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long bookId) {
        //Book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<Book> edit(Long bookId,BookDTO bookDTO) {
        BookCategory cat = BookCategory.valueOf(bookDTO.getCategory().toString());
        Book book = this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        Author author = this.authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(AuthorNotFoundException::new);

        book.setName(bookDTO.getName());
        book.setAuthor(author);
        book.setCategory(cat);
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

        if(book.getAvailableCopies()>0)
        {
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }
        else
        {
            throw new NoAvailableCopiesException();
        }
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
                // .orElseThrow(BookNotFoundException::new));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }
}
