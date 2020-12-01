package Factory;

import database.RegistrationPeople;
import person.Person;
import ticket.Ticket;

public abstract class AFact {

    public abstract Ticket makeTicket(); // cinematicket, bowlingticket, ...

    public Person getPerson(String name)
    {
        return new Person(name);
    }

    public Ticket getTicket(Person person, double paidAmount, String eventType){
        return new Ticket(person,paidAmount,eventType);
    }
}
