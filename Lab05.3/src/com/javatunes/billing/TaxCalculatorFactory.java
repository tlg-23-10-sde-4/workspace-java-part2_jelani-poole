package com.javatunes.billing;

import java.util.Map;

public class TaxCalculatorFactory {

    // prevent instantiation from the outside, this is an all-static class


    private static final Map<Location,TaxCalculator> calcMap = Map.of(
            Location.ONLINE, new OnlineTax(),
            Location.USA,    new USATax(),
            Location.EUROPE, new EuropeTax()
    );

    private TaxCalculatorFactory() {
    }
    /*
     * TODO: Consider implementing a "cache" of TaxCalculator objects;
     *
     * If I have not previously the object (e.g., USATax), then i will create it here (with "new"),
     * add it to my cache, and then return it.
     *
     * If my cache already contains it, then I fetch it from the cache and return it
     *
     * Hint: you could use a simple Map<Location,TaxCalculator> for the cache.
     * It would be a 3 row map, each row has location and tax calculator
     */

    public static TaxCalculator getTaxCalculator(Location location) {

        if (!calcMap.containsKey(location))

        switch (location) {
            case ONLINE:
                calcMap.put(location, new OnlineTax());
                break;
            case USA:
                calcMap.put(location, new USATax());
                break;
            case EUROPE:
                calcMap.put(location, new EuropeTax());
        }
        return calcMap.get(location);
    }
}