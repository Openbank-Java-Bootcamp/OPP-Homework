package utils;

import enums.Validation;

import java.util.List;
import java.util.Scanner;


public class Input {
    static Scanner scanner = new Scanner(System.in);

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
}
