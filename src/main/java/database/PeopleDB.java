package database;
import org.omg.CORBA.PERSIST_STORE;
import person.Person;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class PeopleDB extends Observable {
    public abstract void addPerson(Person p);
    public abstract void removePerson(Person p);
    public abstract void totalBill();
    public abstract Person getPerson(String name);
    public abstract boolean hasPerson(String name);
    public abstract ArrayList<Person> getList();
    public abstract ArrayList<Person> getDeletedPeople();

    public abstract void printDatabase();

    public abstract void addObserver(Observer o);

    public abstract void deleteObserver(Observer o);

    public abstract void notifyObservers();

}

