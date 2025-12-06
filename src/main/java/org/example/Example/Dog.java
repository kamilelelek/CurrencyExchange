package org.example.Example;

public class Dog extends Animal{
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        super.makeSound();   // wywołanie metody z Animal
        System.out.println("Woof! Woof!");
    }
}
