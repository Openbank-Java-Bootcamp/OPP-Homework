package classes;

import enums.Product;
import enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Input;
import utils.Utils;

import java.util.UUID;

import static utils.Input.promptIntWithCheck;
import static utils.Utils.*;


import static utils.Utils.printHeading;
import static utils.Utils.readInt;
@Getter
@Setter
@NoArgsConstructor
public class Opportunity {
    private String id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(Product product, int quantity, Contact contact, Status status) {
        this.id = UUID.randomUUID().toString();
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = contact ;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return ("Opportunity ID: %s \n Product: %s, \n Quantity : %s, " +
                "\n Decision Maker: %s, \n Status: %s").formatted(id, product.toString().toLowerCase(), quantity, decisionMaker, status.toString().toLowerCase());
    }

}
