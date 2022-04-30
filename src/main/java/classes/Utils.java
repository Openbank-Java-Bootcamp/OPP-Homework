package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    static Scanner scanner = new Scanner(System.in);
    static String title = "CRM Program";

    private List<Lead> leads = new ArrayList<>();

        ///////////////////////////// User input /////////////////////////////////
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter a valid command!");
            }
        } while (input < 1 || input > userChoices);
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


        //credits();

        //into();

        //naming both parties who will battle
//        clearConsole();
//        System.out.println("\n ✨ Go ahead, create your First Party ✨ \n");
//        printSeparator(30);
//        party1 = new Party(setAttribute("Name the First Party which will follow you to battle: ",
//                "Party name"));
//        clearConsole();
//        printHeading("\n\n\n ✨ Your Party  ↂ" + party1.getPartyName() + "ↂ was Created ✨ \n\n\n");
//        printSeparator(30);
//
//        clearConsole();
//        printHeading("  \nGet ready to create the second party!\n");
//        anythingToContinue();
//
//        clearConsole();
//        System.out.println("\n ✨ Go ahead, create your Second Party ✨ \n");
//        party2 = new Party(setAttribute("\n -> Name the Second Party which will follow you to battle: ", "Party name"));
//
//        clearConsole();
//        printHeading("\n\n\n ✨ Your Party  ↂ" + party2.getPartyName() + "ↂ was Created ✨ \n\n\n");
//        anythingToContinue();
    }

    ////////////////////////////////New Lead Menu ////////////////////////////////////////////////

    public void addNewLead(Lead newLead) {
                leads.add(newLead);
    }

    ///////////////////////////////Show Lead Menu ///////////////////////////////////////////////
    public void showLeads(){
        for (Lead lead : leads) {
           System.out.println(leads.toString());
        }
    }



}
