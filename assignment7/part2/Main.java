package assignment7.part2;

class Cycle {
    void ride() {
        System.out.println("Riding a cycle.");
    }
}

class Unicycle extends Cycle {
    void balance() {
        System.out.println("Balancing on one wheel.");
    }
}

class Bicycle extends Cycle {
    void balance() {
        System.out.println("Balancing on two wheels.");
    }
}

class Tricycle extends Cycle {
    // Tricycle doesn't have a balance method
}
public class Main {
    public static void main(String[] args) {
        // Create instances of all three types
        Cycle[] cycles = new Cycle[3];
        cycles[0] = new Unicycle();
        cycles[1] = new Bicycle();
        cycles[2] = new Tricycle();

        // Upcasting: Call ride() method on each element
        for (Cycle cycle : cycles) {
            cycle.ride();
        }

        // Attempt to call balance() method on each element
        for (Cycle cycle : cycles) {
            // This will not compile because the balance() method is not in the Cycle class.
            //cycle.balance();
        }

        // Downcasting and calling balance() method
        for (Cycle cycle : cycles) { //iterating through cycles array
            if (cycle instanceof Unicycle) {
                Unicycle unicycle = (Unicycle) cycle;
                unicycle.balance();
            } else if (cycle instanceof Bicycle) {
                Bicycle bicycle = (Bicycle) cycle;
                bicycle.balance();
            }
            // Tricycle doesn't have a balance() method, so no downcasting is done for it.
        }
    }
}
