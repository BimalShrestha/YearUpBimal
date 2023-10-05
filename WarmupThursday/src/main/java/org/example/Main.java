package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How's the weather today?");
        String weather = scanner.nextLine();
        if ("Sunny".equals(weather)){
            System.out.println("It's a great day fo outdoor activities!");

        }
        else if ("Cloudy".equals(weather)){
            System.out.println("The weather is a bit uncertain.");
        }
        else if ("Rainy".equals(weather)){
            System.out.println("Don't forget your umbrella!");
        }
        else
            System.out.println("Sorry, i'm not sure about that weather type");
    }
}