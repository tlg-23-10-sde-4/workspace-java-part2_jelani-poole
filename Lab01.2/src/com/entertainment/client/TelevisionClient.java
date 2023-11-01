package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient {
    public static void main(String[] args) {
        /*
        Television tv1 = new Television();
        System.out.println(tv1);

        Television tv2 = new Television("RCR", 10);
        System.out.println(tv2);
        tv2.changeChannel(9);
        System.out.println(tv2);
        System.out.println();

         */

        // show behavior of the equals method
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 32);
        Television tvD = new Television("LG", 12);

        System.out.println(tvA);
        System.out.println(tvB);
        System.out.println("tvA==tvB:" + (tvA == tvB)); // false
        System.out.println("tvA.equals(tvB):" + tvA.equals(tvB));  // true
        System.out.println();

        System.out.println(tvA.hashCode()); // 80069516
        System.out.println(tvB.hashCode()); // 76250
        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);  // should be rejected as a duplicate
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the set is: " + tvs.size());
        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }
}