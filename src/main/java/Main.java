import Factory.AFact;
import Factory.TicketMaker;
import controller.RegisterController;
import database.PeopleDB;
import database.RegistrationPeople;
import database.RegistrationTickets;
import database.TicketsDB;
import person.Person;
import ticket.Ticket;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {   //Intentionally left blank
    }

    public void run() {
        // Databases
        PeopleDB peopleDB = RegistrationPeople.getInstance();
        TicketsDB ticketsDB = RegistrationTickets.getInstance();

        // Abstract Factory
        AFact factory = TicketMaker.getInstance();

        // Registration Controller
        RegisterController register = new RegisterController(peopleDB, ticketsDB,factory);

        // Creating and registering Person
        register.addPerson("Anton");
        Person p1 = peopleDB.getPerson("Anton");

        register.addPerson("Eli");
        Person p2 = peopleDB.getPerson("Eli");

        // Creating and registering Tickets
        int restaurant = 1;
        boolean split = true;

        Ticket restaurantTicket = factory.makeTicket(restaurant,p1,15, split);
        register.addTicket(restaurantTicket);
        p1.addTicket(restaurantTicket);

        Ticket restaurantTicketEli = factory.makeTicket(restaurant,p2,10, split);
        register.addTicket(restaurantTicketEli);
        p1.addTicket(restaurantTicketEli);

        // Output
        System.out.println("---- People on this trip ----");
        register.printPeopleDatabase();

        System.out.println("\n---- Active Tickets -----");
        register.printTicketDatabase();

        System.out.println("\n---- Total Bill -----");
        register.printBill();
    }
}