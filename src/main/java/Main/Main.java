package Main;


import navigation.LeadNavigation;
import navigation.OpportunityNavigation;

import static navigation.LeadNavigation.convertLead;
import static navigation.LeadNavigation.createNewLead;
import static navigation.OpportunityNavigation.changeStatus;


public class Main {
    public static void main(String[] args) {


        //Test Account
        //Contact newContact = new Contact("Mike", "61234589311", "mike@mike.com", "Ironhack");


        //CRea la oportunity primero y depsues la account
        //createAccount(newContact,  createOpportunity(newContact));

//        LeadNavigation.createNewLead();
//        LeadNavigation.showLeads();
//       LeadNavigation.lookUpLeadID();
//
//        LeadNavigation.convertLead();

        createNewLead();

        createNewLead();
        convertLead();

        changeStatus();

    }
}
