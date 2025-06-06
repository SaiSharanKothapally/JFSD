import java.util.*;

class Animal {
    void makeSound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat meows");
    }
}


public class AnimalOverRiding {
    public static void main(String[] args) {
        Animal d = new Dog(); 
        Animal c = new Cat(); 
        Animal a= new Animal();

        a.makeSound();
        d.makeSound(); 
        c.makeSound(); 
    }

}
