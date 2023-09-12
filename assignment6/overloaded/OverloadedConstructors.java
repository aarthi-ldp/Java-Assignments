package assignment6.overloaded;

public class OverloadedConstructors {
    public OverloadedConstructors(){
        this("Hello");
    }

    public OverloadedConstructors(String message){
        System.out.println("Constructor with message: " + message);
    }

    public static void main(String[] args) {
        OverloadedConstructors obj = new OverloadedConstructors();
    }
}
