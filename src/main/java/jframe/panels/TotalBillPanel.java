package jframe.panels;

import controller.RegisterController;

import javax.swing.*;
import java.awt.*;

public class TotalBillPanel extends JPanel {
    private JButton printBill;

    private RegisterController controller;

    public TotalBillPanel(RegisterController controller, JFrame frame)
    {
        this.printBill = new JButton("Print Total Bill");
        printBill.setBackground(Color.RED);
        this.controller = controller;
        printBill.setFont(new Font("Dialog", Font.PLAIN, 32));
        printBill.revalidate();
        printBill.addActionListener(evt -> {
            if(controller.getNames().length > 1)
            {
                controller.printBill();
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
