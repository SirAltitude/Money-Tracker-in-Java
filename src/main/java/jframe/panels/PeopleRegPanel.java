package jframe.panels;

import controller.RegisterController;
import person.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PeopleRegPanel extends JPanel {
    private JButton addPerson;
    String name;
    private JButton removePerson;

    private RegisterController controller;


    public PeopleRegPanel(RegisterController controller, JFrame frame) {
       // JLabel label = new JLabel("Registration of people");
       // label.setFont(new Font("Veranda",Font.BOLD,12));
        this.addPerson = new JButton("Add Person");
        this.removePerson = new JButton("Remove Person");
        this.controller = controller;

        addPerson.addActionListener(evt -> {
                    name = JOptionPane.showInputDialog(frame, "What is the person's name?", null);
                    controller.addPerson(name);
                } //      Code from: https://stackoverflow.com/questions/8852560/how-to-make-popup-window-in-java
        );

       // this.add(label);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.addPerson);
        this.add(this.removePerson);
    }
}
