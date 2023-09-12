package assignment8;
import java.util.Scanner;

class CustomException1 extends Exception {
    public CustomException1(String message) {
        super(message);
    }
}

class CustomException2 extends Exception {
    public CustomException2(String message) {
        super(message);
    }
}

class CustomException3 extends Exception {
    public CustomException3(String message) {
        super(message);
    }
}

    class ExceptionThrower {
        public void throwAllExceptions(int choice) throws CustomException1, CustomException2, CustomException3 {
            if (choice == 1) {
                throw new CustomException1("Custom Exception 1 occurred.");
            } else if (choice == 2) {
                throw new CustomException2("Custom Exception 2 occurred.");
            } else if (choice == 3) {
                throw new CustomException3("Custom Exception 3 occurred.");
            } else {
                throw new NullPointerException("NullPointerException occurred.");
            }
        }
    }

   class Main {
        public static void main(String[] args) {
            ExceptionThrower thrower = new ExceptionThrower();


            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an integer (1, 2, 3, or any other to trigger NullPointerException): ");


            int userChoice = scanner.nextInt();

            try {

                thrower.throwAllExceptions(userChoice); // Passing the user's choice as an argument
            } catch (CustomException1 | CustomException2 | CustomException3 e) {
                System.out.println("Caught custom exception: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Caught NullPointerException: " + e.getMessage());
            } finally {
                System.out.println("Finally block executed.");


                scanner.close();
            }
        }
    }

