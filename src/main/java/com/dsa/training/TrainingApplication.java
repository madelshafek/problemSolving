package com.dsa.training;

import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
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
        int arr[] = {-7, -3, 1, 9, 22, 30};
//        List seq = Arrays.asList(3, 11, 6);
//        System.out.println(Arrays.toString(sortedSquaredArray(arr)));
    }

}
