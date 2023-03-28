package com.example.emt_lab_201531.service;

import com.example.emt_lab_201531.model.enums.ContinentEnum;
import org.springframework.stereotype.Service;


public interface CountryService {
    void create(String name, ContinentEnum continent);
}
