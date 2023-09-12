package assignment7.part5;

import java.util.Scanner;


// Outer class with an inner class that has a non-default constructor
class OuterClass {

    class InnerClass {
        private int value;

        public InnerClass(int value) {
            this.value = value;
        }

        public void displayValue() {
            System.out.println("InnerClass value: " + value);
        }
    }
}


class SecondClass {

    class ExtendedInnerClass extends OuterClass.InnerClass {   // Inner class that extends the InnerClass from the first class
        public ExtendedInnerClass( OuterClass outer,int value) {
            outer.super(value); // Calling the constructor of the superclass (InnerClass)
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer value for InnerClass: ");
        int inputValue1 = scanner.nextInt();

        // Create an instance of OuterClass
        OuterClass outer = new OuterClass();

        // Create an instance of the InnerClass from OuterClass with user input
        OuterClass.InnerClass inner1 = outer.new InnerClass(inputValue1);
        inner1.displayValue();

        System.out.print("Enter an integer value for ExtendedInnerClass: ");
        int inputValue2 = scanner.nextInt();

        // Create an instance of SecondClass
        SecondClass second = new SecondClass();

        // Create an instance of the ExtendedInnerClass from SecondClass with user input
        SecondClass.ExtendedInnerClass inner2 = second.new ExtendedInnerClass( outer,inputValue2);
        inner2.displayValue();

        // Close the Scanner
        scanner.close();
    }
}
