package com.nwhite.dao;

import com.nwhite.domain.City;

import java.util.List;

public interface CityDao {
    City findCityById(int id);
    List<City> findAllCities();
}
