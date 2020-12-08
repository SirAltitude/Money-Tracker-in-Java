package observers;

import ticket.Ticket;

import java.util.Observable;
import java.util.Observer;

public class ObserverEntryTicket implements Observer {
    public ObserverEntryTicket(){}

    @Override
    public void update(Observable o, Object arg) {
        System.out.println((((Ticket)arg).getPayer().getName()+" paid \""+(((Ticket)arg).getTicketType())+", "+(((Ticket)arg).getPaidAmount())+"eur\""));
    }
}
