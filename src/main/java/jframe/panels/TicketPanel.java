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
                if (options.length <= 1) {
                    JOptionPane.showMessageDialog(frame, "There are not enough people yet!");
                    cancel = true;
                } else {
                    Object temp = JOptionPane.showInputDialog(frame, "What kind of ticket?", "New Ticket parameters", JOptionPane.QUESTION_MESSAGE, null, optionsTicket, optionsTicket[0]);
                    if(temp == null)
                    {
                        cancel = true;
                        break;
                    }
                    chosenTicketType = String.valueOf(temp);
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
                    }
                    temp = JOptionPane.showInputDialog(frame, "Who paid?", "New Ticket Parameters", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if(temp == null)
                    {
                        cancel = true;
                        break;
                    }
                    chosenPerson = String.valueOf(temp);
                    payingPerson = controller.getPeopleDB().getPerson(chosenPerson);
                    ticketType = JOptionPane.showConfirmDialog(frame, "Is the ticket split evenly?", "New Ticket Parameters", JOptionPane.YES_NO_OPTION);
                    if (ticketType == JOptionPane.YES_OPTION) {
                        isSplit = true;
                        temp = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                        if(temp == null)
                        {
                            cancel = true;
                            break;
                        }
                        else {
                            paidAmount = Double.parseDouble(String.valueOf(temp));
                            canCreateTicket = true;
                        }
                    }
                    else if(ticketType == JOptionPane.CANCEL_OPTION)
                    {
                        cancel = true;
                        break;
                    }
                    else {
                        isSplit = false;
                        temp = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                        if(temp == null)
                        {
                            cancel = true;
                            break;
                        }
                        else {
                            paidAmount = Double.parseDouble(String.valueOf(temp));
                            if (paidAmount == 0) {
                                canCreateTicket = false;
                                JOptionPane.showMessageDialog(frame, "You entered an incorrect value.");
                                cancel = true;
                                break;
                            }
                        }
                        double tempAmount = paidAmount;
                        for (Person person : controller.getPeopleDB().getList()) {
                            if (!person.getName().equals(payingPerson.getName())) {
                                Object input = JOptionPane.showInputDialog(frame, "How much does " + person.getName() + " owe? The total value was " + paidAmount + " eur and the remaining value is " + tempAmount + " eur");
                                if(input == null)
                                {
                                    cancel = true;
                                    break;
                                }
                                else {
                                    debtAmount = Double.parseDouble(String.valueOf(input));
                                    if (debtAmount < tempAmount) {
                                        person.addDebt(payingPerson, debtAmount);
                                        tempAmount -= debtAmount;
                                        canCreateTicket = true;
                                    }
                                    else {
                                        cancel = true;
                                        JOptionPane.showMessageDialog(frame,"You entered a value greater than the total value.");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (!payingPerson.getName().isEmpty() && !chosenTicketType.isEmpty() && canCreateTicket && !cancel) {
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
