package ticket;

import person.Person;

public class Ticket {
    private double paidAmount;
    private Person person;
    private String eventType;

    public Ticket(Person person, double paidAmount, String eventType){
        this.paidAmount = paidAmount;
        this.person = person;
        this.eventType = eventType;
    }

    public Person getPayer()
    {
        return person;
    }
    public double getPaidAmount()
    {
        return paidAmount;
    }
    public String getEventType()
    {
        return eventType;
    }
}
