package com.example.emt_lab_201531.service.impl;

import com.example.emt_lab_201531.model.Author;
import com.example.emt_lab_201531.model.Country;
import com.example.emt_lab_201531.model.exceptions.CountryNotFoundException;
import com.example.emt_lab_201531.repository.AuthorRepository;
import com.example.emt_lab_201531.repository.CountryRepository;
import com.example.emt_lab_201531.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(CountryNotFoundException::new);
        Author author = new Author(name,surname,country);
        authorRepository.save(author);
    }


    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
