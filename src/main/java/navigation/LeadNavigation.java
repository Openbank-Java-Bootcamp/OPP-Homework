package navigation;


import classes.Lead;

import static utils.Utils.*;
import static utils.Utils.readString;

public class LeadNavigation {
    static Lead newLead;

    public static void createNewLead(Lead lead) {

        clearConsole();
        printHeading("Please input the following New Lead information");
        printSeparator(30);

        String newLeadName = readString("Insert the Lead name");

        String newLeadPhoneNumber = readString("Insert the Phone number");

        String newLeadEmail = readString("Insert the email");

        String companyName= readString("Insert the Company name");


        Lead newLead;
        newLead = new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName);
        newLead.getLeadList().add(lead);

        System.out.println(newLead.toString());
    }
}
