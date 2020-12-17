package jframe.panels;

import controller.RegisterController;
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
    private JList<String> billJlist;
    private DefaultListModel<String> billListModel;
    private RegisterController controller;

    public ListPanel(RegisterController controller) {
        ticketListModel = new DefaultListModel<>();
        personListModel = new DefaultListModel<>();
        billListModel = new DefaultListModel<>();
        ticketJList = new JList<>(ticketListModel);
        personJList = new JList<>(personListModel);
        billJlist = new JList<>(billListModel);
        this.controller = controller;

        ticketJList.setFont(new Font("Dialog", Font.PLAIN, 32));
        personJList.setFont(new Font("Dialog", Font.PLAIN, 32));
        billJlist.setFont(new Font("Dialog", Font.BOLD, 32));

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(ticketJList), BorderLayout.CENTER);
        this.add(new JScrollPane(personJList), BorderLayout.WEST);
        this.add(new JScrollPane(billJlist), BorderLayout.SOUTH);
    }

    public void addTicket(Ticket t) {
        this.ticketListModel.addElement(t);
    }

    public void addPerson(String name) {
        this.personListModel.addElement(name);
    }

    public void totalBill(String name) {
            this.billListModel.addElement(name);
    }
    public DefaultListModel getTotalBillJList()
    {
        return this.billListModel;
    }
}

