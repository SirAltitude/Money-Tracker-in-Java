package observers;

import person.Person;
import ticket.Ticket;

import java.util.Observable;
import java.util.Observer;

public class ObserverEntryPerson implements Observer {
    public ObserverEntryPerson()
    {

    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((Person)arg).getName() + " was added to the trip.");
    }
}
