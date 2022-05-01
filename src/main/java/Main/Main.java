package Main;


import classes.Contact;
import classes.Opportunity;

import static navigation.Navigation.createAccount;

public class Main {
    public static void main(String[] args) {

        //Test Account
        Contact newContact = new Contact("Mike");
        Opportunity newOpportunity = new Opportunity();

        createAccount(newContact, newOpportunity);


    }
}
