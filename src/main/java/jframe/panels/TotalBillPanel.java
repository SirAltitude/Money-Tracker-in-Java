package jframe.panels;

import controller.RegisterController;
import person.Person;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TotalBillPanel extends JPanel {
    private JButton printBill;
    private RegisterController controller;
    private ArrayList<String> listOutput;

    public TotalBillPanel(RegisterController controller, JFrame frame, ListPanel panel)
    {
        this.printBill = new JButton("Print Total Bill");
        listOutput = new ArrayList<>();
        printBill.setBackground(Color.RED);
        this.controller = controller;
        printBill.setFont(new Font("Dialog", Font.PLAIN, 32));
        printBill.revalidate();
        printBill.addActionListener(evt -> {
            if(controller.getTicketsDB().getList().size()>=1 )
            {
                panel.getTotalBillJList().clear();
                controller.printBill();
                for(Person person: controller.getPeopleDB().getList())
                {
                    listOutput.clear();
                    listOutput = person.printDebts();
                    for(String string: listOutput)
                    {
                        panel.totalBill(string);
                    }

                }
                for(Person person: controller.getPeopleDB().getDeletedPeople())
                {
                    listOutput.clear();
                    listOutput = person.printDebts();
                    for (String string: listOutput)
                    {
                        panel.totalBill(string);
                    }
                }
//                panel.totalBill();
            } else JOptionPane.showMessageDialog(frame,"There are not enough people yet!");
        });

//        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.printBill);
    }
    public void changeColor()
    {
        printBill.setBackground(Color.GREEN);
    }

}
