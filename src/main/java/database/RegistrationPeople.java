package database;
import person.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RegistrationPeople extends PeopleDB {

    private final ArrayList<Person> people;
    private static RegistrationPeople registrationPeople_instance;

    private RegistrationPeople()
    {
        this.people = new ArrayList<Person>();
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
    }

    @Override
    public void removePerson(Person p) {
        this.people.remove(p);
    }

    @Override
    public void totalBill() {
        for(Person person: people)
        {
            if(person.getDebt()==0.0)
            {
                System.out.println(person.getName()+" owes nothing!");
            }
            else System.out.println(person.getName()+ " owes "+ person.getDebt()+ " to everyone else.");
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
}
