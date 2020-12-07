package database;
import person.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class RegistrationPeople extends PeopleDB {

    private final ArrayList<Person> people;
    private static RegistrationPeople registrationPeople_instance;
    private List<Observer> observers;
    private Person key;

    private RegistrationPeople()
    {
        this.people = new ArrayList<>();
        this.observers = new ArrayList<>();
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
    public void addPerson(Person p) {
        this.people.add(p);
        setChanged();
        this.key = p;
        this.notifyObservers();
    }

    @Override
    public void removePerson(Person p) {
        this.people.remove(p);
    }

    @Override
    public void totalBill() {
//        for(Person person: people)
//        {
//            if(person.getDebt()==0.0)
//            {
//                System.out.println(person.getName()+" owes nothing!");
//            }
//            else System.out.println(person.getName()+ " owes "+ person.getDebt()+ " to everyone else.");
//        }
        for(Person person: people)
        {
            person.printDebts();
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
    public void printDatabase() {
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
        for(Observer obs: observers) {
            obs.update(this, key);
        }
    }
}
