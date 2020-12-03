package ticket;

import person.Person;

public abstract class Ticket {
    protected double paidAmount;
    protected Person person;

    public Ticket(){
        this.paidAmount = 0;
    }

    public Person getPayer()
    {
        return person;
    }
    public double getPaidAmount()
    {
        return paidAmount;
    }
    public abstract String getTicketType();

}
