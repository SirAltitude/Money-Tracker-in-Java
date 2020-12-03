package Factory;

import person.Person;
import ticket.Ticket;

public class TicketMaker extends AFact{
    private static TicketMaker registrationTicketMaker_instance;

    public static TicketMaker getInstance()
    {
        if(registrationTicketMaker_instance == null) {
            registrationTicketMaker_instance = new TicketMaker();
        }
        return registrationTicketMaker_instance;
    }

    @Override
    public Ticket makeTicket(int type, Person p, double paidamount) {
        switch(type)
        {
            case 1: return new Ticket_Restaurant(p,paidamount);
            case 2:
                break;
            case 3:
                break;
        }
        return null;
    }

}
