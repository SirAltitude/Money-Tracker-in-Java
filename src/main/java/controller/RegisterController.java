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

//    public void addEvent(Person person, double paidAmount, int eventType)
//    {
//        Ticket t = factory.makeTicket(eventType, person,paidAmount);
//        ticketsDB.addTicket(t);
//        person.addTicket(t);
//    }

    public void addTicket(Ticket ticket)
    {
        this.ticketsDB.addTicket(ticket);
    }
    public void addPerson(String name)
    {
        this.peopleDB.addPerson(factory.createPerson(name));
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

