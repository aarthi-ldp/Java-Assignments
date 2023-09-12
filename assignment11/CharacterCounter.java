package assignment11;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {
    public static void main(String[] args) {
//        if (args.length != 1) {  //checks exactly 1 cmnd line argument is  provided
//            System.out.println("Usage: java CharacterCounter <input_file>");
//            return;
//        }

        String inputFile = "C:\\Users\\aartm\\Desktop\\input.txt";  //retrieves the i/p file from the cmnd line args & store it in variabel
        System.out.println("Entered file");
        Map<Character, Integer> charFrequencyMap = new HashMap<>(); //maps char frequencies to int frequencies.

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int charValue; //to store value of each character read from i/p file
            while ((charValue = reader.read()) != -1) {
                char character = (char) charValue; //to convert numerical value to char to get actual charater
                if (Character.isLetterOrDigit(character)) {
                    // Update the character frequency in the map
                    charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return;
        }

        String outputFile = "C:\\Users\\aartm\\Desktop\\result.txt";
        File outputDir = new File(outputFile).getParentFile();

        if (!outputDir.exists()) {
            System.err.println("Output directory does not exist.");
            return;
        }

        if (!outputDir.canWrite()) {
            System.err.println("No write permission in the output directory.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Character frequencies saved to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
