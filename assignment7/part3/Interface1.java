package assignment7.part3;

// Define the first interface with two methods
interface Interface1 {
    void method1a();
    void method1b();
}
interface Interface2 {
    void method2a();
    void method2b();
}
interface Interface3 {
    void method3a();
    void method3b();
}
//new interface that combines the three interfaces and adds a new method
interface CombinedInterface extends Interface1, Interface2, Interface3 {
    void newMethod();
}
class MyClass implements CombinedInterface {
    @Override
    public void method1a() {
        System.out.println("Calling method1a.");
    }

    @Override
    public void method1b() {
        System.out.println("Calling method1b.");
    }

    @Override
    public void method2a() {
        System.out.println("Calling method2a.");
    }

    @Override
    public void method2b() {
        System.out.println("Calling method2b.");
    }

    @Override
    public void method3a() {
        System.out.println("Calling method3a.");
    }

    @Override
    public void method3b() {
        System.out.println("Calling method3b.");
    }

    @Override
    public void newMethod() {
        System.out.println("Calling new Method.");
    }
}
class Main {
    // Method that takes Interface1 as an argument
    static void callMethod1(Interface1 obj) {
        obj.method1a();
        obj.method1b();
    }

    // Method that takes Interface2 as an argument
    static void callMethod2(Interface2 obj) {
        obj.method2a();
        obj.method2b();
    }

    // Method that takes Interface3 as an argument
    static void callMethod3(Interface3 obj) {
        obj.method3a();
        obj.method3b();
    }

    // Method that takes CombinedInterface as an argument
    static void callCombinedMethod(CombinedInterface obj) {
        obj.method1a();
        obj.method1b();
        obj.method2a();
        obj.method2b();
        obj.method3a();
        obj.method3b();
        obj.newMethod();
    }
    public static void main(String[] args) {
        MyClass myObject = new MyClass();

        // Call methods with objects of myObject
        callMethod1(myObject);
        callMethod2(myObject);
        callMethod3(myObject);
        callCombinedMethod(myObject);
    }
}


