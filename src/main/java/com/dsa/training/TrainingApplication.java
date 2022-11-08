package com.dsa.training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List result = new ArrayList<Object>();
        result.add(1);
        List arr = new ArrayList<Object>();
        arr.add(2);
        arr.add(2);
        result.add(arr);

        System.out.println(productSum(result));
    }


    public static int productSum(List<Object> array) {
        // Write your code here.

        return productSumHelper(0, 1, array);
    }

    public static int productSumHelper(int index, int depth, List<Object> array) {
        // Write your code here.
        if (array.size() == 0) {
            return -1;
        }
        if (index == array.size() - 1 && array.get(index) instanceof Integer) {
            return (int)  array.get(index);
        }
        if (index == array.size() - 1 && array.get(index) instanceof ArrayList) {
            return (depth+1)*productSumHelper(0, depth + 1, (ArrayList) array.get(index));
        }
        if (array.get(index) instanceof Integer) {
            return  (int) array.get(index) +  productSumHelper(index + 1, depth, array);
        } else {
            return (depth+1) * productSumHelper(0, depth + 1, (ArrayList) array.get(index)) +  productSumHelper(index + 1, depth, array);
        }
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        if (array.size() == 0) {
            List<List<Integer>> empty = new ArrayList<List<Integer>>();
            empty.add(new ArrayList<>());
            return empty;
        }
        Integer first = array.get(0);
        List<Integer> rest = new ArrayList<>(array);
        rest.remove(0);
        List<List<Integer>> powersetWithoutFirst = powerset(rest);
        List<List<Integer>> powersetWithFirst = new ArrayList<List<Integer>>();
        powersetWithoutFirst.forEach(powerset -> {
            List<Integer> temp = new ArrayList<>(powerset);
            temp.add(first);
            powersetWithFirst.add(temp);
        });

        List<List<Integer>> powerset = new ArrayList<List<Integer>>();
        powerset.addAll(powersetWithFirst);
        powerset.addAll(powersetWithoutFirst);
        return powerset;
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array.size() == 1) {
            List result = new ArrayList<List<Integer>>();
            result.add(array);
            return result;
        }
        List perm = new ArrayList<List<Integer>>();
        for (Integer number : array) {
            List tempArr = new ArrayList(array);
            tempArr.remove(number);
            List<List<Integer>> result = getPermutations(tempArr);
            result.forEach(
                    tempPerm
                            -> {
                        List tempPermCopy = new ArrayList(tempPerm);
                        tempPermCopy.add(0, number);
                        perm.add(tempPermCopy);
                    }
            );

        }

        return perm;
    }


    public static List<List<Integer>> getPermutations2(List<Integer> array) {
        if (array.size() == 0) {
            List<List<Integer>> empty = new ArrayList<List<Integer>>();
            empty.add(new ArrayList<>());
            return empty;
        }
        List<Integer> copy = new ArrayList<>(array);
        Integer firstLetter = copy.get(0);
        copy.remove(0);
        List<List<Integer>> permsWithoutFirst = getPermutations2(copy);
        List<List<Integer>> allPerms = new ArrayList<List<Integer>>();
        if (permsWithoutFirst.size() == 0) {
            permsWithoutFirst.add(new ArrayList<>());
        }
        permsWithoutFirst.forEach(perm -> {
            for (int i = 0; i <= perm.size(); i++) {
                List<Integer> tempPerm = new ArrayList<>();
                tempPerm.addAll(perm.subList(0, i));
                tempPerm.add(firstLetter);
                tempPerm.addAll(perm.subList(i, perm.size()));
                allPerms.add(tempPerm);
            }
        });
        return allPerms;

    }


    public static void getPermutations3(int index, List<Integer> array, List<List<Integer>> perms) {
        if (array.size() - 1 == index) {
            perms.add(new ArrayList<>(array));
            return;
        }
        for (int j = index; j < array.size(); j++) {
            Collections.swap(array, index, j);
            //swap index, j
            getPermutations3(index + 1, array, perms);
            //swap index,j
            Collections.swap(array, index, j);

        }


    }


    private int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    private int fib(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private String rev(String word) {
        if (word.length() == 1) return word;
        else
            return word.charAt(word.length() - 1) + rev(word.substring(0, word.length() - 1));
    }

    private String revit(String word) {
        String rev = "";
        for (char c : word.toCharArray()) {
            rev = c + rev;
        }
        return rev;
    }
}
