package jframe;

import controller.RegisterController;
import database.RegistrationPeople;
import database.RegistrationTickets;
import jframe.panels.*;
import person.Person;
import ticket.Ticket;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ViewFrame extends JFrame implements Observer {
    RegisterController register;
    ListPanel panel;
    PeopleRegPanel buttonsReg;
    TotalBillPanel buttonTotalBill;
    TicketPanel buttonTicket;
    private GridBagConstraints gbc;

    public ViewFrame(RegisterController register)
    {
        super("Trip Money Tracker");
        this.register = register;
        gbc = new GridBagConstraints();
    }

    public void initialize()
    {
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        buttonsReg = new PeopleRegPanel(register, this);
        buttonTotalBill = new TotalBillPanel(register, this);
        buttonTicket = new TicketPanel(register,this);

        panel = new ListPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(buttonsReg,gbc);

        gbc.gridx = 1;
        this.add(buttonTotalBill,gbc);

        gbc.gridx= 2;
        this.add(buttonTicket,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(panel,gbc);
        this.setVisible(true);
        this.setResizable(true);
    }

    @Override
    public void update(Observable o, Object arg) { //Observer
        if(o instanceof RegistrationTickets) {
            panel.addTicket((Ticket) arg);
        }
    else if(o instanceof RegistrationPeople){
            panel.addPerson(((Person)arg).toStringModified());
        }
    }
}
