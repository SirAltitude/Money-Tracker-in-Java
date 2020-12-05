package jframe.panels;

import controller.RegisterController;
import person.Person;

import javax.swing.*;

public class RegistrationButtonPanel extends JPanel {
    private JButton addPerson;
    private JButton removePerson;

    private RegisterController controller;
    private Person p;

    public RegistrationButtonPanel(Person p, RegisterController controller) {
        JLabel label = new JLabel("Registration of people");
        this.addPerson = new JButton("Add Person");
        this.removePerson = new JButton("Remove Person");
        this.controller = controller;
        this.p = p;

        addPersonAdderButtonActionListener();

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(label);
        this.add(this.addPerson);
        this.add(this.removePerson);
    }

    public void addPersonAdderButtonActionListener()
    {

        this.addPerson.addActionListener(listener -> controller.addPerson("TEST"));
    }

    public void addPersonRemoverButtonActionListener()
    {
        this.addPerson.addActionListener(listener ->
        {
            // controller.removePerson();
        });
    }
}
