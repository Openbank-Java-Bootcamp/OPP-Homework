package classes;

import enums.Product;
import enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Input;
import utils.Utils;

import java.util.UUID;

import static utils.Input.promptIntWithCheck;
import static utils.Utils.*;


import static utils.Input.promptIntWithValidation;
import static utils.Utils.printHeading;
import static utils.Utils.readInt;
import static utils.Utils.*;
@Getter
@Setter
@NoArgsConstructor
public class Opportunity {
    private String id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    ////////////////////////////////////////////////////////////Contructors/////////////////////////////////////////
    public Opportunity(String id, Product product, int quantity, Contact contact, Status status) {
        this.id = UUID.randomUUID().toString();
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = contact ;
        this.status = status;
    }


    ///////////////////////////////////////////////////////New Opportunity///////////////////////////////////////
    public static Opportunity createOpportunity(Contact leadContact){
        //Set ID
        String id= UUID.randomUUID().toString();

        //Set product
        printProductMenu();
        Product product=null;
        int input = Input.promptIntWithValidation("-> ", 3);
        if (input == 1) {
            //this.setProduct(Product.HYBRID);
            product = Product.HYBRID;
        } else if (input == 2) {
            product = Product.FLATBED;
        }else if (input == 3) {
            product = Product.BOX;
        }

        //Set quantity
        int quantity = promptIntWithCheck("Number of products for this Opportunity",  Integer.MAX_VALUE);


        //Tiene que agarrar el LEAD al que se le aplicó el metodo de generar oportunidad
        Contact lead = leadContact;

        //Set status
        Status status = Status.OPEN;

        Opportunity newOpportunity = new Opportunity(id, product, quantity, lead, status );
        printHeading(" \n Creating new Opportunity with  ID: "+ newOpportunity.toString());
        return newOpportunity;
    }

    ///////////////////////////////////////////////////////Change Opportunity Status///////////////////////////////////////
    public static void changeStatus(){
        //todo id input, then find Opportunity

        printStatusMenu();
        int input = Input.promptIntWithValidation("-> ", 3);
        if (input == 1) {
            opportunity.setStatus(status.OPEN);
        } else if (input == 2) {
            opportunity.setStatus(status.CLOSED_WON);
        }else if (input == 3) {
            opportunity.setStatus(status.CLOSED_LOST);
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

    public static void printStatusMenu(){
        clearConsole();
        printHeading(" \n Choose the status for this opportunity? \n ");
        printSeparator(20);
        System.out.println("(1) OPEN");
        System.out.println("(2) CLOSED_WON");
        System.out.println("(3) CLOSED_LOST");
    }

    @Override    public String toString() {
        return "Opportunity, id : %s, product: %s, quantity : %s, decisionMaker: %s, status: %s" +
                " \n==============\n".formatted(id, product, quantity, decisionMaker, status);
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
}
