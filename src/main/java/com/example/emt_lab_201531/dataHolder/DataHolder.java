package com.example.emt_lab_201531.dataHolder;

import com.example.emt_lab_201531.model.Author;
import com.example.emt_lab_201531.model.Book;
import com.example.emt_lab_201531.model.Country;
import com.example.emt_lab_201531.model.enums.BookCategory;
import com.example.emt_lab_201531.model.enums.ContinentEnum;
import com.example.emt_lab_201531.repository.AuthorRepository;
import com.example.emt_lab_201531.repository.BookRepository;
import com.example.emt_lab_201531.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataHolder {

    private List<Author> authors;
    private List<Book> books;
    private List<Country> countries;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    @PostConstruct
    public void init() {;
        Country c1 = new Country("Macedonia", ContinentEnum.EUROPE);
        Country c2 = new Country("Laos",ContinentEnum.ASIA);
        Country c3 = new Country("Trinidad and Tobago",ContinentEnum.SOUTH_AMERICA);
        Country c4 = new Country("Saint Vincent and the Grenadines",ContinentEnum.SOUTH_AMERICA);
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countries.add(c4);
        countryRepository.saveAll(countries);

        Author a1 = new Author("author1","surname1",c1);
        Author a2 = new Author("author2" ,"surname2",c2);
        Author a3 = new Author("author3", "surname3",c3);
        Author a4 = new Author("author4", "surname4",c4);
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);
        authorRepository.saveAll(authors);

        Book b1 = new Book("BOOK1", BookCategory.BIOGRAPHY,a2,30);
        Book b2 = new Book("BOOK2", BookCategory.NOVEL,a2,20);
        Book b3 = new Book("BOOK3", BookCategory.DRAMA,a3,50);
        Book b4 = new Book("BOOK4", BookCategory.CLASSICS,a3,100);
        Book b5 = new Book("BOOK5", BookCategory.THRILLER,a3,45);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        bookRepository.saveAll(books);
    }

}

