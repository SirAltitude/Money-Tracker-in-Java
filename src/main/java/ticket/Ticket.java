package ticket;

import person.Person;

public class Ticket {
    private double paidAmount;
    private Person person;

    public Ticket(Person person, double paidAmount){
        this.paidAmount = paidAmount;
        this.person = person;
    }

    public Person getPayer()
    {
        return person;
    }
    public double getPaidAmount()
    {
        return paidAmount;
    }
}
