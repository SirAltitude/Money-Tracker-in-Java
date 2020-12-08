package ticket;

import person.Person;

public abstract class Ticket {
    protected double paidAmount;
    protected Person person;
    protected boolean splitEvenly;

  //alles behalve to string moet abstract zijn
    public Person getPayer()
    {
        return person;
    }
    public double getPaidAmount()
    {
        return paidAmount;
    }
    public abstract String getTicketType();
    public String toString()
    {
        return String.format("%s ticket was paid by %s for an amount of %s",this.getTicketType(),this.getPayer().getName(),this.getPaidAmount());
    }
    public boolean getSplit(){
        return splitEvenly;
    }

}
