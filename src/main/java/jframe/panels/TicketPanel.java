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
    private Ticket t;


    public TicketPanel(RegisterController controller, JFrame frame) {
        JButton addTicket = new JButton("Add Ticket");

        addTicket.addActionListener(evt -> {
            options = controller.getNames();
            if(options.length==0) {
                System.out.println("Er zijn nog geen mensen in de trip, je kan geen tickets toevoegen.");
            }
            else {
                chosen = (String) JOptionPane.showInputDialog(frame, "Who paid?", "New Ticket Parameters", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                payingPerson = controller.getPeopleDB().getPerson(chosen);
                System.out.println(payingPerson.getName());
                chosen = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                paidAmount = Double.parseDouble(chosen);
                System.out.println(paidAmount);
                split = true;
                if (!payingPerson.getName().isEmpty() && !chosen.isEmpty()) {
                    t = controller.getFactory().makeTicket(1, payingPerson, paidAmount, split);
                    controller.addTicket(t);
                }
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(addTicket);
    }
}
