package assignment7.part1;

public class Rodent {
    Rodent() {
        System.out.println("This is a Rodent.");
    }

    void eat() {
        System.out.println("Rodent is eating.");
    }

    void sleep() {
        System.out.println("Rodent is sleeping.");
    }
}

// Derived class Mouse
class Mouse extends Rodent {
    Mouse() {
        System.out.println("This is a Mouse.");
    }

    @Override
    void eat() {
        System.out.println("Mouse is nibbling on cheese.");
    }
}

// Derived class Gerbil
class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("This is a Gerbil.");
    }

    @Override
    void eat() {
        System.out.println("Gerbil is eating seeds.");
    }
}

// Derived class Hamster
class Hamster extends Rodent {
    Hamster() {
        System.out.println("This is a Hamster.");
    }

    @Override
    void eat() {
        System.out.println("Hamster is munching on pellets.");
    }
}

 class RodentHierarchy {
    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[3];
        rodents[0] = new Mouse();
        rodents[1] = new Gerbil();
        rodents[2] = new Hamster();

        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
        }
    }

}
