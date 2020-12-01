import Factory.AFact;
import Factory.TicketMaker;
import controller.RegisterController;
import database.PeopleDB;
import database.RegistrationPeople;
import database.RegistrationTickets;
import database.TicketsDB;
import person.Person;
import ticket.Ticket;

import java.awt.geom.AffineTransform;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {   //Intentionally left blank
    }

    public void run() {
        PeopleDB peopleDB = RegistrationPeople.getInstance();
        TicketsDB ticketsDB = RegistrationTickets.getInstance();

        AFact factory = TicketMaker.getInstance();

        RegisterController register = new RegisterController(peopleDB, ticketsDB,factory);
        //hier moet je nog Afact mee doorgeven, zodat je afact kan oproepen (public afact getaf( return this.afact))

        Person p1 = factory.getPerson("Anton");
        register.addPerson("Anton");

        register.addEvent(p1,15,"Shisha");

        System.out.println("---- People on this trip ----");
        register.printPeopleDatabase();

        System.out.println("\n---- Active Tickets -----");
        register.printTicketDatabase();



        //if new ticket needs to be added

    }
}