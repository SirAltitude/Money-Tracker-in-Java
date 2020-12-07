package jframe;

import controller.RegisterController;
import jframe.panels.ListPanel;
import jframe.panels.PeopleRegPanel;
import jframe.panels.TotalBillPanel;
import person.Person;

import javax.swing.*;
import java.awt.*;

public class ViewFrame extends JFrame {
    RegisterController register;
    ListPanel panel;
    PeopleRegPanel buttonsReg;
    TotalBillPanel buttonTotalBill;
    Person p1;

    public ViewFrame(RegisterController register, Person p1)
    {
        super("Expenses organizer");
        this.register = register;
        this.p1 = p1;
    }

    public void initialize()
    {
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        buttonsReg = new PeopleRegPanel(p1, register, this);
        buttonTotalBill = new TotalBillPanel(register, this);

        panel = new ListPanel();

        this.add(panel);
        this.add(buttonsReg);
        this.add(buttonTotalBill);
        this.setVisible(true);
    }
}
