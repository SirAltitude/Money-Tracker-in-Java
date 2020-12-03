package database;

import person.Person;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class RegistrationTickets extends TicketsDB {

    private final ArrayList<Ticket> tickets;
    private static RegistrationTickets registrationTicket_instance;

    private RegistrationTickets()
    {
        this.tickets = new ArrayList<Ticket>();
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
    }

    @Override
    public void printDatabase()
    {
        if(tickets.size()!=0) {
            for (Ticket t : tickets) {
                System.out.println(t.getTicketType() + ", " + t.getPaidAmount()+"eur" + " was paid by " +t.getPayer().getName());
            }
        }else System.out.println("There are no tickets");
    }
}