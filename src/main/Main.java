package main;

import model.CircularLinkedList;

import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        int selection = 0;
        CircularLinkedList turnsList = new CircularLinkedList();

        while (!exit) {
            System.out.println("\n-----------------------------------------\n");
            System.out.println("Bancolombia System Menu\n");
            System.out.println("(1) Give turn");
            System.out.println("(2) Show actual turn");
            System.out.println("(3) Pass turn");
            System.out.println("(4) Eliminate actual turn");
            System.out.println("(5) Print all turns");
            System.out.println("(6) Exit");
            System.out.println("\n-----------------------------------------\n");
            selection = s.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("\nThe turn No. " + turnsList.giveTurn() + " was given");
                    System.out.println("Press enter to continue...");
                    s.nextLine();
                    s.nextLine();
                    break;
                case 2:
                    if (turnsList.getSize() != 0) {
                        System.out.println("\nThe actual turn is " + turnsList.getTurn().getValue());
                    } else {
                        System.out.println("\nThere aren't any turns in the list");
                    }

                    System.out.println("Press enter to continue...");
                    s.nextLine();
                    s.nextLine();
                    break;
                case 3:
                    if (turnsList.getSize() != 0) {
                        int passedTurnTimes = turnsList.getTurn().getPassedCounter() + 1;

                        System.out.print("\nThe turn No. " + turnsList.getTurn().getValue() + " was passed ");
                        System.out.print(turnsList.passTurn() ? "and was eliminated" : "and was not eliminated. It has been passed " +
                                passedTurnTimes + " times");
                    } else {
                        System.out.println("\nThere aren't any turns in the list");
                    }

                    System.out.println("\nPress enter to continue...");
                    s.nextLine();
                    s.nextLine();
                    break;
                case 4:
                    if (turnsList.getSize() != 0) {
                        System.out.println("\nThe turn No. " + turnsList.getTurn().getValue() + " has been eliminated");
                        turnsList.deleteTurn();
                    } else {
                        System.out.println("\nThere aren't any turns in the list");
                    }

                    System.out.println("Press enter to continue...");
                    s.nextLine();
                    s.nextLine();
                    break;
                case 5:
                    if (turnsList.getSize() != 0) {
                        turnsList.print();
                    } else {
                        System.out.println("\nThere aren't any turns in the list");
                    }

                    System.out.println("Press enter to continue...");
                    s.nextLine();
                    s.nextLine();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("\nThe introduced value is not valid");
                    System.out.println("Press enter to continue...");
                    s.nextLine();
                    s.nextLine();
                    break;
            }
        }
    }
}
