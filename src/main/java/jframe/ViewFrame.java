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

//    public void initialize()
//    {
//        setSize(600,300);
//        JPanel pane = new JPanel();
//        pane.setLayout(new GridBagLayout());
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        buttonTicket = new TicketPanel(register,this);
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        buttonTicket.setPreferredSize(new Dimension(200,55));
//        gbc.fill = GridBagConstraints.BOTH;
//        add(buttonTicket,gbc);
//        buttonsReg = new PeopleRegPanel(register, this);
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        add(buttonsReg,gbc);
//
////        this.setBounds(100,100,500,300);
////        this.setLocationRelativeTo(null);
////        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        this.setLayout(new GridBagLayout());
////        gbc = new GridBagConstraints();
////        gbc.fill = GridBagConstraints.HORIZONTAL;
////
////        buttonsReg = new PeopleRegPanel(register, this);
////        buttonTotalBill = new TotalBillPanel(register, this);
////
////        gbc.fill = GridBagConstraints.HORIZONTAL;
//////        gbc.weightx = 0.5;
////        gbc.gridx = 1;
////        gbc.gridy = 0;
////
////        this.add(buttonsReg,gbc);
////
////        gbc.fill = GridBagConstraints.HORIZONTAL;
////        gbc.gridx = 2;
////        this.add(buttonTotalBill, gbc);
//
////        gbc.fill = GridBagConstraints.HORIZONTAL;
////
////        buttonTicket = new TicketPanel(register,this);
////        gbc.fill = GridBagConstraints.HORIZONTAL;
////
////        buttonGraph = new GraphPanel(register,this);
////        gbc.fill = GridBagConstraints.HORIZONTAL;
//
////        panel = new ListPanel();
//
////        JPanel panelTest = new JPanel();
////        panelTest.setLayout(new BorderLayout(0,0));
//
////        GridBagLayout layout = new GridBagLayout();
////        this.setLayout(layout);
////        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
//        // Above line of code from: https://stackoverflow.com/questions/761341/error-upon-assigning-layout-boxlayout-cant-be-shared
//
//
//
////        buttonGraph.setPreferredSize(new Dimension(500,100));
////        panelTest.add(buttonGraph);
////        getContentPane().add(panelTest, BorderLayout.CENTER);
//////        gbc.gridx = 0;
//////        gbc.gridy = 0;
//////        this.add(buttonsReg);
//////
//////        gbc.gridx = 1;
//////        this.add(buttonTotalBill);
//////
//////        gbc.gridx= 2;
//////        this.add(buttonTicket);
////        this.add(buttonGraph);
//////
//////        gbc.gridx = 1;
//////        gbc.gridy = 3;
//////        this.add(panel);
////
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setResizable(true);
//    }

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

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.weightx = 0.0;
        gbc.gridwidth = 4;
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
        frame.setPreferredSize(new Dimension(1100,650));
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
                updatedColor = true;
            }
        }
    }
}
