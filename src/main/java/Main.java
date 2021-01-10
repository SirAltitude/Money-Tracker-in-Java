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
import ticket.Ticket;


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

        // JFrame
        ViewFrame view = new ViewFrame(register);
        peopleDB.addObserver(view);
        ticketsDB.addObserver(view);
        view.createAndShowGUI();

//        register.addPerson("Anton");
//        register.addPerson("Eli");
//        register.addPerson("Jens");
//
//        Ticket t = factory.makeTicket("Restaurant", register.getPeopleDB().getPerson("Eli"),15,true);
//        register.addTicket(t);
//
//        Ticket t1 = factory.makeTicket("Sports", register.getPeopleDB().getPerson("Anton"),12,true);
//        register.addTicket(t1);
//
//        Ticket t2 = factory.makeTicket("Transport", register.getPeopleDB().getPerson("Jens"),9,true);
//        register.addTicket(t2);

        // Observers
        ObserverEntryPerson printEntryPerson = new ObserverEntryPerson();
        ObserverEntryTicket printEntryTicket = new ObserverEntryTicket();
        ObserverUpdate printUpdate = new ObserverUpdate();
        peopleDB.addObserver(printEntryPerson);
        peopleDB.addObserver(printUpdate);
        ticketsDB.addObserver(printEntryTicket);
        ticketsDB.addObserver(printUpdate);

        register.printTicketDatabase();
    }
}