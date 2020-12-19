package factory;

import person.Person;
import ticket.Ticket;

public abstract class AFact {

    public abstract Ticket makeTicket(String type, Person p, double paidAmount, boolean split); // cinematicket, bowlingticket, ...

}
