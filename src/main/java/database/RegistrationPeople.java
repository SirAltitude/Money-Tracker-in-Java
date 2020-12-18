package database;
import iterator.Container;
import iterator.Iterator;
import person.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class RegistrationPeople extends PeopleDB implements Container {

    private final ArrayList<Person> people;
    private final ArrayList<Person> deletedPeople;
    private static RegistrationPeople registrationPeople_instance;
    private List<Observer> observers;
    private Person key;
    private Person notifiedPerson;
    private boolean billCalculated = false;

    private RegistrationPeople()
    {
        this.people = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.deletedPeople = new ArrayList<>();
    }

    public static RegistrationPeople getInstance()
    {
        if(registrationPeople_instance == null) {
            registrationPeople_instance = new RegistrationPeople();
        }
        return registrationPeople_instance;
    }

    @Override
    public ArrayList<Person> getList()
    {
        return this.people;
    }

    @Override
    public ArrayList<Person> getDeletedPeople()
    {
        return this.deletedPeople;
    }
    @Override
    public void addPerson(Person p) {
        this.people.add(p);
        notifiedPerson = p;
        setChanged();
        this.key = p;
        this.notifyObservers();
    }

    @Override
    public void removePerson(Person p) {
        this.people.remove(p);
        this.deletedPeople.add(p);
        notifiedPerson = p;
        p.setDeleted();
        setChanged();
        this.key = p;
        this.notifyObservers();
    }

    @Override
    public void totalBill() {
        System.out.println("\n---- Total Bill -----");
        calcDebts();
        for(Person person: people)
        {
            System.out.println(person.printDebts());
        }
        for(Person person: deletedPeople)
        {
            person.printDebts();
        }
        billCalculated = false;
    }

    public void calcDebts()
    {
        for(Person person: people)
        {
            for(Person p: people)
            {
                if(!p.getName().equals(person.getName()))
                {
                    if(p.getDebts().containsKey(person) && person.getDebts().containsKey(p))
                    {
                        if(p.getDebts().get(person) >= person.getDebts().get(p))
                        {
                            double finalval = (p.getDebts().get(person) - person.getDebts().get(p));
                            p.setDebtFinal(person,finalval);
                            person.getDebts().remove(p);
                        }
                        else if (p.getDebts().get(person) <= person.getDebts().get(p))
                        {
                            double finalval = (person.getDebts().get(p) - p.getDebts().get(person));
                            person.setDebtFinal(p,finalval);
                            p.getDebts().remove(person);
                        }
                    }
                }
            }
        }
    }

    @Override
    public Person getPerson(String name) {
        for(Person p: people)
        {
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    @Override
    public boolean hasPerson(String name) {
        for(Person person: people)
        {
            if(person.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printDatabase() {
        System.out.println("\n---- People on this trip ----");
        for(Person p: people)
        {
            System.out.println(p.getName());
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this, this.notifiedPerson);
        }
    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    private class PeopleIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < people.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext())
            {
                //return people[index++];
            }
            return null;
        }
    }
}
