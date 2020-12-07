package jframe.panels;

import controller.RegisterController;
import person.Person;
import ticket.Ticket;

import javax.swing.*;


public class TicketPanel extends JPanel {
    boolean split;
    private Person payingPerson;
    private String[] options;
    private String chosen;
    private double paidAmount =0;

    public TicketPanel(RegisterController controller, JFrame frame) {
        JButton addTicket = new JButton("Add Ticket");

        addTicket.addActionListener(evt -> {
            options = controller.getNames();
            chosen = (String)JOptionPane.showInputDialog(frame, "Who paid?", "New Ticket Parameters",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            payingPerson = controller.getPeopleDB().getPerson(chosen);
            chosen = JOptionPane.showInputDialog(frame,"How much is the total?",null);
            paidAmount = Double.parseDouble(chosen);
            split = true;
            Ticket t = controller.getFactory().makeTicket(1,payingPerson,paidAmount,split);
            controller.addTicket(t);
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(addTicket);
    }
}
