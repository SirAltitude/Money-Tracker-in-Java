package database;

import ticket.Ticket;

public abstract class TicketsDB {
    public TicketsDB(){}

    public abstract void addTicket(Ticket t);

}

