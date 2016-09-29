package com.epam.tickets;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TurnNumberGenerator {

    private static List<Integer> tickets = new LinkedList<>();

    static {
        Random random = new Random();
        Set<Integer> randomTickets = new HashSet<>();
        while (randomTickets.size() < 1000) {
            randomTickets.add(random.nextInt());
        }
        tickets.addAll(randomTickets);
    }

    public static int getNextTurnNumber() {
        return tickets.remove(0);
    }

}
