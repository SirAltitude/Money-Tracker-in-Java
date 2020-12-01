package controller;

import Factory.AFact;
import database.PeopleDB;
import database.TicketsDB;
import person.Person;
import ticket.Ticket;

public class RegisterController {

    private PeopleDB peopleDB;
    private TicketsDB ticketsDB;
    private AFact factory;

    public RegisterController(PeopleDB peopleDB, TicketsDB ticketsDB, AFact fact)
    {
        this.peopleDB = peopleDB;
        this.ticketsDB = ticketsDB;
        this.factory = fact;
    }

    public void addEvent(Person person, double paidAmount, String eventType)
    {
        Ticket t = factory.getTicket(person,paidAmount,eventType);
        ticketsDB.addTicket(t);
        person.addTicket(t);
    }

    public void addPerson(String name)
    {
        Person p = factory.getPerson(name);
        this.peopleDB.addPerson(p);
    }

    public void printPeopleDatabase()
    {
        peopleDB.printDatabase();
    }

    public void printTicketDatabase()
    {
        ticketsDB.printDatabase();
    }
}

