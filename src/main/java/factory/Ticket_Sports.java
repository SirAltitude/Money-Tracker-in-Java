package factory;

import person.Person;
import ticket.Ticket;

public class Ticket_Sports extends Ticket {

    public Ticket_Sports(Person person, double paidAmount, boolean split)
    {
        super.paidAmount = paidAmount;
        super.person = person;
        super.splitEvenly = split;
    }

    @Override
    public String getTicketType(){return "SportsEvent";}
}
