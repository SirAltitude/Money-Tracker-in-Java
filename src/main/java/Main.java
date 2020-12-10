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

        // JFrame
        ViewFrame view = new ViewFrame(register);
        peopleDB.addObserver(view);
        ticketsDB.addObserver(view);
        view.initialize();

//      TODO
//      fix remove person
//      fix deleted person list
//      fix other tickets

    }
}