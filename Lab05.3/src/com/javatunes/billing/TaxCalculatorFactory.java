package com.javatunes.billing;

public class TaxCalculatorFactory {

    // prevent instantiation from the outside, this is an all-static class
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
        TaxCalculator calc = null;

        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }
}