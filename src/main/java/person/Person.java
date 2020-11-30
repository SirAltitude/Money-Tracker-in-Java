package person;

import java.util.HashMap;

public class Person {
    private String name;

    public Person(String name)
    {
    this.name = name;
    }
    public String getName() //through this method, regController can access the name of a Person
    {
        return name;
    }
}
// arraylist van tickets