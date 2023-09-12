package assignment7.part4;

// Define the Cycle interface
interface Cycle {
    void ride();
}

// Implementations of Cycle
class Unicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a unicycle.");
    }
}

class Bicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a bicycle.");
    }
}

class Tricycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a tricycle.");
    }
}
// Factory methods for creating cycles
class CycleFactory {
    static Cycle createUnicycle() {  //static factory methods to create instances of cycles
        return new Unicycle();
    }

    static Cycle createBicycle() {
        return new Bicycle();
    }

    static Cycle createTricycle() {
        return new Tricycle();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create cycles using factory methods
        Cycle unicycle = CycleFactory.createUnicycle();
        Cycle bicycle = CycleFactory.createBicycle();
        Cycle tricycle = CycleFactory.createTricycle();

        // Ride the cycles
        rideCycle(unicycle);
        rideCycle(bicycle);
        rideCycle(tricycle);
    }

    static void rideCycle(Cycle cycle) {
        cycle.ride();
    }

}
