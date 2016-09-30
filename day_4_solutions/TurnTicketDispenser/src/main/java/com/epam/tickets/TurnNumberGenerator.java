package com.epam.tickets;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TurnNumberGenerator {
	
	private static TurnNumberGenerator numberGenerator = new TurnNumberGenerator(new SecureRandom(), 1000);

    public static int getNextTurnNumber() {
        return numberGenerator.next();
    }
    
    private List<Integer> tickets = new LinkedList<>();
    private Random random;
    private int count;

    public TurnNumberGenerator(Random random, int count) {
    	this.random = random;
        this.tickets = generateRandomTickets();
        this.count = count;
    }

    public List<Integer> generateRandomTickets() {
    	List<Integer> tickets = new LinkedList<>();
        Set<Integer> randomTickets = new HashSet<>();
        while (randomTickets.size() < count) {
            randomTickets.add(random.nextInt());
        }
        tickets.addAll(randomTickets);
        return tickets;
	}

	private int next() {
		return tickets.remove(0);
	}

}
