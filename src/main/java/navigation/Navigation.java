package navigation;

import enums.NavigationEnum;
import enums.Validation;
import utils.Input;

import java.util.List;

public class Navigation {

    public static void startNavigation() {
        NavigationEnum selected = null;
        selected = selectNavigation();

        switch (selected) {
            case NEW_LEAD -> LeadNavigation.createNewLead();
            case SHOW_LEADS -> LeadNavigation.showLeads();
            case LOOKUP_LEAD -> LeadNavigation.lookUpLeadID();
            case CONVERT_LEAD -> LeadNavigation.convertLead();
            case CHANGE_STATUS -> OpportunityNavigation.changeStatus();
            case EXIT -> Navigation.exit();
        }
    }


    private static void exit() {
        System.out.println("Bye!");
    }

    private static String commandMenu() {

        return "\n ------------------------------- " +
                (char) 27 + "[35m" + "\nType any of the following commands" + (char) 27+ "[39m" +
                "\n ------------------------------- " +
                (char) 27 + "[34m" + "\nNew Lead : " + (char) 27 + "[39m" + "to create a new Lead in the database " +
                (char) 27 + "[34m" + "\nShow Leads : " + (char) 27 + "[39m" + "to see all Leads in the database " +
                (char) 27 + "[34m" + "\nLookup Lead : " + (char) 27 + "[39m" + "to find a single Lead " +
                (char) 27 + "[34m" + "\nConvert Lead : " + (char) 27 + "[39m" + "to convert the Lead to a Contact, and create it's Opportunity and Account" +
                (char) 27 + "[34m" + "\nChange status : " + (char) 27 + "[39m" + "to update an Opportunity's status to closed and lost or closed and won " +
                (char) 27 + "[36m" + "\nExit : " + (char) 27 + "[39m" + " to close the CRM";

    }

    private static NavigationEnum selectNavigation() {
        NavigationEnum selected = null;

        String input = Input.promptTextWithValidation(commandMenu(), List.of(Validation.COMMAND));

        switch (input.toLowerCase().trim()) {
            case "new lead" -> selected = NavigationEnum.NEW_LEAD;
            case "show leads" -> selected = NavigationEnum.SHOW_LEADS;
            case "lookup lead" -> selected = NavigationEnum.LOOKUP_LEAD;
            case "convert lead" -> selected = NavigationEnum.CONVERT_LEAD;
            case "change status" -> selected = NavigationEnum.CHANGE_STATUS;
            case "exit" -> selected = NavigationEnum.EXIT;
        }
        return selected;
    }
}

