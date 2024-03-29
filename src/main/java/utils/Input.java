package utils;

import enums.Validation;

import java.util.List;
import java.util.Scanner;

import static utils.Utils.printHeading;


public class Input {
    public static Scanner scanner = new Scanner(System.in);


    /**
     * Input string with validations
     *
     * @param prompt      the text you want to show
     * @param validations enums of validations
     * @return
     */
    public static String promptTextWithValidation(String prompt, List<Validation> validations) {
        String input = null;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            input = scanner.nextLine();

            isValid = true;

            for (Validation validation : validations) {
                if (!Validator.applyValidation(validation, input)) {
                    isValid = false;
                }
            }
        }

        return input;
    }

    public static int promptIntWithValidation(String prompt, int userChoices) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);

            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Utils.printLikeError("Please enter a number");
                continue;
            }
            isValid = input > 0 && input <= userChoices;

            if (!isValid) Utils.printLikeError("Input a valid choice");
        }


        return input;
    }



    public static int promptIntWithCheck( String prompt, int userChoices) {
        //va en header lo que ve el jugador y attribute
        boolean attributeSet = false;
        int whatWeAreSetting = 0;

        while (!attributeSet){
            whatWeAreSetting = promptIntWithValidation(prompt, userChoices);

            //asking the player if he wants to correct his choice
            printHeading( "You have chosen -> " + whatWeAreSetting + ".\n\tIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to correct it");
            int input = promptIntWithValidation("-> ", 2);
            if (input == 1) {
                attributeSet = true;
            }

        } 
        return whatWeAreSetting;
    }
}

