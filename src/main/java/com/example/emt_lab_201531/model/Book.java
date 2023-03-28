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
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book( String name, BookCategory category,Author author, Integer availableCopies) {
        this.category = category;
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}
