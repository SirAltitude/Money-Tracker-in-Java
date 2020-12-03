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
            int peopleAmount = db.getList().size()-1;
            for(Person person: db.getList())
            {
                    if (peopleAmount == 1) {
                        person.addDebt(paidamount/2);
                    }
                    else person.addDebt(paidamount / peopleAmount);
            }
        }
        switch(type)
        {
            case 1:
                return new Ticket_Restaurant(p,paidamount,split);

            case 2:
                break;
            case 3:
                break;
        }
        return null;
    }

}
