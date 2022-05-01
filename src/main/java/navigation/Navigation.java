package navigation;

import classes.Account;
import classes.Contact;
import classes.Opportunity;
import enums.Industry;
import enums.Validation;
import utils.Input;

import java.util.List;

import static utils.Utils.*;

public class Navigation {

    //TODO add other steps here

    /**
     * @param contact
     * @param opportunity
     */
    public static void createAccount(Contact contact, Opportunity opportunity) {
        Industry industry = null;

        clearConsole();
        printHeading("Please input the following Account information");
        printSeparator(30);

        industry = selectIndustry(industry);

        int employeeCount = Input.promptIntWithCheck("Number of employees", "Are you sure it's correct?",  Integer.MAX_VALUE);

        String city = readString("City of Account");

        String country = Input.promptTextWithValidation("Country of Account", List.of(Validation.COUNTRY));


        Account newAccount = new Account(industry, employeeCount, city, country);
        newAccount.getContactList().add(contact);
        newAccount.getOpportunityList().add(opportunity);

        System.out.println(newAccount);
    }

    private static Industry selectIndustry(Industry industry) {
        String typesAccountMenu = "\n (1) Produce \n (2) Ecommerce \n (3) Manufacturing \n (4) Medical \n (5) Other";

        int input = Input.promptIntWithValidation("Select type of industry" + typesAccountMenu, 5);

        switch (input) {
            case 1 -> industry = Industry.PRODUCE;
            case 2 -> industry = Industry.ECOMMERCE;
            case 3 -> industry = Industry.MANUFACTURING;
            case 4 -> industry = Industry.MEDICAL;
            case 5 -> industry = Industry.OTHER;
        }
        return industry;
    }
}
