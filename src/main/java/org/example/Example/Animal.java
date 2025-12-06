package org.example.Example;

public class Animal {
    String name;

    // Konstruktor
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
