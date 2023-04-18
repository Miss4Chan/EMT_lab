package com.example.emt_lab_201531.service;

import com.example.emt_lab_201531.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void create(String name, String surname, Long countryId);

    Optional<Author> findById(Long id);

    List<Author> findAll();
}
