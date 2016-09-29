package com.epam.tickets;

public class TurnTicket {
    private final int turnNumber;

    public TurnTicket(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    @Override
    public String toString() {
        return "TurnTicket [turnNumber=" + turnNumber + "]";
    }

}
