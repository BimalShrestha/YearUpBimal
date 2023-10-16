package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []array = {10,5,19,65,22};
        Arrays.sort(array);

        for(int element: array){
            System.out.println(element);
        }
    }
}