package com.example.emt_lab_201531.web;
import com.example.emt_lab_201531.model.Book;
import com.example.emt_lab_201531.model.dto.BookDTO;
import com.example.emt_lab_201531.model.enums.BookCategory;
import com.example.emt_lab_201531.service.AuthorService;
import com.example.emt_lab_201531.service.BookService;
import com.example.emt_lab_201531.service.CountryService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/books")
public class HomeController {
    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;

    public HomeController(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> findAllBooks(){
        return this.bookService.findAll();
    }

    @GetMapping("/pagination")
    public List<Book> findAllBooksWithPagination(Pageable pageable){ //could be Page<Book> and no getContent
        return bookService.findAllWithPagination(pageable).getContent();
    }
    @GetMapping({"/{id}",})
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookService.findById(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id,
                                         @RequestBody BookDTO bookDTO){
        return bookService.edit(id, bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/markAsTaken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id){
        return bookService.markAsTaken(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDTO bookDTO){
        return bookService.create(bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
