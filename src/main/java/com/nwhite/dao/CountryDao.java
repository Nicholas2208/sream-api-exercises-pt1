package com.nwhite.dao;

import com.nwhite.domain.Country;

import java.util.List;
import java.util.Set;

public interface CountryDao {
    List<Country> findAllCountries();

    Set<String> getAllContinents();
}
