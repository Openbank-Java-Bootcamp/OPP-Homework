package classes;

import enums.Product;
import enums.Status;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static utils.Utils.*;

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
        this.decisionMaker = decisionMaker ;
        this.status = status;
    }

    ///////////////////////////////////////////////////////////Getters ///////////////////////////////////////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    ///////////////////////////////////////////////////////New Opportunity///////////////////////////////////////
    public void newOpportunity(Contact leadContact){
//        Product product = this.getProduct();
        //Set ID
        printHeading(" \n Creating new Opporunity with  ID: "+ this.getId());

        //Set product
        printProductMenu();
        int input = readInt("-> ", 3);
        if (input == 1) {
            this.setProduct(Product.HYBRID);
        } else if (input == 2) {
            this.setProduct(Product.FLATBED);
        }else if (input == 3) {
            this.setProduct(Product.BOX);
        }

        //Set quantity
        this.setQuantity(QuantityOptions("\n Numbers of products being considered for this opportunity? \n",
                "quantity"));

        //Tiene que agarrar el LEAD al que se le aplicó el metodo de generar oportunidad
        this.setDecisionMaker(leadContact);

        this.setStatus(Status.OPEN);
    }

    ///////////////////////////////////////////////////////Change Opportunity Status///////////////////////////////////////
    private void changeStatus(){
        printStatusMenu();
        int input = readInt("-> ", 3);
        if (input == 1) {
            this.setStatus(status.OPEN);
        } else if (input == 2) {
            this.setStatus(status.CLOSED_WON);
        }else if (input == 3) {
            this.setStatus(status.CLOSED_LOST);
        }
    }

    ///////////////////////////////////////////////////////Menus///////////////////////////////////////
    private void printProductMenu(){
            clearConsole();
            printHeading(" \n Choose a product for this opportunity? \n ");
            printSeparator(20);
            System.out.println("(1) HYBRID");
            System.out.println("(2) FLATBED");
            System.out.println("(3) BOX");
        }

    private static int QuantityOptions(String header, String product) {
        clearConsole();
        //printHeading();
        boolean quantitySet = false;
        int quantity = 0;

        do {
            printHeading(header);
            //quantity = scanner.next(); //TODO ver si lo ponemos en utils o definirlo aca
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading(quantity + product + "is enough for this Opportunity?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to correct it");
            int input = readInt("-> ", 2);
            if (input == 1) {
                quantitySet = true;
            }
        } while (!quantitySet);

        return quantity;
    }

    private void printStatusMenu(){
        clearConsole();
        printHeading(" \n Choose the status for this opportunity? \n ");
        printSeparator(20);
        System.out.println("(1) OPEN");
        System.out.println("(2) CLOSED_WON");
        System.out.println("(3) CLOSED_LOST");
    }



}
