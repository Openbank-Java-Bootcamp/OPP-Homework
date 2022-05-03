package navigation;


import classes.Lead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Utils.*;
import static utils.Utils.readString;

public class LeadNavigation {
    static Lead newLead;
    static int counterId = 0;

//    static Map< Integer, Lead> leadMap = new HashMap<>();
    static List<Lead> leadList = new ArrayList<>();

    public static void createNewLead(Lead lead) {

        clearConsole();
        printHeading("Please input the following New Lead information");
        printSeparator(30);

        String newLeadName = readString("Insert the Lead name");

        String newLeadPhoneNumber = readString("Insert the Phone number");

        String newLeadEmail = readString("Insert the email");

        String companyName= readString("Insert the Company name");


        leadList.add(new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName, leadList.size()+1));


        System.out.println(newLead.toString());
    }
}
