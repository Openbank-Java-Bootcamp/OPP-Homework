package navigation;

import static utils.Utils.*;

import classes.Opportunity;
import enums.NavigationEnum;

public class Navigation {

    public void startNavigation(){

        commandMenu();

//        Enum selected = selectNavigation();

//        switch (selected) {
//            case NavigationEnum.NEW_LEAD -> LeadNavigation.createNewLead();
//            case NavigationEnum.SHOW_LEADS -> LeadNavigation.showLeads();
//            case NavigationEnum.CHANGE_STATUS -> Opportunity.changeStatus();
//        }

    }

    private void commandMenu() {
        printHeading("Type any of the following commands");
        System.out.println("New Lead : to create a new Lead in the database");
        System.out.println("Show Leads : to see all Leads in the database");
        System.out.println("Lookup Lead : to find a single Lead");
        System.out.println("Convert Lead : to convert the Lead to a Contact, and create it's Opportunity and Account");
        System.out.println("Close-lost : to update an Opportunity's status as closed and lost");
        System.out.println("Close-won : to update an Opportunity's status as closed and won");
        System.out.println("Exit : to close the CRM");
    }

    private static Enum selectNavigation() {
        Enum selected = null;

        //int input = Input.promptIntWithValidation("Select type of industry" + typesAccountMenu, 5);
        //TODO crear validación para cada una de las opciones
        String input =readString(" ");

        switch (input) {
            case "new lead" -> selected = NavigationEnum.NEW_LEAD;
            case "show loads" -> selected = NavigationEnum.SHOW_LEADS;
            case "lookup lead" -> selected = NavigationEnum.LOOKUP_LEAD;
            case "convert lead" -> selected = NavigationEnum.CONVERT_LEAD;
            case "change status" -> selected = NavigationEnum.CHANGE_STATUS;
            case "exit" -> selected = NavigationEnum.EXIT;
        }
        return selected;
    }
}

