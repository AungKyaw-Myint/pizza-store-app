package org.puralsight.util;

import org.puralsight.model.Drink;
import org.puralsight.model.GarlicKnots;
import org.puralsight.model.Item;
import org.puralsight.model.Pizza;
import org.puralsight.service.impl.EventManager;
import org.puralsight.service.impl.FileWriterObserver;
import org.puralsight.service.impl.LoggerObserver;
import org.puralsight.service.impl.SmsObserver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Helpers {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static String readRequiredString(String prompt) {
        while (true) {
            String value = readString(prompt);
            if (!value.isBlank()) {
                return value;
            }
            System.out.println("This field is required. Please try again.");
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public static int readPositiveInt(String prompt) {
        while (true) {
            int number = readInt(prompt);
            if (number >= 0) {
                return number;
            }
            System.out.println("Please enter a positive number.");
        }
    }

    public static int readYear(String prompt) {
        while (true) {
            int year = readInt(prompt);
            if (year >= 1886 && year <= 2100) {
                return year;
            }
            System.out.println("Please enter a realistic vehicle year between 1886 and 2100.");
        }
    }

    public static boolean readBoolean(String prompt){
        while(true){
           String answer = readString(prompt);
           if (answer.equalsIgnoreCase("y")){
               return true;
           } else if(answer.equalsIgnoreCase("n")) {
               return false;
           }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number, for example 1995.00.");
            }
        }
    }

    public static double readPositiveDouble(String prompt) {
        while (true) {
            double number = readDouble(prompt);
            if (number >= 0) {
                return number;
            }
            System.out.println("Please enter a positive number.");
        }
    }

    public static void pause() {
        System.out.println();
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }

    public static String printDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return date.format(formatter);
    }

    public static void displayHeader() {
        System.out.println();
        System.out.println("┌─────────────────────────────────────────────┐");
        System.out.println("│        🍕 PIZZIO PIZZA SYSTEM 🍕            │");
        System.out.println("└─────────────────────────────────────────────┘");
    }

    public static void displayFooter(){
        System.out.println("───────────────────────────────────────────────");
    }

    public static void displayByName(String name) {
        System.out.println("──────────\t" + name + "\t──────────");
    }

    public static String getIcon(Item item){
        if(item instanceof Pizza){
            return "🍕";
        }else if (item instanceof Drink){
            return "🥤";
        }else if (item instanceof GarlicKnots){
            return "🧄";
        }

        return "";
    }
}
