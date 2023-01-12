package com.nwhite.exercises;

import static java.util.stream.Collectors.summarizingLong;

import com.nwhite.dao.InMemoryWorldDao;
import com.nwhite.dao.WorldDao;
import com.nwhite.domain.Country;

public class Exercise11 {
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the minimum, the maximum and the average population of world countries
        var populationSummary =
                worldDao.findAllCountries()
                        .stream()
                        .collect(summarizingLong(Country::getPopulation));
        System.out.println(populationSummary);
    }

}
