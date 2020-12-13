package jframe.panels;

import controller.RegisterController;
import person.Person;
import ticket.Ticket;
import enumTicket.TicketTypeEnum;
import javax.swing.*;


public class TicketPanel extends JPanel {
    boolean split;
    private Person payingPerson;
    private String[] options;
    private String chosenPerson,chosenTicketType,inputAmount;
    private int ticketType,EventType;
    private double paidAmount,debtAmount =0;
    private Ticket t;
    private final String[] optionsTicket={"Cinema","Restaurant","Sports","Transport"};
    private TicketTypeEnum ticketTypeEnum;
    private boolean isSplit,canCreateTicket;

    public TicketPanel(RegisterController controller, JFrame frame) {
        JButton addTicket = new JButton("Add Ticket");

        addTicket.addActionListener(evt -> {
            options = controller.getNames();
            if(options.length==0) {
                System.out.println("Er zijn nog geen mensen in de trip, je kan geen tickets toevoegen.");
            }
            else {
                chosenTicketType = (String) JOptionPane.showInputDialog(frame,"What kind of ticket?","New Ticket parameters",JOptionPane.QUESTION_MESSAGE,null,optionsTicket,optionsTicket[0]);
                if(!chosenTicketType.isEmpty()) {
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
                System.out.println(EventType);
                chosenPerson = (String) JOptionPane.showInputDialog(frame, "Who paid?", "New Ticket Parameters", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                payingPerson = controller.getPeopleDB().getPerson(chosenPerson);
                System.out.println(chosenPerson);
                ticketType = JOptionPane.showConfirmDialog(frame,"Is the ticket split evenly?","New Ticket Parameters",JOptionPane.YES_NO_OPTION);
                if(ticketType == JOptionPane.YES_OPTION)
                {
                    isSplit = true;
                    inputAmount = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                    paidAmount = Double.parseDouble(inputAmount);
                    System.out.println(paidAmount);
                    canCreateTicket = true;
                }
                else {
                    isSplit = false;
                    inputAmount = JOptionPane.showInputDialog(frame, "How much is the total?", null);
                    if(inputAmount != null)
                        paidAmount = Double.parseDouble(inputAmount);
                    if(paidAmount == 0)
                        canCreateTicket = false;
                    double tempAmount = paidAmount;
                    for(Person person: controller.getPeopleDB().getList())
                    {
                        if(!person.getName().equals(payingPerson.getName()))
                        {
                            String input = (String) JOptionPane.showInputDialog(frame,"How much does "+person.getName()+" owe? \\nThe total value was "+paidAmount+"and the remaining value is "+tempAmount);
                            if((input!=null) && input.isEmpty())
                                canCreateTicket = false;
                            else{
                                if((input!=null))
                                    debtAmount = Double.parseDouble(input);
                                if(debtAmount < tempAmount)
                                {
                                    person.addDebt(payingPerson,debtAmount);
                                    tempAmount -= debtAmount;
                                }
                                canCreateTicket = true;
                            }
                        }
                    }
                }
                if (!payingPerson.getName().isEmpty() && !inputAmount.isEmpty() && !chosenTicketType.isEmpty() && canCreateTicket) {
                    t = controller.getFactory().makeTicket(EventType, payingPerson, paidAmount, isSplit);
                    if(t != null) {
                        controller.addTicket(t);
                    } else System.out.println("Error during creation of ticket!");
                }
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(addTicket);
    }
}
