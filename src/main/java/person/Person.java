package person;

import java.util.HashMap;

public class Person {
    private HashMap<String, Double> map;

    public Person(String name, double paidAmount)
    {
        this.map = new HashMap<String, Double>();
        this.map.put(name,paidAmount);

    }
}
// arraylist van tickets