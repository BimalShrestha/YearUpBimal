package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double firstNumber = scanner.nextDouble();
        System.out.println("Enter the second number: ");
        double secondNumber = scanner.nextDouble();
        System.out.println("Possible calculations: (A)dd, (S)ubtract  (M)ultiply, (D)ivide Please select an option: ");
        System.out.printf("The result is: %.2f", result(firstNumber, secondNumber));
    }
    public static double result(double firstNumber, double secondNumber ){
        Scanner scanner = new Scanner(System.in);
        String possibleCalculations = scanner.nextLine();
        double result  = 0;
        if (possibleCalculations.equalsIgnoreCase("A")) {
            result = firstNumber + secondNumber;
        }
        else if (possibleCalculations.equalsIgnoreCase("S")) {
            result = firstNumber - secondNumber;
        }
        else if (possibleCalculations.equalsIgnoreCase("M")) {
            result = firstNumber * secondNumber;
        }
        else if (possibleCalculations.equalsIgnoreCase("D")) {
            result = firstNumber / secondNumber;
        }
        else System.out.println("Its the wrong input: ");
        return result;


    }

}


