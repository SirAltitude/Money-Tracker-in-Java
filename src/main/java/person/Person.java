package person;

import ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private String name;
    private ArrayList<Ticket> tickets;
    private double debt;

    public Person(String name)
    {
    this.name = name;
    tickets = new ArrayList<Ticket>();
    debt = 0;
    }

    public String getName() //through this method, regController can access the name of a Person
    {
        return name;
    }
    public void addTicket(Ticket t)
    {
        tickets.add(t);
    }

    public void printTickets(){
        for(Ticket ticket: tickets)
        {
            System.out.println(ticket.getTicketType() + ", value: "+ticket.getPaidAmount());
        }
    }
    public void addDebt(double value){
        debt += value;
    }

    public double getDebt()
    {
        return debt;
    }
}
