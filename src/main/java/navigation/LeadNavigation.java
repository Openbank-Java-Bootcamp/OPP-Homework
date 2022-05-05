package navigation;


import classes.Contact;
import classes.Lead;
import classes.Opportunity;
import enums.Validation;
import utils.Input;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static navigation.OpportunityNavigation.createOpportunity;
import static utils.Input.promptTextWithValidation;
import static utils.Utils.*;

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

        String newLeadName = promptTextWithValidation("Insert the Lead name", List.of(Validation.NAME));


        //todo Faltaría el Prompt int with Validation - phone number
        //Long newLeadPhoneNumber = Long.valueOf(Input.promptIntWithValidation("Insert the Phone number", Integer.MAX_VALUE));
        Long newLeadPhoneNumber= Long.valueOf(123);

        String newLeadEmail = promptTextWithValidation("Insert the email address", List.of(Validation.EMAIL));

        String companyName= promptTextWithValidation("Insert the Company name",List.of(Validation.STRING));



        leadList.add(new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName, leadList.size()+1));

        currentLead = leadList.get(leadList.size()-1);

        System.out.println(leadList.get(leadList.size()-1).toString());

        Utils.anythingToContinue();
        Utils.clearConsole();
        Navigation.startNavigation();
    }

    public static void showLeads(){
        if (!leadList.isEmpty()) {
            utils.Utils.printHeading("- Your current Leads - ");

            for (Lead lead : leadList) {
                if (!lead.getName().equals("Deleted Lead")) System.out.println(lead);
            }
            utils.Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        }  else {
            Utils.printLikeError("No Leads in the database, please create one");
            Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        }
    }

    public static void lookUpLeadID(){
        if (!leadList.isEmpty()) {
            int input = Input.promptIntWithValidation("Insert the ID you'd like to check: ", Integer.MAX_VALUE);

            System.out.println(leadList.get(input - 1).toString());

            utils.Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        }  else {
            Utils.printLikeError("No Leads in the database, please create one");
            Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        }
    }


    public static Contact createContact(Lead lead){
        Contact createdContact = null;

        createdContact = new Contact(lead);

        System.out.println("Successfully created the contact " + createdContact);

        return createdContact;
    }

    public static void convertLead(){

        if (!leadList.isEmpty()) {
            clearConsole();
            int input = Input.promptIntWithCheck("Input the ID of the Lead you want to convert", leadList.size());

            Lead foundLead = leadList.get(input - 1);

            currentContact = createContact(foundLead);

            Utils.anythingToContinue();

            contactList.add(currentContact);

            currentOpportunity = createOpportunity(currentContact);

            deleteLead();

            Utils.anythingToContinue();

            AccountNavigation.createAccount(currentContact, currentOpportunity);

            Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        } else {
            Utils.printLikeError("No Leads in the database, please create one");
            Utils.anythingToContinue();
            Utils.clearConsole();
            Navigation.startNavigation();
        }
    }

    public static void deleteLead(){

        System.out.println("Successfully deleted " + currentLead);

        leadList.get(currentLead.getLeadId()-1).setName("Deleted Lead");

        leadList.get(currentLead.getLeadId()-1).setPhoneNumber(0L);

        leadList.get(currentLead.getLeadId()-1).setEmail("Deleted Lead email");

        leadList.get(currentLead.getLeadId()-1).setCompanyName("Deleted Lead company name");


    }
}
