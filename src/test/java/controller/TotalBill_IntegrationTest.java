package controller;

import database.PeopleDB;
import database.RegistrationPeople;
import database.RegistrationTickets;
import database.TicketsDB;
import factory.AFact;
import factory.TicketMaker;
import org.junit.Before;
import org.junit.Test;
import person.Person;

import static junit.framework.TestCase.assertEquals;

public class TotalBill_IntegrationTest {
    Person anton, eli, rob;

    public TotalBill_IntegrationTest() {
    }

    @Before
    public void initialize() {
        PeopleDB peopleDB = RegistrationPeople.getInstance();
        TicketsDB ticketsDB = RegistrationTickets.getInstance();
        AFact factory = TicketMaker.getInstance();

        RegisterController controller = new RegisterController(peopleDB, ticketsDB, factory);
        anton = new Person("Anton");
        eli = new Person("Eli");
        rob = new Person("Rob");

        peopleDB.addPerson(anton);
        peopleDB.addPerson(eli);
        peopleDB.addPerson(rob);

        controller.addTicket(controller.getFactory().makeTicket("Sports", eli, 15.0, true));
        controller.addTicket(controller.getFactory().makeTicket("Restaurant", anton, 12.0, true));
        controller.addTicket(controller.getFactory().makeTicket("Cinema", rob, 9.0, true));

        controller.getPeopleDB().calcDebts();
    }

    @Test
    public void t_TotalBIll()
    {
        double anton_to_eli_debts = anton.getDebts().get(eli);
        assertEquals("Anton should have a debt of 1eur owing Eli",1.0,anton_to_eli_debts,0.00);

        double rob_to_eli_debts = rob.getDebts().get(eli);
        assertEquals("Rob should have a debt of 2eur owing Eli",2.0,rob_to_eli_debts,0.00);

        double rob_to_anton_debts = rob.getDebts().get(anton);
        assertEquals("Rob should have a debt of 1eur owing Anton",1.0,rob_to_anton_debts,0.00);
    }
}
