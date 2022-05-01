package utils;

import enums.Validation;

import java.util.List;
import java.util.Scanner;

import static utils.Utils.printHeading;
import static utils.Utils.readInt;


public class Input {
    static Scanner scanner = new Scanner(System.in);


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


    //Todo
    public static int promptIntWithCheck(String prompt, String question, int userChoices) {
        int input = 0;
        boolean isValid = false;
        boolean isInputCorrect = false;

        while (!isValid) {
            System.out.println(prompt);

            try {
                input = Integer.parseInt(scanner.nextLine());

                do {
                    printHeading(question);
                    System.out.println("(1) Yes!");
                    System.out.println("(2) No, I want to correct it");
                    int answerInput = readInt("-> ", 2);
                    if (answerInput == 1) {
                        isInputCorrect = true;
                        isValid = false;
                    }
                } while (!isInputCorrect);

            } catch (Exception e) {
                Utils.printLikeError("Please enter a number");
                continue;
            }

            isValid = input > 0 && input <= userChoices;

            if (!isValid) Utils.printLikeError("Input a valid choice");
            if (!isInputCorrect) Utils.printLikeError("Input 1 or 2");
        }


        return input;
    }
}
