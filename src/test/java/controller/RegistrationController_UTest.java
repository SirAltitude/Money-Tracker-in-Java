package controller;

import database.PeopleDB;
import database.TicketsDB;
import factory.AFact;
import org.mockito.Mock;
import person.Person;
import ticket.Ticket;
import ticket.Ticket_Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


// Run with PowerMock, an extended version of Mockito
@RunWith(PowerMockRunner.class)
// Prepare class RegistrationController for testing by injecting mocks
@PrepareForTest(RegisterController.class)
public class RegistrationController_UTest
{
    public RegistrationController_UTest()
    {

    }

    @Before
    public void initialize()
    {

    }

    @Test
    public void t_createPerson()
    {
        RegisterController mock_register = Mockito.mock(RegisterController.class);

        mock_register.createPerson("Anton");
        Mockito.verify(mock_register, Mockito.times(1)).createPerson("Anton");
    }

    @Test
    public void t_addTicket()
    {
        // Create mock objects for database and employee
        PeopleDB mock_PeopleDB = Mockito.mock(PeopleDB.class);
        TicketsDB mock_db = Mockito.mock(TicketsDB.class);
        AFact mock_factory = Mockito.mock(AFact.class);

        Ticket mock_ticket = Mockito.mock(Ticket.class);

        RegisterController controllerUnderTest = new RegisterController(mock_PeopleDB,mock_db,mock_factory);

        controllerUnderTest.addTicket(mock_ticket);
        Mockito.verify(mock_db, Mockito.times(1)).addTicket(mock_ticket);
    }

//    @Test
//    public void t_addPerson() throws Exception
//    {
//        // Create mock objects for database and employee
//        PeopleDB mock_PeopleDB = Mockito.mock(PeopleDB.class);
//        TicketsDB mock_db = Mockito.mock(TicketsDB.class);
//        AFact mock_factory = Mockito.mock(AFact.class);
//
//        RegisterController mockRegister = Mockito.mock(RegisterController.class);
//
//
//        RegisterController controllerUnderTest = new RegisterController(mock_PeopleDB,mock_db,mock_factory);
//        controllerUnderTest.addPerson("Anton");
//
//        Mockito.verify(mock_PeopleDB, Mockito.times(1)).addPerson(controllerUnderTest.createPerson("Anton"));
//    }


    @Test
    public void t_removePerson()
    {
        // Create mock objects for database and employee
        PeopleDB mock_PeopleDB = Mockito.mock(PeopleDB.class);
        TicketsDB mock_db = Mockito.mock(TicketsDB.class);
        AFact mock_factory = Mockito.mock(AFact.class);

        Person mock_person = Mockito.mock(Person.class);

        RegisterController controllerUnderTest = new RegisterController(mock_PeopleDB,mock_db,mock_factory);
        controllerUnderTest.addPerson(mock_person.getName());

        controllerUnderTest.removePerson(mock_person);
        Mockito.verify(mock_PeopleDB, Mockito.times(1)).removePerson(mock_person);
    }
    @Test
    public void t_printPeopleDatabase()
    {
        // Create mock objects for database and employee
        PeopleDB mock_PeopleDB = Mockito.mock(PeopleDB.class);
        TicketsDB mock_db = Mockito.mock(TicketsDB.class);
        AFact mock_factory = Mockito.mock(AFact.class);

        RegisterController controllerUnderTest = new RegisterController(mock_PeopleDB,mock_db,mock_factory);
        controllerUnderTest.printPeopleDatabase();

        Mockito.verify(mock_PeopleDB, Mockito.times(1)).printDatabase();
    }

    @Test
    public void t_printTicketDatabase()
    {
        // Create mock objects for database and employee
        PeopleDB mock_PeopleDB = Mockito.mock(PeopleDB.class);
        TicketsDB mock_db = Mockito.mock(TicketsDB.class);
        AFact mock_factory = Mockito.mock(AFact.class);

        RegisterController controllerUnderTest = new RegisterController(mock_PeopleDB,mock_db,mock_factory);
        controllerUnderTest.printTicketDatabase();

        Mockito.verify(mock_db, Mockito.times(1)).printDatabase();
    }

    @Test
    public void t_printBill()
    {
        // Create mock objects for database and employee
        PeopleDB mock_PeopleDB = Mockito.mock(PeopleDB.class);
        TicketsDB mock_db = Mockito.mock(TicketsDB.class);
        AFact mock_factory = Mockito.mock(AFact.class);

        RegisterController controllerUnderTest = new RegisterController(mock_PeopleDB,mock_db,mock_factory);
        controllerUnderTest.printBill();

        Mockito.verify(mock_PeopleDB, Mockito.times(1)).totalBill();
    }
}
