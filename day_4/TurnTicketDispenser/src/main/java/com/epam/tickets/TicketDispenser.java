package com.epam.tickets;

public class TicketDispenser {

    public TurnTicket getTurnTicket() {
        int newTurnNumber = TurnNumberGenerator.getNextTurnNumber();
        return new TurnTicket(newTurnNumber);
    }

    public static void main(String[] args) {
        TicketDispenser dispenser = new TicketDispenser();
        for (int i = 0; i < 10; i++) {
            TurnTicket ticket = dispenser.getTurnTicket();
            System.out.println(ticket);
        }
    }
}
