package com.techelevator;

import com.techelevator.view.Product;

import java.util.Scanner;

public class CoinBank {
    private static double currentBalance = 0.0;
    private static final double NICKEL = 0.05;
    private static final double DIME = 0.10;
    private static final double QUARTER = 0.25;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("(1) Purchase");
            System.out.println("(2) Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    purchase(scanner);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void purchase(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.printf("Current money provided: $%.2f\n", currentBalance);
            System.out.println("Select an option:");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    feedMoney(scanner);
                    break;
                case 2:
                    selectProduct(scanner);
                    break;
                case 3:
                    exit = true;
                    returnMoney();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void returnMoney() {
        //calculation pending
    }

    private static void feedMoney(Scanner scanner) {
        System.out.println("Insert a dollar amount (whole dollars only):");
        int dollars = scanner.nextInt();
        currentBalance += dollars;
        System.out.printf("Current money provided: $%.2f\n", currentBalance);
    }

    private static void selectProduct(Scanner scanner) {
        System.out.println("Available products:");
      // code pending

        System.out.println("Enter product code:");
        String code = scanner.next();


        Product prod=new Product();

        if (prod.getCode() == null) {
            System.out.println("Invalid product code. Please try again.");
        } else if (prod.getQuantity() == 0) {
            System.out.println("Product is sold out. Please try again.");
        } else if (prod.getPrice() > currentBalance) {
            System.out.println("Insufficient funds. Please add more money.");
        } else {
            prod.getName();
            currentBalance -= prod.getPrice();
            System.out.printf("Dispensing %s ($%.2f). Money remaining: $%.2f\n", prod.getName(), prod.getPrice(), currentBalance);
            switch (prod.getCateogry()) {


                case CHIP:
                    System.out.println("Crunch Crunch, Yum!");
                    break;
                case CANDY:
                    System.out.println("Munch Munch, Yum!");
                    break;
                case DRINK:
                    System.out.println("Glug Glug, Yum!");
                    break;
                case GUM:
                    System.out.println("Chew Chew, Yum!");
                    break;
                default:
                    System.out.println("Finish Transaction");
            }
        }
    }
    }






