package com.example.emt_lab_201531.repository;

import com.example.emt_lab_201531.model.Book;
import com.example.emt_lab_201531.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
