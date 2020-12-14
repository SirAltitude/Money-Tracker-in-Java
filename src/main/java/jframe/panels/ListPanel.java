package jframe.panels;

import database.RegistrationTickets;
import person.Person;
import ticket.Ticket;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {


    private JList<Ticket> ticketJList;
    private JList<String> personJList;
    private DefaultListModel<Ticket> ticketListModel;
    private DefaultListModel<String> personListModel;

    public ListPanel()
    {
        ticketListModel = new DefaultListModel<>();
        personListModel = new DefaultListModel<>();
        ticketJList = new JList<>(ticketListModel);
        personJList = new JList<>(personListModel);

//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        personJList.setBounds(0,10,50,50);
//        ticketJList.setBounds(500,50,10,10);
//
        ticketJList.setFont(new Font("Dialog", Font.PLAIN, 32));
        personJList.setFont(new Font("Dialog", Font.PLAIN, 32));

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(ticketJList),BorderLayout.SOUTH);
        this.add(new JScrollPane(personJList),BorderLayout.CENTER);
    }

    public void addTicket(Ticket t)
    {
        this.ticketListModel.addElement(t);
    }
    public void addPerson(String name)
    {
        this.personListModel.addElement(name);
    }

}

