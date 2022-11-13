package com.dsa.training.problems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

//@SpringBootApplication
public class SortedSquaredArray implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SortedSquaredArray.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int arr[] = {-7, -3, 1, 9, 22, 30};
//        List seq = Arrays.asList(3, 11, 6);
        System.out.println(Arrays.toString(sortedSquaredArray(arr)));
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int start = 0;
        int end = array.length - 1;
        int i = end;
        while (start <= end) {
            int endSquare = array[end] * array[end];
            int startSqare = array[start] * array[start];
            if (startSqare < endSquare) {
                result[i] = endSquare;
                end--;
            } else {
                result[i] = startSqare;
                start++;
            }
            i--;
        }
        return result;
    }

    public static int[] sortedSquaredArray3(int[] array) {
        int[] result = new int[array.length];
        int resultIndex = 0;
        int negativeIndex = array.length;
        int i = 0;
        while (i < array.length) {
            int square = array[i] * array[i];
            if (array[i] >= 0) {
                if (negativeIndex == array.length || square < result[negativeIndex]) {
                    result[resultIndex++] = square;
                    i++;
                } else {
                    result[resultIndex++] = result[negativeIndex++];
                }
            } else {
                result[--negativeIndex] = square;
                i++;
            }
        }
        return result;
    }

    public static int[] sortedSquaredArray2(int[] array) {
        int[] positive = new int[array.length];
        int[] negative = new int[array.length];
        int[] result = new int[array.length];
        int positiveIndex = -1;
        int negativeIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int square = array[i] * array[i];
            if (array[i] >= 0) {
                positive[++positiveIndex] = square;
            } else {
                negative[++negativeIndex] = square;
            }
        }
        if (positiveIndex == array.length - 1) {
            return positive;
        }
        int positiveLength = positiveIndex + 1;
        int negativeLength = negativeIndex + 1;
        negativeIndex = 0;
        int resultIndex = array.length - 1;
        while (resultIndex >= 0) {
            if (positiveIndex == -1 || positive[positiveIndex] < negative[negativeIndex]) {
                result[resultIndex] = negative[negativeIndex++];
            } else {
                result[resultIndex] = positive[positiveIndex--];
            }
            resultIndex--;


        }


        // Write your code here.
        return result;
    }

    public static int[] sortedSquaredArray1(int[] array) {
        int[] result = new int[array.length];
        int[] negative = new int[array.length];
        int resultIndex = 0;
        int negativeIndexEnd = -1;
        for (int i = 0; i < array.length; i++) {
            int square = array[i] * array[i];
            if (array[i] >= 0) {
                if (negativeIndexEnd == -1) {
                    result[resultIndex] = square;
                } else {
                    if (square < negative[negativeIndexEnd]) {
                        result[resultIndex] = square;
                    } else {
                        result[resultIndex] = negative[negativeIndexEnd];
                        negativeIndexEnd--;
                        i--;
                    }
                }
                resultIndex++;
            } else {
                negativeIndexEnd++;
                negative[negativeIndexEnd] = square;
                result[resultIndex] = square;

            }


        }

        // Write your code here.
        return result;
    }

}
