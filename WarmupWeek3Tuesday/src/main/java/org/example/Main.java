package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            int result ;


            try {
                System.out.println("Enter the numerator");
                int numerator = scanner.nextInt();
                System.out.println("Enter the denominator");
                int denominator = scanner.nextInt();
                result = validateInput(numerator,denominator);
                System.out.println(result);
            } catch (ArithmeticException exe) {
                System.out.println("Arithmetic Exception: " + exe.getMessage());
                continue;
            } catch (InputMismatchException exe) {
                System.out.println("Input Mismatch Exception: " + exe.getMessage());
                scanner.nextLine();
                continue;
            }
            if (result >= 0){
                System.out.println("you got a valid result you are exiting the program");
                break;
            }
        }
    }

    public static int validateInput(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("The denominator cannot be zero");
        }
        if (numerator<0 || denominator < 0) {
            throw new InputMismatchException("Enter a valid input (positive number)");
        }
        /*if (numerator==null || denominator == null){
            throw new InputMismatchException("Enter integer input");
        }*/
        return numerator/denominator;
    }

}