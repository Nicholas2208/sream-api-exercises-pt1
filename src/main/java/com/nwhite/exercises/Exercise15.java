package com.nwhite.exercises;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

import com.nwhite.dao.CountryDao;
import com.nwhite.dao.InMemoryWorldDao;
import com.nwhite.domain.Country;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class Exercise15 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final ToIntFunction<Country> compareByCitiyNumber = country -> country.getCities().size();
    private static final Consumer<Country> printCountry = country -> System.err.printf("%s: %d\n",country.getName(),country.getCities().size());

    private static final BiConsumer<String, List<Country>> printEntry = (continent, countries) -> {
        System.err.println(continent);
        System.err.println("=".repeat(continent.length()));
        countries.forEach(printCountry);
        System.err.println("\n");
    };

    public static void main(String[] args) {
        // Group the countries by continent, and then sort the countries in each continent by number of cities in each country.
        var countriesByContinent =
                countryDao.findAllCountries()
                        .stream()
                        .sorted(comparingInt(compareByCitiyNumber ).reversed())
                        .collect(groupingBy(Country::getContinent));
        countriesByContinent.forEach(printEntry);
    }

}
