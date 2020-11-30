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
        PeopleDB peopleDB = RegistrationPeople.getInstance();
        TicketsDB ticketsDB = RegistrationTickets.getInstance();
        RegisterController regPeople = new RegisterController(peopleDB, ticketsDB);

        Person p1 = new Person("Anton", 50);
        Ticket t1 = new Ticket(50);

        regPeople.addEvent(p1, t1);

    }
}