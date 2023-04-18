package com.example.emt_lab_201531.model;

import com.example.emt_lab_201531.model.enums.BookCategory;
import jakarta.persistence.*;
import lombok.Data;

import javax.annotation.processing.Generated;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private BookCategory category;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
    private Integer availableCopies;
    public Book() {

    }
    public Book(String name, BookCategory category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
