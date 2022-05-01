package navigation;


import classes.Lead;

import enums.Validation;
import utils.Input;

import java.util.List;

import static utils.Utils.*;
import static utils.Utils.readString;

public class NewLeadNavigation {
    static Lead newLead;

    public static void createNewLead(Lead lead) {

        clearConsole();
        printHeading("Please input the following New Lead information");
        printSeparator(30);

        String newLeadName = readString("Insert the Lead name");

        String newLeadPhoneNumber = readString("Insert the Phone number");

        String newLeadEmail = readString("Insert the email");

        String companyName= readString("Insert the email");


        Lead newLead;
        newLead = new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName);
        newLead.getLeadList().add(lead);

        System.out.println(newLead);
    }
}
