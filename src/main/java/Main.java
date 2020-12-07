import factory.AFact;
import factory.TicketMaker;
import controller.RegisterController;
import database.PeopleDB;
import database.RegistrationPeople;
import database.RegistrationTickets;
import database.TicketsDB;
import jframe.ViewFrame;
import observers.ObserverEntryPerson;
import observers.ObserverEntryTicket;
import observers.ObserverUpdate;
import person.Person;
import ticket.Ticket;

import javax.swing.text.View;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {}   //Intentionally left blank

    public void run() {
        // Databases
        PeopleDB peopleDB = RegistrationPeople.getInstance();
        TicketsDB ticketsDB = RegistrationTickets.getInstance();

        // Abstract Factory
        AFact factory = TicketMaker.getInstance();

        // Registration Controller
        RegisterController register = new RegisterController(peopleDB, ticketsDB,factory);

        // Observers
        ObserverEntryPerson printEntryPerson = new ObserverEntryPerson();
        ObserverEntryTicket printEntryTicket = new ObserverEntryTicket();
        ObserverUpdate printUpdate = new ObserverUpdate();
        peopleDB.addObserver(printEntryPerson);
        peopleDB.addObserver(printUpdate);
        ticketsDB.addObserver(printEntryTicket);
        ticketsDB.addObserver(printUpdate);


        // Creating and registering Person
        register.addPerson("Anton");
        Person p1 = peopleDB.getPerson("Anton");

        register.addPerson("Eli");
        Person p2 = peopleDB.getPerson("Eli");

        // ViewPanel
        ViewFrame view = new ViewFrame(register,p1);
        view.initialize();

        // Creating and registering Tickets
        boolean split = true;

        Ticket restaurantTicket = factory.makeTicket(TicketTypeEnum.restaurant.getValue(), p1,15, split);
        register.addTicket(restaurantTicket);
        p1.addTicket(restaurantTicket);

//        Ticket restaurantTicketEli = factory.makeTicket(TicketTypeEnum.restaurant.getValue(), p2,10, split);
//        register.addTicket(restaurantTicketEli);
//        p2.addTicket(restaurantTicketEli);
//
        Ticket sportsTicket_Anton = factory.makeTicket(TicketTypeEnum.sports.getValue(), p1,20, !split);
        register.addTicket(sportsTicket_Anton);
        p1.addTicket(sportsTicket_Anton);

        // Output
        System.out.println("\n---- People on this trip ----");
        register.printPeopleDatabase();

        System.out.println("\n---- Active Tickets -----");
        register.printTicketDatabase();

//        for(Person p: peopleDB.getList()) {
//            System.out.format("\n%s has active tickets: \n", p.getName());
//            p.printTickets();
//        }

//        System.out.println("\n---- Total Bill -----");
//        register.printBill();
    }
}