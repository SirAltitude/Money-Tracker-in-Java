package jframe.panels;

import controller.RegisterController;
import person.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TicketPanel extends JPanel {
    private JButton addTicket;
    boolean split;
    private Person payingPerson;
    private String[] options;

    private RegisterController controller;
    public TicketPanel(RegisterController controller, JFrame frame) {
        this.addTicket = new JButton("Add Ticket");
        this.controller = controller;

        addTicket.addActionListener(evt -> {
            options = controller.getNames();
            String chosen = (String)JOptionPane.showInputDialog(frame, "Who paid?", "New Ticket Parameters",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            System.out.println(chosen);
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(this.addTicket);
    }
}
