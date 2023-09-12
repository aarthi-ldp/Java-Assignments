package assignment1;
import java.io.File;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class FileSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File Search in Home Directory");
        System.out.println("Enter a regular expression (or 'q' to quit):");
        File directory = new File("C:\\Users\\aartm\\Java Assignment");

        while(true) {
        System.out.println("Searching Files...");
                try {

                        String input = scanner.nextLine();
                       System.out.println(input);

                        if(input.equalsIgnoreCase("q")) {
                            System.out.println("Exiting...");
                            break;
                        }

                        Pattern pattern = Pattern.compile(input);

//                    String homeDir = System.getProperty("C:\Users");
//                    File directory = new File(homeDir);

                    ArrayList<File> matchingFiles = new ArrayList<>();
                    searchForMatchingFiles(directory, pattern, matchingFiles, input);
                    System.out.println(matchingFiles.size());
                if(!matchingFiles.isEmpty()) {
                    System.out.println("Matching files found:");
                    for(File file : matchingFiles) {
                        System.out.println(file.getAbsolutePath());

                    }
                }
                else {
                    System.out.println("No matching files found.");
                }

            } catch (PatternSyntaxException e) {
                System.err.println("Invalid Regular Expression syntax: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }


        scanner.close();
    }

    private static void searchForMatchingFiles(File directory, Pattern pattern, ArrayList<File> matchingFiles, String searchText) {
        File[] files = directory.listFiles();


        if (files != null) {

            for (File file : files) {
                if (file.isDirectory()) {
                    // If it's a directory, recursively search it
                    searchForMatchingFiles(file, pattern, matchingFiles, searchText);
                } else {
                    // If it's a file, check if it matches the pattern
                    Matcher matcher = pattern.matcher(file.getName());
//                    File
                    if (file.getName().toString().contains(searchText)) {
                        matchingFiles.add(file);
                    }
                }
            }
        }
    }
}
