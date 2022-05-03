package navigation;


import classes.Lead;
import utils.Input;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Utils.*;
import static utils.Utils.readString;

public class LeadNavigation {
    //static Lead newLead;
    static int counterId = 0;

//    static Map< Integer, Lead> leadMap = new HashMap<>();
    static List<Lead> leadList = new ArrayList<>();

    public static void createNewLead() {

        clearConsole();
        printHeading("Please input the following New Lead information");
        printSeparator(30);

        String newLeadName = readString("Insert the Lead name");

        //Sorry Lucy, te tocamos el codigo. Faltaría el Prompt int with Validation - phone number
        Long newLeadPhoneNumber = Long.valueOf(readInt("Insert the Phone number", Integer.MAX_VALUE));

        String newLeadEmail = readString("Insert the email");

        String companyName= readString("Insert the Company name");


        leadList.add(new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName, leadList.size()+1));
        System.out.println(leadList.get(leadList.size()-1).toString());
    }

    ///////////////////////////////Show Lead Menu ///////////////////////////////////////////////
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

}
