package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grade;
        do {
            System.out.println("Enter your numerical Score: ");
            grade = scanner.nextInt();
            if (90 <= grade && grade <= 100) {
                System.out.println("Grade A");
            } else if (80 <= grade && grade <= 89) {
                System.out.println("Grade B");
            } else if (70 <= grade && grade <= 79) {
                System.out.println("Grade C");
            } else if (60 <= grade && grade <= 69) {
                System.out.println("Grade D");
            } else if (grade < 60) {
                System.out.println("Grade F");
            } else
                System.out.println("Enter approprite grade");
        }



        while (0>grade || grade > 100 );
            
        scanner.close();
    }
}