package Factory;

import database.PeopleDB;
import database.RegistrationPeople;
import database.RegistrationTickets;
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
    public Ticket makeTicket(int type, Person p, double paidamount, boolean split) {
        if(split)
        {
            PeopleDB db = RegistrationPeople.getInstance();
            int peopleAmount = db.getList().size();
            for(Person person: db.getList())
            {
                if(person.getName().equals(p.getName()))
                {
                    //do nothing
                }
                else person.addDebt(paidamount / peopleAmount);
            }
        }
        switch(type)
        {
            case 1:
                return new Ticket_Restaurant(p,paidamount,split);
            case 2:
                return new Ticket_Sports(p,paidamount,split);
            case 3:
                return new Ticket_Cinema(p,paidamount,split);
            case 4:
                return new Ticket_Transport(p,paidamount,split);
        }
        return null;
    }

}
