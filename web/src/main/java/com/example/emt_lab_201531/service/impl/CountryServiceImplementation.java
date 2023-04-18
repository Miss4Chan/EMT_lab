package com.example.emt_lab_201531.service.impl;

import com.example.emt_lab_201531.model.Country;
import com.example.emt_lab_201531.model.enums.ContinentEnum;
import com.example.emt_lab_201531.repository.CountryRepository;
import com.example.emt_lab_201531.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImplementation implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void create(String name, ContinentEnum continent) {
        Country country = new Country(name,continent);
        this.countryRepository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }
}
