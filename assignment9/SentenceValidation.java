package assignment9;
import java.util.regex.*;
import java.util.Scanner;

public class SentenceValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = "^[A-Z].*\\.$";

        while(true) {
            System.out.print("Enter a sentence: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Valid: " + input);
            } else {
                System.out.println("Invalid: " + input);
            }
        }
        scanner.close();
    }
}
