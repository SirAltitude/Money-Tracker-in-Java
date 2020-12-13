package person;

import ticket.Ticket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Person {
    private String name;
    private ArrayList<Ticket> tickets;
    private HashMap<Person, Double> debts;
    private double debt;
    private boolean deleted;
    private static DecimalFormat df = new DecimalFormat("0.00");


    public Person(String name)
    {
    this.name = name;
    tickets = new ArrayList<>();
    debts = new HashMap<>();
    debt = 0;
    deleted = false;
    }

    public String getName() //through this method, regController can access the name of a Person
    {
        return name;
    }

    public HashMap<Person, Double> getDebts()
    {
        return this.debts;
    }
    public void printDebts()
    {

        for(Map.Entry<Person, Double> entry: this.debts.entrySet())
        {
            System.out.println(this.name + " owes "+entry.getKey().getName()+", "+df.format((entry.getValue()))+"euros.");
            // Formatting double: https://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java

        }
        if(debts.size() == 0)
        {
            System.out.println(this.name+" owes no-one!");
        }
    }
    public void addTicket(Ticket t)
    {
        tickets.add(t);
    }

    public void printTickets(){
        for(Ticket ticket: tickets)
        {
            System.out.println(ticket.getTicketType() + ", value: "+ticket.getPaidAmount());
        }
    }
    public void addDebt(Person person,double value) {
        double previousval;
        double newval;
        if (debts.containsKey(person)) {
            previousval = debts.get(person);
            newval = previousval + value;
            debts.put(person, newval);
        } else if (value != 0)
            debts.put(person, value);
    }
    public void setDebtFinal(Person person, double value)
    {
        debts.put(person,value);
    }

    public HashMap<Person, Double> getDebt()
    {
        return debts;
    }
    public String toStringModified()
    {
        if(this.deleted)
            return String.format("%s was removed from the trip.",this.name);
        else return String.format("%s was added to the trip.",this.name);
    }

    public void setDeleted()
    {
        deleted = true;
    }
    public boolean getDeleted()
    {
        return deleted;
    }

}
