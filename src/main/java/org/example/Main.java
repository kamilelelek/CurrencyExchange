package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/*Zadanie 1.
Stworz metode ktora dokonuje wymiany walut
double exchange(Currency from, Currency to, double amount)
np: zamieniamy 100 euro na pln to bylo by:
exchange(Currency.EUR, Currency.PLN, 100)
Currency to twoj enum, dodaj do niego pare wartosci.
kazda waluta ma swoja wartosc graniczna przy ktorej wyrzucany jest alert do
urzędu skarbowego np: dla euro kwota moze wynoosc 10k euro, dla pln 50 tys
pln, dla usd 15k usd, itp itd... jakies dowolne wartosci sobie przyjmij.

metoda exchange powinna rzucac wyjatkami jesli:
- wartosci from i to sa takie same, wtedy ma rzucic
InvalidTransactionException
- jesli amount jest ujemne to ma rzucic
InvalidAmountException
- jesli kwota jest wieksza niz currencyFrom pozwala na transakcje
TreasureDepartmentMonitoringException

uzyj metody exchange w mainie i zlap kazdy wyjatek osobno,
w przypadku wystapienia TreasureDepartmentException wiecej niz 10 razy, zablokuj kompletnie mozliwosc wykonania metody exchange.

 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Currencies are:");
        for (Currency currency : Currency.values()) {
            System.out.println(currency);
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter currency code: ");
        String code = input.nextLine();

    }

    public static double exchange(Currency from, Currency to, double amount) {
        if (from == to) {
            throw new InvalidTransactionException("Exchange from " + from + " to " + to);
        }
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative");
        }
        if (amount > from.getLimit()) {
            throw new TreasureDepartmentMonitoringException("Amount cannot be greater than " + from.getLimit());
        }

        // from = PLN, to DOLAR
        // double = api.getExchange(from, to) -> 1 PLN - 3,67 Dollara
        // amout * double

        return 1.0;
    }
}