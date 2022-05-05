package utils;

import enums.Validation;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.Validation.PHONE;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    public void applyValidation_ValidationEnumAndStringInput_Boolean(){
        assertTrue(Validator.applyValidation(PHONE, "(202) 555-0125"));
        assertFalse(Validator.applyValidation(PHONE, "(hola) 555-0125"));
    }

    @Test
    public void isValidCountryName_String_Boolean(){
        assertTrue(Validator.isValidCountryName("Argentina"));
        assertFalse(Validator.isValidCountryName("Argentonia"));
    }

    @Test
    public void isValidName_String_Boolean(){
        assertTrue(Validator.isValidName("Maria Antonia"));
        assertFalse(Validator.isValidName("M@riantonia"));
    }

/*
    @Test
    public void isValidString_String_Boolean(){
        */
/*assertTrue(Validator.isValidString("Maria Antonia"));
        assertFalse(Validator.isValidString("123"));*//*

    }
*/

    @Test
    public void isValidEmail_String_Boolean(){
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