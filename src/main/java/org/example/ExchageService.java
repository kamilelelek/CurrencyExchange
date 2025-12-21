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

public class ExchageService {
    public static void main(String[] args) {
        System.out.println("Currencies are:");
        for (Currency currency : Currency.values()) {
            System.out.println(currency);
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter currency code: ");
        String fromCod = input.nextLine();
        System.out.println(fromCod);
        String toCod = input.nextLine();
        System.out.println(toCod);
        System.out.println("give amount");
        double amount=input.nextDouble();
        System.out.println(fromCod+" "+toCod+" "+amount);
        Currency to = Currency.valueOf(toCod.toUpperCase());
        Currency from = Currency.valueOf(fromCod.toUpperCase());
        System.out.println(to);

        double exchange = exchange(from, to, amount);
        // LOGGER Java LOG.info("") / LOG.error("")
        System.out.println(exchange);
    }

    private static double exchange(Currency from, Currency to, double amount) {
        int errors = 0;
        if (from == to) {
            throw new InvalidTransactionException("Exchange from " + from + " to " + to);
        }
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative");
        }
        if (amount > from.getLimit()) {
            throw new TreasureDepartmentMonitoringException("Amount cannot be greater than " + from.getLimit());

        }
        double refund;
        System.out.println(amount + " " + from + " to " + to);
        // from = PLN, to DOLAR
        NbpApiClient nbpApiClient = new NbpApiClient();

        //double exchangeRate = nbpApiClient.getExchangeRate(fromCod, toCod);

        return exchangeRate;
    }
}