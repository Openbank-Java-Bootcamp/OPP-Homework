package navigation;

import classes.Contact;
import classes.Opportunity;
import enums.Product;
import enums.Status;
import utils.Input;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static enums.Status.*;
import static utils.Input.promptIntWithCheck;
import static utils.Utils.*;

public class OpportunityNavigation {
    static List<Opportunity> opportunityList = new ArrayList<>();

    ///////////////////////////////////////////////////////New Opportunity///////////////////////////////////////
    public static Opportunity createOpportunity(Contact leadContact){


        //Set product
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

        //Set quantity
        int quantity = promptIntWithCheck("Number of products for this Opportunity",  Integer.MAX_VALUE);

        ///Set decision maker
        Contact lead = leadContact;

        //Set status
        Status status = OPEN;

        Opportunity newOpportunity = new Opportunity(product, quantity, lead, status );
        printHeading(" \nNew Opportunity: "+ newOpportunity.toString());
        opportunityList.add(newOpportunity);
        return newOpportunity;
    }

    ///////////////////////////////////////////////////////Change Opportunity Status///////////////////////////////////////
    // Opportunity status can be edited using the command “close-lost id” or “close-won id”
    // where “id” is the id of the Opportunity that should be closed.

    //Opcion 1
    public static void changeStatus(){
        int input = Input.promptIntWithCheck("Input the ID of the Opportunity to change status",
                opportunityList.size());

        Opportunity foundOpportunity = opportunityList.get(input-1);

        System.out.println(foundOpportunity + "\nOLD STATUS: "+ foundOpportunity.getStatus());

        printStatusMenu(foundOpportunity.getId());
        input = readInt("-> ", 3);
        if (input == 1) {
            foundOpportunity.setStatus(OPEN);
        } else if (input == 2) {
            foundOpportunity.setStatus(CLOSED_WON);
        }else if (input == 3) {
            foundOpportunity.setStatus(CLOSED_LOST);
        }

        //System.out.println(foundOpportunity + "\nNEW STATUS: "+ foundOpportunity.getStatus());
    }

    public static void closeLostOpportunity(String closeLost){
        if(closeLost.toLowerCase() == "close-lost" ){ //is "close lost" best? (no -)

            System.out.println("showing leads...");
        }else{
            utils.Utils.printLikeError( closeLost + " command not found");
            //throw new IllegalArgumentException( lookUpLeadID + " command not found"); //"No command line " + "arguments found."
        }
    }


    public static void closeWonOpportunity(String closeWon){
        if(closeWon.toLowerCase() == "close-won" ){

            System.out.println("showing leads...");
        }else{
            utils.Utils.printLikeError( closeWon + " command not found");
            //throw new IllegalArgumentException( lookUpLeadID + " command not found"); //"No command line " + "arguments found."
        }
    }

    ///////////////////////////////////////////////////////Menus///////////////////////////////////////
    public static void printProductMenu(){
        clearConsole();
        printHeading(" \n Choose a product for this opportunity? \n ");
        Utils.printSeparator(20);
        System.out.println("(1) HYBRID");
        System.out.println("(2) FLATBED");
        System.out.println("(3) BOX");
    }


    public static void printStatusMenu(String id){
        printHeading(" \n Choose the status for opportunity" + id+ " \n ");
        printSeparator(20);
        System.out.println("(1) OPEN");
        System.out.println("(2) CLOSED_WON");
        System.out.println("(3) CLOSED_LOST");
    }

}
