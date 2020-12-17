package database;

import person.Person;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class TicketsDB extends Observable {
    public abstract void addTicket(Ticket t);
    public abstract void printDatabase();

    public abstract void addObserver(Observer o);

    public abstract void deleteObserver(Observer o);

    public abstract void notifyObservers();
    public abstract ArrayList<Ticket> getList();
}

