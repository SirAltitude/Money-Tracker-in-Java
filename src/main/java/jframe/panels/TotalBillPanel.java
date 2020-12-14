package jframe.panels;

import controller.RegisterController;

import javax.swing.*;

public class TotalBillPanel extends JPanel {
    private JButton printBill;

    private RegisterController controller;

    public TotalBillPanel(RegisterController controller, JFrame frame)
    {
        this.printBill = new JButton("Print Total Bill");
        this.controller = controller;

        printBill.addActionListener(evt -> {
            if(controller.getNames().length > 1)
            {
                controller.printBill();
            } else JOptionPane.showMessageDialog(frame,"There are not enough people yet!");
        });

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.printBill);
    }


}
