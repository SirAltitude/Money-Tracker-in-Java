package database;

import person.Person;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void addPerson(Person p) {
        this.people.add(p);
    }

    @Override
    public void removePerson(Person p) {
        this.people.remove(p);
    }

    @Override
    public void totalBill() {

    }

}
