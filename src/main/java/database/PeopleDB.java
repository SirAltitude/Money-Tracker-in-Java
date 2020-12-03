package database;
import person.Person;


import java.util.ArrayList;

public abstract class PeopleDB {

    public PeopleDB(){}

    public abstract void addPerson(Person p);
    public abstract void removePerson(Person p);
    public abstract void totalBill();
    public abstract Person getPerson(String name);
    public abstract ArrayList<Person> getList();
    // test methods
    public abstract void printDatabase();
}

