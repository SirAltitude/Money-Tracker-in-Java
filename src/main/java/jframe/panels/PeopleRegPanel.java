package jframe.panels;

import controller.RegisterController;
import person.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PeopleRegPanel extends JPanel {
    private JButton addPerson;
    String name;
    private JButton removePerson;

    private RegisterController controller;
    private Person p;

    public PeopleRegPanel(Person p, RegisterController controller, JFrame frame) {
        JLabel label = new JLabel("Registration of people");
        this.addPerson = new JButton("Add Person");
        this.removePerson = new JButton("Remove Person");
        this.controller = controller;
        this.p = p;

        addPersonAdderButtonActionListener();
        addPerson.addActionListener(evt -> name = JOptionPane.showInputDialog(frame,"What is the person's name?",null));
//      Code from: https://stackoverflow.com/questions/8852560/how-to-make-popup-window-in-java

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(label);
        this.add(this.addPerson);
        this.add(this.removePerson);
    }

    public void addPersonAdderButtonActionListener()
    {
       this.addPerson.addActionListener(listener -> controller.addPerson(name));
    }

    public void addPersonRemoverButtonActionListener()
    {
        this.addPerson.addActionListener(listener ->
        {
            //controller.removePerson();
        });
    }
}
