package assignment6.vampire;

public class VampireNumbers {
    public static void main(String[] args) {
        int count = 0;//to keep track of no.of vampire no's found

        int number = 10; //

        while (count < 100) {
            if (isVampireNumber(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }

    public static boolean isVampireNumber(int number) {
        if (numberOfDigits(number) % 2 != 0) {
            return false; // Must have an even number of digits
        }

        String numStr = Integer.toString(number);//this is done to manipulate digits.
        char[] numChars = numStr.toCharArray();//to examine individual digits
        int numLength = numChars.length;

        for (int i = 10; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                String factor1 = Integer.toString(i);
                String factor2 = Integer.toString(number / i);

                if (factor1.length() == numLength / 2 && factor2.length() == numLength / 2) {
                    if (isPermutation(numChars, factor1.toCharArray(), factor2.toCharArray())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int numberOfDigits(int number) {
        return Integer.toString(number).length();
    }

    public static boolean isPermutation(char[] arr1, char[] arr2, char[] arr3) {  //checks if the char's in arr1 are a permutation of char's in arr2 and arr3
        int[] count1 = new int[10];  //to check the occurrences of each digit in char arrays.
        int[] count2 = new int[10];

        for (char c : arr1) {
            count1[c - '0']++;
        }

        for (char c : arr2) {
            count2[c - '0']++;
        }

        for (char c : arr3) {
            count2[c - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}