package assignment3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.net.InetAddress;

public class PingMedianCalculator {
    public static double calculatePingMedian(String host) {
        List<Double> pingTimes = new ArrayList<>();

        try {

            ProcessBuilder processBuilder = new ProcessBuilder("ping", host);
            Process process = processBuilder.start();

            // Read the output of the ping command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                // Check for lines containing ping statistics
                if (line.contains("time=")) {
                    int startIndex = line.indexOf("time=")  ;
                    int endIndex = line.indexOf("ms", startIndex);
                    System.out.println("Start Index: " + startIndex);
                    System.out.println("End Index: " + endIndex);
                    if (startIndex != -1 && endIndex != -1) {
                        String pingTimeStr = line.substring(startIndex + 5, endIndex);
                        System.out.println(pingTimeStr);
                        try {
                            double pingTime = Double.parseDouble(pingTimeStr);
                            System.out.println("Parsed Ping Time: " +pingTime);
                            pingTimes.add(pingTime);
                        } catch (NumberFormatException e) {
                            // Handle parsing errors gracefully
                            System.err.println("Error parsing ping time: " + pingTimeStr);
                        }
                    }
                }
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Ping command failed with exit code: " + exitCode);
                return -1.0; // Return -1 to indicate an error
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1.0;
        }


        if (pingTimes.isEmpty()) {
            System.err.println("No valid ping times found in the output.");
            return -1.0; // Return -1 to indicate an error
        }

        // Sort the ping times and calculate the median
        Collections.sort(pingTimes);
        int size = pingTimes.size();
        if (size % 2 == 0) {
            // If even number of values, average the two middle values
            int middle1 = size / 2 - 1;
            int middle2 = size / 2;
            return (pingTimes.get(middle1) + pingTimes.get(middle2)) / 2.0;
        } else {
            // If odd number of values, return the middle value
            int middle = size / 2;
            return pingTimes.get(middle);
        }
    }

    public static void main(String[] args) {
        String host = "facebook.com"; // Replace with the host you want to ping
        double medianPingTime = calculatePingMedian(host);
        if (medianPingTime >= 0) {
            System.out.println("Median ping time to " + host + ": " + medianPingTime + " ms");
        } else {
            System.out.println("Failed to calculate median ping time.");
        }
    }
}
