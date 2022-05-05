package navigation;

import classes.Account;
import classes.Contact;
import classes.Opportunity;
import enums.Industry;
import enums.Validation;
import utils.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Input.promptIntWithCheck;
import static utils.Utils.*;


public class AccountNavigation {
    static Map<String, Account> contactMap = new HashMap<>();

    /**
     * @param contact
     * @param opportunity
     */
    public static void createAccount(Contact contact, Opportunity opportunity) {
        Industry industry = null;

        //TODO yo lo sacaria a este clean console o lo pondria mas pequeño
        clearConsole();
        printHeading("Please input the following Account information");
        printSeparator(30);

        industry = selectIndustry();

        int employeeCount = promptIntWithCheck("Number of employees",  Integer.MAX_VALUE);

        String city = Input.promptTextWithValidation("City of Account", List.of(Validation.STRING));

        String country = Input.promptTextWithValidation("Country of Account", List.of(Validation.COUNTRY));


        Account newAccount = new Account(industry, employeeCount, city, country);
        newAccount.getContactList().add(contact);
        newAccount.getOpportunityList().add(opportunity);

        System.out.println("Successfully created " + newAccount);
    }

    private static Industry selectIndustry() {
        String typesAccountMenu = "\n (1) Produce \n (2) Ecommerce \n (3) Manufacturing \n (4) Medical \n (5) Other";
        Industry industry = null;
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
