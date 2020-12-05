package factory;

import person.Person;
import ticket.Ticket;

public abstract class AFact {

    public abstract Ticket makeTicket(int type, Person p, double paidAmount, boolean split); // cinematicket, bowlingticket, ...

    public Person createPerson(String name)
    {
        return new Person(name);
    }

//    public Ticket createTicket(Person person, double paidAmount, String eventType){
//        return new Ticket(person,paidAmount,eventType);
//    }

    public AFact getFactory(){
        return this;
    }
}
