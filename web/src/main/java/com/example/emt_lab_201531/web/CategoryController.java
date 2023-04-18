package com.example.emt_lab_201531.web;

import com.example.emt_lab_201531.model.enums.BookCategory;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping
    public List<BookCategory> findAll()
    {
        return Arrays.stream(BookCategory.values()).toList();
    }
}
