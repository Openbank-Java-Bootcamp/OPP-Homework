package navigation;

import classes.Lead;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeadNavigationTest {

    @BeforeEach //@BeforeAll
    public void setUp() {
    }

    @Test
    public void createNewLead_() {
        String newLeadName = "Mike";
        Long newLeadPhoneNumber = 956211567;
        String newLeadEmail = "MikeMichael@EmersonProduceCo.com"
        String companyName = "Emerson Produce Co."

         String email, companyName
        leadList.add(new Lead(newLeadName, newLeadPhoneNumber, newLeadEmail, companyName, leadList.size()+1));
        System.out.println(leadList.get(leadList.size()-1).toString());
    }

}