package person;

import ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private String name;
    private ArrayList<Ticket> tickets;

    public Person(String name)
    {
    this.name = name;
    tickets = new ArrayList<Ticket>();
    }
    public String getName() //through this method, regController can access the name of a Person
    {
        return name;
    }
    public void addTicket(Ticket t)
    {
        tickets.add(t);
    }
}
// arraylist van tickets