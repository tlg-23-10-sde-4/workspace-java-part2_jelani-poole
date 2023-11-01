/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();
        // testFindSelfTitled();
        // testFindCheapRock();
        // testNumberInGenre();
        // testGetAveragePrice();
        // testFindCheapest(); // TODO
        // testHasGenre();

        // TASK method tests

    }

    private static void testHasGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        boolean hasBlues = catalog.hasGenre(MusicCategory.BLUES);
        System.out.println(hasBlues);  // TRUE

        boolean hasJazz = catalog.hasGenre(MusicCategory.JAZZ);
        System.out.println(hasJazz); //FALSE
    }

    // TODO
    private static void testFindCheapest() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.findCheapest(null));
    }

    private static void testGetAveragePrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        System.out.println(catalog.getAveragePrice());
    }

    private static void testNumberInGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Integer total = catalog.numberInGenre(MusicCategory.BLUES);
        System.out.println(total);

    }

    private static void testFindCheapRock() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> cheapRock = catalog.findCheapRock(12.0);
        dump(cheapRock);
    }

    private static void testFindSelfTitled() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> selfTitled = catalog.findSelfTitled();
        dump(selfTitled);
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem found = catalog.findById(9L);
        System.out.println(found);

        MusicItem notFound = catalog.findById(20L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        dump(popItems);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.size());  // should be 18
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> allItems = catalog.getAll();
        allItems.clear(); // should throw exception
    }

    // helper method to show the collection "vertically"
    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }
}