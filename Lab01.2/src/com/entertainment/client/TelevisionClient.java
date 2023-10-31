package com.entertainment.client;

import com.entertainment.Television;

public class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        System.out.println(tv1);

        Television tv2 = new Television("RCR", 10);
        System.out.println(tv2);
        tv2.changeChannel(9);
        System.out.println(tv2);
        System.out.println();

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        System.out.println(tvA);
        System.out.println(tvB);
        System.out.println("tvA==tvB:" + (tvA == tvB));
        System.out.println("tvA.equals(tvB):" + tvA.equals(tvB));
    }

}