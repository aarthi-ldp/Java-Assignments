package assignment2;
import java.util.Scanner;

public class CheckAlphabet {
    public static boolean containsAllAlphabet(String input) {

        boolean[] alphabetPresent = new boolean[26];


        String lowercaseInput = input.toLowerCase();


        for (int i = 0; i < lowercaseInput.length(); i++) {
            char c = lowercaseInput.charAt(i);


            if ('a' <= c && c <= 'z') {

                alphabetPresent[c - 'a'] = true;
            }
        }


        for (boolean letterPresent : alphabetPresent) {
            if (!letterPresent) {
                return false; // If any letter is missing, return false
            }
        }

        return true; // All letters are present
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it contains all the letters of the alphabet:");
        String input = scanner.nextLine();

        boolean result = containsAllAlphabet(input);

        if (result) {
            System.out.println("The input contains all the letters of the alphabet.");
        } else {
            System.out.println("The input does not contain all the letters of the alphabet.");
        }

        scanner.close();
    }
}
