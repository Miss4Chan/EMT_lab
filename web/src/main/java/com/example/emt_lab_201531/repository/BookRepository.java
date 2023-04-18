package com.example.emt_lab_201531.repository;

import com.example.emt_lab_201531.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
        Page<Book> findAll(Pageable pageable);
}
