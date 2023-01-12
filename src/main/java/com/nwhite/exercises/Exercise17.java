package com.nwhite.exercises;

import com.nwhite.dao.InMemoryWorldDao;
import com.nwhite.dao.WorldDao;
import com.nwhite.domain.Country;
import com.nwhite.util.DoubleSummaryGaussianStatistics;

public class Exercise17 {
    private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the minimum, the maximum, the average, and the standard deviation of GNP values.
        var gnpStatistics =
                worldDao.findAllCountries()
                        .stream()
                        .mapToDouble(Country::getGnp)
                        .collect(
                                DoubleSummaryGaussianStatistics::new,
                                DoubleSummaryGaussianStatistics::accept,
                                DoubleSummaryGaussianStatistics::combine
                        );
        System.out.println(gnpStatistics);
    }
}
