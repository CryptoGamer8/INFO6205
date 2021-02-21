package edu.neu.coe.info6205;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList(Arrays.asList(1,2,3,4,5));
        for (int i = 0; i <arr.size() ; i++) {
            System.out.println(arr.get(i));
        }
    }
}
