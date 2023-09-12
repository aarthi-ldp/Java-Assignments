package aarthi.assignment5.main;
import aarthi.assignment5.singleton.SingletonClass;
import aarthi.assignment5.data.MyClass;
public class Main {
    public static void main(String[] args) {
        MyClass myClassObj = new MyClass();

        myClassObj.printVariables();


        //myClassObj.printLocalVariables();
        // This part is not possible in Java.
        /*
        // Call the method to print uninitialized local variables

         */
        SingletonClass singletonObj = SingletonClass.createAndInitialize("Hello, Singleton!");

        singletonObj.printString();


    }

}
