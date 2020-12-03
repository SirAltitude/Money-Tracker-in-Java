package Factory;

import person.Person;
import ticket.Ticket;

public class Ticket_Restaurant extends Ticket {

    public Ticket_Restaurant(Person person, double paidAmount){
        super.paidAmount = paidAmount;
        super.person = person;
    }

    @Override
    public String getTicketType()
    {
        return "Restaurant";
    }

}
