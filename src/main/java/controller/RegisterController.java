package controller;

import database.PeopleDB;
import database.TicketsDB;
import person.Person;
import ticket.Ticket;

public class RegisterController {

    private PeopleDB peopleDB;
    private TicketsDB ticketsDB;

    public RegisterController(PeopleDB peopleDB, TicketsDB ticketsDB)
    {
        this.peopleDB = peopleDB;
        this.ticketsDB = ticketsDB;
    }

    public void addEvent(Ticket t)
    {
        ticketsDB.addTicket(t);
    }

    public void addPerson(String name)
    {
         this.peopleDB.addPerson(new Person(name));
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

