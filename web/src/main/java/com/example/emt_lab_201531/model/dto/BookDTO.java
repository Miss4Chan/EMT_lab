package com.example.emt_lab_201531.model.dto;

import com.example.emt_lab_201531.model.Author;
import com.example.emt_lab_201531.model.enums.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    String name;
    Long authorId;
    BookCategory category;
    Integer availableCopies;
}
