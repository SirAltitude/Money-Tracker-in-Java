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

        addTotalBillButtonActionListener();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.printBill);
    }

    public void addTotalBillButtonActionListener()
    {
        this.printBill.addActionListener(listener -> controller.printBill());
    }
}
