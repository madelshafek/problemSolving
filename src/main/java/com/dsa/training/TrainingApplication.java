package com.dsa.training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class TrainingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//		System.out.println(factorial(4));
//		System.out.println(fib(4));
//		System.out.println(rev("1234"));
//		System.out.println(revit("1234"));
//        List result = new ArrayList<Object>();
//        result.add(1);
//        List arr = new ArrayList<Object>();
//        arr.add(2);
//        arr.add(2);
//        result.add(arr);
        int arr[] = {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(Arrays.toString(twoNumberSum(arr, 10)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Hashtable<Integer, Integer> ht1 = new Hashtable<>();
        for (int i = 0; i < array.length; i++) {
            int remainder=targetSum-array[i];
            if(ht1.containsKey(remainder)){
                int arr[] = {array[i], ht1.get(remainder)};
                return arr;
            }else
            {
                ht1.put(array[i],array[i]);
            }



        }

        return new int[0];
    }

    public static int[] twoNumberSum1(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    int arr[] = {array[i], array[j]};
                    return arr;
                }
            }

        }


        // Write your code here.
        return new int[0];
    }
}
