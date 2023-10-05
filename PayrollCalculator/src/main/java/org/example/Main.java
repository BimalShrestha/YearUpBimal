package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String fullName = scanner.nextLine();
        System.out.println("Enter your hours worked: ");
        double hoursWorked = scanner.nextDouble();
        System.out.println("Enter your pay Rate: ");
        double payRate = scanner.nextDouble();
        double grossPay = hoursWorked * payRate;
        System.out.printf("%s worked %.2f hours with %.2f pay rate and earned %.2f gross pay", fullName,hoursWorked,payRate,grossPay);

    }
}