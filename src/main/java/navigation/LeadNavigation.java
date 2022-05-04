package navigation;


import classes.Contact;
import classes.Lead;
import classes.Opportunity;
import utils.Input;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Utils.*;
import static utils.Utils.readString;

public class LeadNavigation {

    static int counterId = 0;

    static List<Lead> leadList = new ArrayList<>();

    static Contact currentContact;
    static Lead currentLead;
    static Opportunity currentOpportunity;

    static Map<String, Contact> contactMap = new HashMap<>();
    static List<Contact> contactList = new ArrayList<>();

    public static void createNewLead() {

        clearConsole();
        printHeading("Please input the following New Lead information");
        printSeparator(30);

        String newLeadName = readString("Insert the Lead name");

        //todo Faltaría el Prompt int with Validation - phone number
        Long newLeadPhoneNumber = Long.valueOf(Input.promptIntWithValidation("Insert the Phone number", Integer.MAX_VALUE));

        String newLeadEmail = readString("Insert the email");

        String companyName= readString("Insert the Company name");


        leadList.add(new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName, leadList.size()+1));
        System.out.println(leadList.get(leadList.size()-1).toString());
    }

    public static void showLeads(){
        utils.Utils.printHeading("- Your current Leads - ");

        for(Lead lead : leadList) {
            System.out.println(lead.toString());
        }
        utils.Utils.anythingToContinue();
    }

    public static void lookUpLeadID(){
        int input = Input.promptIntWithValidation("Insert the ID you'd like to check: ", Integer.MAX_VALUE);

        System.out.println(leadList.get(input - 1).toString());

        utils.Utils.anythingToContinue();
    }


    public static Contact createContact(Lead lead){
        Contact createdContact = null;

        createdContact = new Contact(lead);

        return createdContact;
    }

    public static void convertLead(){

        int input = Input.promptIntWithCheck("Input the ID of the Lead you want to convert", leadList.size());

        Lead foundLead = leadList.get(input-1);

        currentContact = createContact(foundLead);

        contactList.add(currentContact);

        currentOpportunity = Opportunity.createOpportunity(currentContact);

        AccountNavigation.createAccount(currentContact, currentOpportunity);



    }

    //TODO method to "delete" Lead
}
