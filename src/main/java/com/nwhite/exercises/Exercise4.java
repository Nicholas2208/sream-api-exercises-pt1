package com.nwhite.exercises;

import com.nwhite.dao.CityDao;
import com.nwhite.dao.CountryDao;
import com.nwhite.dao.InMemoryWorldDao;
import com.nwhite.domain.City;
import com.nwhite.domain.Country;

import java.util.Comparator;
import java.util.Objects;

public class Exercise4 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the highest populated capital city
        var highPopulatedCapitalCity =
                countryDao.findAllCountries()
                        .stream()
                        .map(Country::getCapital)
                        .filter(Objects::nonNull)
                        .map(cityDao::findCityById)
                        .filter(Objects::nonNull)
                        .max(Comparator.comparing(City::getPopulation));
        highPopulatedCapitalCity.ifPresent(System.out::println);
    }

}
