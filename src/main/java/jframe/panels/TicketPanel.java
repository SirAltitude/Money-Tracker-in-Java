package jframe.panels;

import controller.RegisterController;
import person.Person;
import ticket.Ticket;
import javax.swing.*;


public class TicketPanel extends JPanel {
    private Person payingPerson;
    private String[] options;
    private String chosenPerson,chosenTicketType,inputAmount;
    private int ticketType,EventType;
    private double paidAmount,debtAmount =0;
    private Ticket t;
    private final String[] optionsTicket={"Cinema","Restaurant","Sports","Transport"};
    private boolean isSplit,canCreateTicket, cancel;

    public TicketPanel(RegisterController controller, JFrame frame) {
        JButton addTicket = new JButton("Add Ticket");

        addTicket.addActionListener(evt -> {
            cancel = false;
            while (!cancel) {
                options = controller.getNames();
                if (options.length == 0) {
                    JOptionPane.showMessageDialog(frame, "There are no people yet!");
                    cancel = true;
                } else {
                    chosenTicketType = (String) JOptionPane.showInputDialog(frame, "What kind of ticket?", "New Ticket parameters", JOptionPane.QUESTION_MESSAGE, null, optionsTicket, optionsTicket[0]);
                    if (!chosenTicketType.isEmpty()) {
                        switch (chosenTicketType) {
                            case "Restaurant":
                                EventType = 1;
                                break;
                            case "Sports":
                                EventType = 2;
                                break;
                            case "Cinema":
                                EventType = 3;
                                break;
                            case "Transport":
                                EventType = 4;
                                break;
                        }
                    } else {
                        cancel = true;
                        break;
                    }
                    chosenPerson = (String) JOptionPane.showInputDialog(frame, "Who paid?", "New Ticket Parameters", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    payingPerson = controller.getPeopleDB().getPerson(chosenPerson);
                    ticketType = JOptionPane.showConfirmDialog(frame, "Is the ticket split evenly?", "New Ticket Parameters", JOptionPane.YES_NO_OPTION);
                    if (ticketType == JOptionPane.YES_OPTION) {
                        isSplit = true;
                        inputAmount = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                        paidAmount = Double.parseDouble(inputAmount);
                        canCreateTicket = true;
                    } else {
                        isSplit = false;
                        inputAmount = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                        if (inputAmount != null) {
                            paidAmount = Double.parseDouble(inputAmount);
                            if (paidAmount == 0) {
                                canCreateTicket = false;
                                JOptionPane.showMessageDialog(frame,"You entered an incorrect value.");
                                cancel = true;
                                break;
                            }
                        }
                        double tempAmount = paidAmount;
                        for (Person person : controller.getPeopleDB().getList()) {
                            if (!person.getName().equals(payingPerson.getName())) {
                                String input = JOptionPane.showInputDialog(frame, "How much does " + person.getName() + " owe? The total value was " + paidAmount + " eur and the remaining value is " + tempAmount + " eur");
                                if ((input != null) && input.isEmpty()) {
                                    JOptionPane.showMessageDialog(frame, "You entered an incorrect value.");
                                    canCreateTicket = false;
                                    cancel = true;
                                    break;
                                }
                                else {
                                    if ((input != null))
                                        debtAmount = Double.parseDouble(input);
                                    if (debtAmount < tempAmount) {
                                        person.addDebt(payingPerson, debtAmount);
                                        tempAmount -= debtAmount;
                                    }
                                    canCreateTicket = true;
                                }
                            }
                        }
                    }
                    if (!payingPerson.getName().isEmpty() && !inputAmount.isEmpty() && !chosenTicketType.isEmpty() && canCreateTicket && !cancel) {
                        t = controller.getFactory().makeTicket(EventType, payingPerson, paidAmount, isSplit);
                        if (t != null) {
                            controller.addTicket(t);
                        } else
                            JOptionPane.showMessageDialog(frame, "Error during creation of ticket. Check your parameters.");
                    }
                }
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(addTicket);
    }
}
