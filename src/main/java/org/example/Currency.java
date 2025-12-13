package org.example;

// Klasa enum
// Klasa abstract class
// Interface
public enum Currency {
    GBP(10000),
    EUR(25000),
    USD(15000),
    PLN(100000),
    CAD(30000),
    CHF(40000);

    public final int limit;

    Currency(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

}
