package database;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

public class RegistrationTickets extends TicketsDB {

    private final ArrayList<Ticket> tickets;
    private static RegistrationTickets registrationTicket_instance;
    private List<Observer> observers;
    private Ticket key;
    private RegistrationTickets()
    {
        this.tickets = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static RegistrationTickets getInstance()
    {
        if(registrationTicket_instance == null) {
            registrationTicket_instance = new RegistrationTickets();
        }
        return registrationTicket_instance;
    }

    @Override
    public void addTicket(Ticket t) {
        this.tickets.add(t);
        setChanged();
        this.key = t;
        this.notifyObservers();
    }

    @Override
    public void printDatabase()
    {
        if(tickets.size()!=0) {
            for (Ticket t : tickets) {
                System.out.println(t.getTicketType() + ", " + t.getPaidAmount()+"eur" + " was paid by " +t.getPayer().getName() + ". Even split? " + t.getSplit());

            }
        }else System.out.println("There are no tickets");
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: observers) {
            obs.update(this, key);
        }
    }
}