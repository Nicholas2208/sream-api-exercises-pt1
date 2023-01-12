package com.nwhite.exercises;

import static java.lang.Long.compare;

import com.nwhite.dao.InMemoryWorldDao;
import com.nwhite.dao.WorldDao;
import com.nwhite.util.CountrySummaryStatistics;

import java.util.function.Supplier;

public class Exercise13 {
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    private static final Supplier<CountrySummaryStatistics> countrySummaryStatisticsSupplier =
            () -> new CountrySummaryStatistics((l, r) -> compare(l.getPopulation(), r.getPopulation()));

    public static void main(String[] args) {
        // Find the countries with the minimum and the maximum population
        var countrySummaryStatistics =
                worldDao.findAllCountries()
                        .stream()
                        .collect(countrySummaryStatisticsSupplier, CountrySummaryStatistics::accept, CountrySummaryStatistics::combine);
        System.out.println(countrySummaryStatistics);
    }

}
