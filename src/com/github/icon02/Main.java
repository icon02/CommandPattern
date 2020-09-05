package com.github.icon02;

import com.github.icon02.model.BikeShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BikeShop bikeShop = new BikeShop();

    public static void main(String ...args) {
        boolean running = true;
        while(running) {
            printMenu();
            String selection = readConsoleInput();
            switch (selection) {
                case "p": {
                    System.out.println("Current Stock: " + bikeShop.getStock());
                    break;
                }
                case "b": { // buy bikes
                    int amount = printAndReadAmount();
                    bikeShop.buy(amount);
                    break;
                }
                case "s": { // sell bikes
                    int amount = printAndReadAmount();
                    bikeShop.sell(amount);
                    break;
                }
                case "u": { // undo
                    bikeShop.undo();
                    break;
                }
                case "r": { // redo
                    bikeShop.redo();
                    break;
                }
                case "e": { // exit
                    running = false;
                    break;
                }
                default: {
                    System.out.print("Not available!");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("-----------------------------");
        System.out.println("Menu");
        System.out.println("-----------------------------");
        System.out.println("Print stock: p");
        System.out.println("Buy bikes: b");
        System.out.println("Sell bikes: s");
        System.out.println("Undo: u");
        System.out.println("Redo: r");
        System.out.println("Exit: e");
        System.out.println("-----------------------------");
        System.out.print("Select: ");
    }

    private static String readConsoleInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String output = null;
        try {
            output = reader.readLine();
        } catch (IOException ignored) {};

        return output;
    }

    private static int printAndReadAmount() {
        int amount = 0;
        boolean rightInput = false;

        while(!rightInput) {
            System.out.print("Amount: ");
            String amountString = readConsoleInput();
            try {
                amount = Integer.parseInt(amountString);
                rightInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number! Try again..");
            }
        }

        return amount;
    }
}
