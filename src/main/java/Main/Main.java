package Main;


import classes.Contact;
import classes.Opportunity;

import static classes.Opportunity.createOpportunity;
import static navigation.Navigation.createAccount;

public class Main {
    public static void main(String[] args) {

        //Test Account
        Contact newContact = new Contact("Mike");

        //CRea la oportunity primero y depsues la account
        createAccount(newContact,  createOpportunity(newContact));
    }
}
