package jframe.panels;

import database.RegistrationTickets;
import person.Person;
import ticket.Ticket;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {


    private JList<Ticket> ticketJList;
    private JList<Person> personJList;
    private DefaultListModel<Ticket> ticketListModel;
    private DefaultListModel<Person> personListModel;

    public ListPanel()
    {
        ticketListModel = new DefaultListModel<>();
        personListModel = new DefaultListModel<>();
        ticketJList = new JList<>(ticketListModel);
        personJList = new JList<>(personListModel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        personJList.setBounds(0,10,50,50);
        ticketJList.setBounds(500,50,10,10);

        this.setLayout(new BorderLayout());
        this.add(ticketJList,BorderLayout.SOUTH);
        this.add(personJList,BorderLayout.NORTH);
    }

    public void addTicket(Ticket t)
    {
        this.ticketListModel.addElement(t);
    }
    public void addPerson(Person p)
    {
        this.personListModel.addElement(p);
    }
    public void printBill(Person p) {
        this.personListModel.addElement(p);
    }
}

