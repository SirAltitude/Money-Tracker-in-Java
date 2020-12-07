package person;

import ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Person {
    private String name;
    private ArrayList<Ticket> tickets;
    private HashMap<Person, Double> debts;
    private double debt;

    public Person(String name)
    {
    this.name = name;
    tickets = new ArrayList<>();
    debts = new HashMap<>();
    debt = 0;
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
            System.out.println(this.name + " owes "+entry.getKey().getName()+", "+entry.getValue()+"euros.");
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
    public void addDebt(Person person,double value){
        double previousval = 0;
        double newval =0;
        if(debts.size()!=0) {
            previousval = debts.get(person);
            newval = previousval + value;
            debts.put(person,newval);
        }
        else debts.put(person,value);
    }

    public double getDebt()
    {
        return debt;
    }
}
