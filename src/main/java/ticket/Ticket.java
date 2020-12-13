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
        return String.format("%s paid ''%s'', %seur",this.getPayer().getName(),this.getTicketType(),this.getPaidAmount());
    }
    public boolean getSplit(){
        return splitEvenly;
    }

}
