package com.example.emt_lab_201531.repository;

import com.example.emt_lab_201531.model.Author;
import com.example.emt_lab_201531.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
