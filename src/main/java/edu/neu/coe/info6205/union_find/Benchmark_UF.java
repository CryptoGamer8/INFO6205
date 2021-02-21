package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

public class Benchmark_UF {

    public static void main(String[] args) {
        int nRuns = 10000;
        int sites = 625;
        Benchmark<Boolean> bm_doPC = new Benchmark_Timer<>("Union_Found_doPC", null,
                b -> UF_HWQUPC.count(sites,true),
                null);
        double x1 = bm_doPC.run(true, nRuns);
        System.out.println("Connect "+sites+" sites within "+x1+" ms");

        Benchmark<Boolean> bm_undoPC = new Benchmark_Timer<>("Union_Found_undoPC", null,
                b -> UF_HWQUPC.count(sites,false),
                null);
        double x2 = bm_undoPC.run(true,nRuns);
        System.out.println("Connect "+sites+" sites within "+x2+" ms");
    }
}
