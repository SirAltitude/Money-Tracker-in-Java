package observers;

import person.Person;
import ticket.Ticket;

import java.util.Observable;
import java.util.Observer;

public class ObserverEntryPerson implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(((Person)arg).getDeleted()) {
            System.out.println(((Person) arg).getName() + " was removed from the trip.");
        }
        else {
            System.out.println(((Person) arg).getName() + " was added to the trip.");
        }
    }
}
