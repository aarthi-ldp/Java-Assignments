package aarthi.assignment5.data;

public class MyClass {
    private int number;
    private char character;

    public void printVariables() {
        System.out.println("Number: " + number);
        System.out.println("Character: " + character);
    }

//    public void printLocalVariables() {
//        int localVar1;
//        char localVar2;
//        System.out.println("LocalVar1: " + localVar1);
//        System.out.println("LocalVar2: " + localVar2);
//    }
    /* This part is not possible in Java:
     * You cannot access uninitialized local variables directly.
     * Local variables must be initialized before they can be used.
     * Attempting to print uninitialized local variables would result in a compilation error.
     */
}


