package assignment6.constructorwithargs;

public class ConsWithArg {
    public ConsWithArg(String argument) {
        //this.argument = argument;
        System.out.println("Constructor called with argument: " + argument);
    }

    public static void main(String[] args) {
        ConsWithArg[] array = new ConsWithArg[5];
        // The constructors are not called until you actually create objects and assign them to the array.
//        array[0] = new ConsWithArg("Object 0");
//        array[1] = new ConsWithArg("Object 1");
//        array[2] = new ConsWithArg("Object 2");
//        array[3] = new ConsWithArg("Object 3");
//        array[4] = new ConsWithArg("Object 4");


    }
    }

