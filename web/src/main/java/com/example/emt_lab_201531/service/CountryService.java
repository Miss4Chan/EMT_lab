package com.example.emt_lab_201531.service;

import com.example.emt_lab_201531.model.Country;
import com.example.emt_lab_201531.model.enums.ContinentEnum;

import java.util.List;


public interface CountryService {
    void create(String name, ContinentEnum continent);

    List<Country> findAll();
}
