package com.epam.statistics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Transaction> transactions = readTransactions();
        System.out.println(transactions);
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
