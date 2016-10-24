package com.epam.statistics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Transaction> transactions = readTransactions();

        System.out.println("Max price:");
        System.out.println(maxPrice(transactions));
        System.out.println(transactions.stream().mapToInt(t -> t.getPrice()).max());
        System.out.println(transactions.stream().map(t -> t.getPrice()).max(Integer::compareTo));

        System.out.println("\nSum price:");
        System.out.println(sumOfTransactions(transactions));
        System.out.println(transactions.stream().mapToInt(t -> t.getPrice()).sum());

        System.out.println("\nFiltered sum price:");
        System.out.println(transactions.stream().filter(t -> t.getCity().equals("SACRAMENTO")).mapToInt(t -> t.getPrice()).max());

        System.out.println("\nStreet of the largest price:");
        System.out.println(transactions.stream().max((a, b) -> Integer.compare(a.getPrice(), b.getPrice())).get().getStreet());

        System.out.println("\nInternal iterator:");
        transactions.stream().filter(t -> "CITRUS HEIGHTS".equals(t.getCity())).forEach(System.out::println);

        System.out.println("\nIf there is a transaction from CITRUS HEIGHTS:");
        transactions.stream().filter(t -> "CITRUS HEIGHTS".equals(t.getCity())).findFirst().ifPresent(System.out::println);

        System.out.println("\nLaziness: ");
        transactions.parallelStream().filter(s -> {
            System.out.println("filter: " + s);
            return true;
        }).mapToInt(t -> t.getPrice()); // .min();

        System.out.println("\nPrint CITRUS HEIGHTS transactions in price ascending order: ");
        transactions.stream()
            .sorted((a, b) -> Integer.compare(a.getPrice(), b.getPrice()))
            .filter(t -> "CITRUS HEIGHTS".equals(t.getCity()))
            .forEach(System.out::println);
        
        System.out.println("\nCollect to list highest five prices:");
        List<Transaction> topTransactions = transactions.stream()
            .sorted((a, b) -> -Integer.compare(a.getPrice(), b.getPrice()))
            .limit(5)
            .collect(Collectors.toList());
        System.out.println(topTransactions);
    }

    private static int sumOfTransactions(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getPrice();
        }
        return sum;
    }

    private static int maxPrice(List<Transaction> transactions) {
        int maxPrice = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > maxPrice) {
                maxPrice = transaction.getPrice();
            }
        }
        return maxPrice;
    }

    private static List<Transaction> readTransactions() throws IOException, FileNotFoundException {
        List<Transaction> transactions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("transactions.csv"))) {
            reader.readNext();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Transaction transaction = createTransaction(nextLine);
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    private static Transaction createTransaction(String[] nextLine) {
        Transaction transaction = new Transaction();
        transaction.setStreet(nextLine[0]);
        transaction.setCity(nextLine[1]);
        transaction.setState(nextLine[2]);
        transaction.setBeds(Integer.valueOf(nextLine[3]));
        transaction.setBaths(Integer.valueOf(nextLine[4]));
        transaction.setFloorArea(Integer.valueOf(nextLine[5]));
        transaction.setType(nextLine[6]);
        transaction.setPrice(Integer.valueOf(nextLine[7]));
        return transaction;
    }

}
