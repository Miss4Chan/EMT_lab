package com.example.emt_lab_201531.model;

import com.example.emt_lab_201531.model.enums.ContinentEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ContinentEnum continent;

    public Country(String name, ContinentEnum continent) {
        this.name=name;
        this.continent=continent;
    }

    public Country() {

    }
}
