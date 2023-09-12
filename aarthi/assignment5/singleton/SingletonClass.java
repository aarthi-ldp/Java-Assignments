package aarthi.assignment5.singleton;

public class SingletonClass {
    private String text;


    private SingletonClass() {
        // Private constructor to prevent direct instantiation
    }

    public static SingletonClass createAndInitialize(String input) {
        SingletonClass obj = new SingletonClass();
        obj.text = input;
        return obj;
    }

    public void printString() {
        System.out.println("String: " + text);
    }
}
