package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pick up date on **/**/**** format: ");
        String pickupDate = scanner.nextLine();
        /***************************************************/
        System.out.println("Enter the number of days for rental: ");
        int numberOfDays = scanner.nextInt();
        /***************************************************/
        System.out.println("Do you want tollTag answer true or false");
        boolean tollTag = scanner.nextBoolean();
        /***************************************************/
        System.out.println("Do you want gps answer true or false");
        boolean gps = scanner.nextBoolean();
        /***************************************************/
        System.out.println("Do you want road side assistance answer true or false");
        boolean roadSide = scanner.nextBoolean();
        /***************************************************/
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        double surcharge = 0;
            if (age < 25) {
                surcharge = 29.99 * numberOfDays * 0.03;
            } else {
            surcharge = 0;
            }
        double basicCarRental = 29.99 *numberOfDays;
        double totalCost = basicCarRental+surcharge + optionsCost(numberOfDays,tollTag,gps,roadSide);
        /***************************************************/
        System.out.printf("Your basic rental charge is %.2f," +
                " surcharge is %.2f, optionsCost is %.2f. The total cost is %.2f for date %s" +
                "",basicCarRental,surcharge,optionsCost(numberOfDays,tollTag,gps,roadSide),totalCost,pickupDate);
    }

        public static double optionsCost(int days, boolean tTag, boolean gPs, boolean roadS){
            double optionCost = 0;
            if (tTag) {
                optionCost += days * 3.95;
            }
            if (gPs) {
                optionCost += days * 2.95;
            }
            if (roadS) {
                optionCost += days * 3.95;
            }

            return optionCost;

        }
    }