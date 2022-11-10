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
        List arr = Arrays.asList(3, 5, -4, 8, 11, 1, -1, 6);
        List seq = Arrays.asList(3, 11, 6);
        System.out.println(isValidSubsequence(arr, seq));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        if (array.isEmpty() || sequence.isEmpty()) {
            return false;
        }
        int seqIndex = 0;
        int arrIndex = 0;
        while (arrIndex < array.size() && seqIndex < sequence.size()) {

            if (array.get(arrIndex).equals(sequence.get(seqIndex))) {
                seqIndex++;
            }
            arrIndex++;
        }
        return seqIndex == sequence.size();
    }


    public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {

        if (array.isEmpty() || sequence.isEmpty()) {
            return false;
        }
        int index = 0;
        for (Integer num : array) {
            if (index == sequence.size()) {
                break;
            }
            if (num == sequence.get(index)) {
                index++;
            }
        }
        return index == sequence.size();
    }

}
