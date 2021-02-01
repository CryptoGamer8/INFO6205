package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.ConfigTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InsertionSortTimerTest {
    private static Integer[] random;
    private static Integer[] ordered;
    private static Integer[] partially;
    private static Integer[] reversed;
    private int nRuns = 20;
    private static int n = 10000;

    @BeforeClass
    public static void arrayInitial(){
        random = new Integer[n];
        reversed = new Integer[n];
        ordered = new Integer[n];
        partially = new Integer[n];
        Random ran = new Random();
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);


        for (int i = 0; i <n ; i++) {
            ordered[i] = i;
            reversed[i] = n-i-1;
        }
        random = helper.random(Integer.class, r -> r.nextInt(n));
        partially = helper.random(Integer.class, r -> r.nextInt(n));
        new InsertionSort<Integer>().sort(partially,0,partially.length/2);
        System.out.println("stop");
    }

    @Test
    public void areservedInsertionSortTimer(){
        Benchmark<Boolean> bm = new Benchmark_Timer<>(
                "reversedInsertionSortTimer",
                null,
                b -> {
                    new InsertionSort<Integer>().sort(reversed,
                            0,reversed.length);
                },
                null
        );
        double x = bm.run(true,nRuns);
        System.out.println("Time of reversed array is: "+x);
    }

    @Test
    public void brandomInsertionSortTimer(){
        Benchmark<Boolean> bm = new Benchmark_Timer<>(
                "randomInsertionSortTimer",
                null,
                b -> {
                    new InsertionSort<Integer>().sort(random,
                        0,random.length);
                },
                null
        );
        double x = bm.run(true,nRuns);
        System.out.println("Time of random array is: "+x);
    }

    @Test
    public void dorderedInsertionSortTimer(){
        Benchmark<Boolean> bm = new Benchmark_Timer<>(
                "orderedInsertionSortTimer",
                null,
                b -> {
                    new InsertionSort<Integer>().sort(ordered,
                            0,ordered.length);
                },
                null
        );
        double x = bm.run(true,nRuns);
        System.out.println("Time of ordered array is: "+x);
    }

    @Test
    public void cpartiallyInsertionSortTimer(){
        Benchmark<Boolean> bm = new Benchmark_Timer<>(
                "partiallyInsertionSortTimer",
                null,
                b -> {
                    new InsertionSort<Integer>().sort(partially,
                            0,partially.length);
                },
                null
        );
        double x = bm.run(true,nRuns);
        System.out.println("Time of partially array is: "+x);
    }



}
