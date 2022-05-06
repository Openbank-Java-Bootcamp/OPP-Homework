package utils;

import classes.Contact;
import classes.Opportunity;
import enums.Product;
import enums.Status;
import navigation.OpportunityNavigation;
import org.junit.jupiter.api.Test;

import static enums.Validation.PHONE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {


    @Test
    public void applyValidation_ValidationEnumAndStringInput_Boolean() {
        assertTrue(Validator.applyValidation(PHONE, "(202) 555-0125"));
        assertFalse(Validator.applyValidation(PHONE, "(hola) 555-0125"));
    }

    @Test
    public void isValidCountryName_String_Boolean() {
        assertTrue(Validator.isValidCountryName("Argentina"));
        assertFalse(Validator.isValidCountryName("Argentonia"));
    }

    @Test
    public void isValidName_String_Boolean() {
        assertTrue(Validator.isValidName("Maria Antonia"));
        assertFalse(Validator.isValidName("M@riantonia"));
    }

    @Test
    public void isValidOpportunityId_String_Boolean() {
        OpportunityNavigation.opportunityList.add(new Opportunity(Product.FLATBED, 21, new Contact("Mike",
                956211567L, "MikeMichael@EmersonProduceCo.com", "Emerson Produce Co."),
                Status.OPEN));
        assertTrue(Validator.isValidOpportunityId(OpportunityNavigation.opportunityList.get(0).getId()));
        assertFalse(Validator.isValidOpportunityId("12133"));
        OpportunityNavigation.opportunityList.clear();
    }


    @Test
    public void isValidEmail_String_Boolean() {
        assertTrue(Validator.isValidEmail("Maria@Antonia.es"));
        assertFalse(Validator.isValidEmail("miariantonia@"));
        assertFalse(Validator.isValidEmail("miariantonia.es"));
        assertFalse(Validator.isValidEmail("@miariantonia.es"));
    }

    @Test
    public void isValidCommand_String_Boolean() {
        assertTrue(Validator.isValidCommand(" new LEAD"));
        assertFalse(Validator.isValidCommand("niu lid"));
    }

    @Test
    public void isValidPhoneNumber_String_Boolean() {
        assertTrue(Validator.applyValidation(PHONE, "(202) 555-0125"));
        assertFalse(Validator.applyValidation(PHONE, "(adios) 555-0125"));
    }

}