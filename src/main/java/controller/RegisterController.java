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

    public void addEvent(Person p, Ticket t)
    {
        peopleDB.addPerson(p);
        ticketsDB.addTicket(t);
    }
}
