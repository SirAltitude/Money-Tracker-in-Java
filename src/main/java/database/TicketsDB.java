package database;

import person.Person;
import ticket.Ticket;

public abstract class TicketsDB {
    public TicketsDB(){}
    public abstract void addTicket(Ticket t);
    public abstract void printDatabase();
}

