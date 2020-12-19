package person;

import ticket.Ticket;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

public class Person {
    private String name;
    private ArrayList<Ticket> tickets;
    private HashMap<Person, Double> debts;
    private boolean deleted;
    private static DecimalFormat df = new DecimalFormat("0.00");
    private ArrayList<String> output ;

    public Person(String name)
    {
    this.name = name;
    tickets = new ArrayList<>();
    debts = new HashMap<>();
    output = new ArrayList<>();
    deleted = false;
    }

    public String getName() //through this method, regController can access the name of a Person
    {
        return name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }
    public HashMap<Person, Double> getDebts()
    {
        return this.debts;
    }
    public ArrayList<String> printDebts()
    {
        output.clear();
        Set entrySet = debts.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry<Person, Double> mapEntry = (Map.Entry<Person, Double>)it.next();
            output.add(this.name+" owes "+mapEntry.getKey().getName()+", "+df.format((mapEntry.getValue()))+"eur.");
            // Formatting double: https://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java
        }
        if(debts.size() == 0)
        {
            output.add(this.name+" owes no-one!");
        }
        return output;


//        for(Map.Entry<Person, Double> entry: this.debts.entrySet())
//        {
//            output.add(this.name + " owes "+entry.getKey().getName()+", "+df.format((entry.getValue()))+"eur.");
//            // Formatting double: https://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java
//
//        }
//        if(debts.size() == 0)
//        {
//            output.add(this.name+" owes no-one!");
//        }
//        return output;
    }

    public void addTicket(Ticket t)
    {
        tickets.add(t);
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

    public double getTotalDebt()
    {
        double tempVal = 0;
        for(Object value: debts.values())
        {
            tempVal += (Double) value;
        }
        return tempVal;
    }
    public void setDebtFinal(Person person, double value)
    {
        debts.put(person,value);
    }

    public String toStringModified()
    {
        if(this.deleted)
            return this.name +" was removed from the trip.";
        else return this.name+" was added to the trip.";
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
