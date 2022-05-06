package navigation;

import classes.Contact;
import classes.Opportunity;
import enums.Product;
import enums.Status;
import enums.Validation;
import utils.Input;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static enums.Status.*;
import static utils.Input.promptIntWithCheck;
import static utils.Utils.*;

public class OpportunityNavigation {
    static List<Opportunity> opportunityList = new ArrayList<>();

    public static Opportunity createOpportunity(Contact leadContact){

        printProductMenu();
        Product product=null;
        int input = Input.promptIntWithValidation("-> ", 3);
        if (input == 1) {
            product = Product.HYBRID;
        } else if (input == 2) {
            product = Product.FLATBED;
        }else if (input == 3) {
            product = Product.BOX;
        }

        int quantity = promptIntWithCheck("Number of products for this Opportunity",  Integer.MAX_VALUE);

        Contact lead = leadContact;


        Status status = OPEN;

        Opportunity newOpportunity = new Opportunity(product, quantity, lead, status );
        printHeading(" \nNew Opportunity: "+ newOpportunity.toString());
        opportunityList.add(newOpportunity);
        return newOpportunity;
    }

    public static void changeStatus(){

        if(!opportunityList.isEmpty()){
        Opportunity foundOpportunity = null;
        int newInput;

        String input = Input.promptTextWithValidation("Input the ID of the Opportunity to change status",
                List.of(Validation.STRING));

        for (Opportunity opportunity : opportunityList){
            if (input.equals(opportunity.getId())){
                foundOpportunity = opportunity;

                printStatusMenu(foundOpportunity.getId());
                newInput = readInt("-> ", 3);

                if (newInput == 1) {
                    foundOpportunity.setStatus(OPEN);
                } else if (newInput == 2) {
                    foundOpportunity.setStatus(CLOSED_WON);
                }else if (newInput == 3) {
                    foundOpportunity.setStatus(CLOSED_LOST);
                }

                System.out.println(foundOpportunity + "\nNEW STATUS: "+ foundOpportunity.getStatus().toString().toLowerCase());

                Utils.anythingToContinue();
                Utils.clearConsole();
                Navigation.startNavigation();
            }
        }
            for (Opportunity opportunity : opportunityList){
                System.out.println( "Opportunity ID: "+ opportunity.getId() + " -> Decision Maker: " +opportunity.getDecisionMaker());
            }

        } else {
            Utils.printLikeError("No Opportunities in the database, please create one");
            Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        }

    }


    public static void printProductMenu(){
        clearConsole();
        printHeading(" \n Choose a product for this opportunity? \n ");
        Utils.printSeparator(20);
        System.out.println("(1) HYBRID");
        System.out.println("(2) FLATBED");
        System.out.println("(3) BOX");
    }


    public static void printStatusMenu(String id){
        printHeading(" \n Choose the status for opportunity " + id+ " \n ");
        printSeparator(20);
        System.out.println("(1) OPEN");
        System.out.println("(2) CLOSED WON");
        System.out.println("(3) CLOSED LOST");
    }

}
