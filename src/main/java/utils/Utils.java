package utils;

import classes.Lead;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static Scanner scanner = new Scanner(System.in);
    static String title = "CRM Program";
    private List<Lead> leads = new ArrayList<>();

    public static void printLikeError(String message) {
        System.out.println((char) 27 + "[31m" + message);
        System.out.print((char) 27 + "[39m");
    }

    /**
     * Method to catch errors from user int input
     *
     * @param prompt      will be the string that appears in CRM
     * @param userChoices maximum number of choices the user has
     * @return the number the user chose
     */
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter a valid number!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }


    /////////////////////////////////// Method to catch errors from user int input /////////////////////////////////////


    public static String readString(String prompt) {
        String input = null;

        do {
            System.out.println(prompt);
            try {
                input = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a valid integer!");
            }
        } while (scanner.hasNextDouble() || scanner.hasNextInt() || scanner.hasNextFloat() || scanner.hasNextByte() ||
                scanner.hasNextLong() || scanner.hasNextBoolean());
        return input;
    }


    /**
     * Method to catch errors from user int input with limits
     *
     * @param prompt will be the string that appears in CRM
     * @param min    limits
     * @param max
     * @return the number the user chose
     */
    private static int readIntLimited(String prompt, int min, int max) {
        int input = 0;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer!");
            }
        } while (input < min || input > max);
        return input;
    }


    ///////////////////////////// CLear console /////////////////////////////////

    public static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    //////////////////////////// Print separator ///////////////////////////////
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /////////////////////////// Print heading //////////////////////////////////
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    /////////////////////////// Anything to continue ///////////////////////////
    public static void anythingToContinue() {
        System.out.println("\nPlease Enter any command to continue...");
        scanner.next();
    }

    /////////////////////////// Start program //////////////////////////////////
    public static void startProgram() {
        System.out.println(title);
        anythingToContinue();

    }

    ////////////////////////////////New Lead Menu ////////////////////////////////////////////////

    public void addNewLead(Lead newLead) {
        leads.add(newLead);
    }

    ///////////////////////////////Show Lead Menu ///////////////////////////////////////////////
    public void showLeads() {
        for (Lead lead : leads) {
            System.out.println(leads.toString());
        }
    }


}
