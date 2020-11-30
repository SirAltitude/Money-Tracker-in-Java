package database;
import person.Person;

public abstract class PeopleDB {

    public PeopleDB(){}

    public abstract void addPerson(Person p);
    public abstract void removePerson(Person p);
    public abstract void totalBill();
}

