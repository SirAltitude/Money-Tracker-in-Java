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

import static java.awt.GridBagConstraints.PAGE_END;

public class ViewFrame extends JFrame implements Observer {
    RegisterController register;
    ListPanel observerOutput;
    PeopleRegPanel buttonsReg;
    TotalBillPanel buttonTotalBill;
    TicketPanel buttonTicket;
    GraphPanel buttonGraph;
    JFrame frame;
    private GridBagConstraints gbc;
    private boolean updatedColor = false;

    public ViewFrame(RegisterController register)
    {
        super("Trip Money Tracker");
        this.register = register;
        gbc = new GridBagConstraints();
    }

    @Override
    public void update(Observable o, Object arg) { //Observer
        if(o instanceof RegistrationTickets) {
            observerOutput.addTicket((Ticket) arg);
            changeColor();
        }
    else if(o instanceof RegistrationPeople){
            observerOutput.addPerson(((Person)arg).toStringModified());
            changeColor();
        }
    }
    // Source for the "instance of":
    // https://stackoverflow.com/a/8034790/1746118

    public void addComponentsToPane(Container pane)
    {
        pane.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        buttonsReg = new PeopleRegPanel(register,frame);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridy = 0;
        pane.add(buttonsReg,gbc);

        buttonTicket = new TicketPanel(register,frame);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        pane.add(buttonTicket,gbc);

        observerOutput = new ListPanel(this.register);

        buttonTotalBill = new TotalBillPanel(register,frame,observerOutput);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 3;
        gbc.gridy = 0;
        pane.add(buttonTotalBill,gbc);

        buttonGraph = new GraphPanel(register,frame);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 4;
        gbc.gridy = 0;
        pane.add(buttonGraph,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.weightx = 0.0;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = PAGE_END;

        pane.add(observerOutput, gbc);

        // Gridbag Constraints source:
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

    }
    public void createAndShowGUI()
    {
        frame = new JFrame("Money Tracker");
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("./money-bag.png"));
        if(icon == null)
        {
            System.out.println("Error loading icon.");
        }else {
            frame.setIconImage(icon.getImage());
        }
        frame.setPreferredSize(new Dimension(1200,650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        // Place of above method is special
        // Source: https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        frame.setVisible(true);
//        setResizable(true);
    }
    public void changeColor()
    {
        if(!updatedColor) {
            if(register.getPeopleDB().getList().size() >=1)
                buttonsReg.changeColor();
            if(register.getPeopleDB().getList().size() >=2) {
                buttonTicket.changeColor();
            }
            if(register.getTicketsDB().getList().size()>=1) {
                buttonTotalBill.changeColor();
                buttonGraph.changeColor();
                updatedColor = true;
            }
        }
    }
}
