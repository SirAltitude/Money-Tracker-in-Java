package factory;

import database.PeopleDB;
import database.RegistrationPeople;
import person.Person;
import ticket.*;


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
    public Ticket makeTicket(String type, Person p, double paidamount, boolean split) {
        PeopleDB db = RegistrationPeople.getInstance();
        int peopleAmount = db.getList().size();
        if(split)
        {
            java.util.Iterator<Person> it = db.getList().iterator();
            while(it.hasNext())
            {
                Person person = it.next();
                if(!person.getName().equals(p.getName())) {
                    person.addDebt(p,paidamount/peopleAmount);
                }
            }
        }
        switch(type)
        {
            case "Restaurant":
                return new Ticket_Restaurant(p,paidamount,split);
            case "Sports":
                return new Ticket_Sports(p,paidamount,split);
            case "Cinema":
                return new Ticket_Cinema(p,paidamount,split);
            case "Transport":
                return new Ticket_Transport(p,paidamount,split);
        }
        return null;
    }

}
