package navigation;

import enums.NavigationEnum;
import enums.Validation;
import utils.Input;

import java.util.List;

public class Navigation {

    public static void startNavigation(){
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
        return "Type any of the following commands " +
                "\nNew Lead : to create a new Lead in the database " +
                "\nShow Leads : to see all Leads in the database " +
                "\nLookup Lead : to find a single Lead " +
                "\nConvert Lead : to convert the Lead to a Contact, and create it's Opportunity and Account " +
                "\nChange status : to update an Opportunity's status to closed and lost or closed and won " +
                "\nExit : to close the CRM";
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

