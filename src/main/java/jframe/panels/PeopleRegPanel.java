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
    private Person toBeRemoved;
    private String[] options;
    private RegisterController controller;


    public PeopleRegPanel(RegisterController controller, JFrame frame) {
       // JLabel label = new JLabel("Registration of people");
       // label.setFont(new Font("Veranda",Font.BOLD,12));
        this.addPerson = new JButton("Add Person");
        this.removePerson = new JButton("Remove Person");
        this.controller = controller;

        addPerson.addActionListener(evt -> {
                    name = JOptionPane.showInputDialog(frame, "What is the person's name?", null);
                    if(!(name == null) && !name.isEmpty())
                        if(controller.getPeopleDB().hasPerson(name))
                        {
                            JOptionPane.showMessageDialog(frame,"This person has already been added!");
                        }
                        else {
                            controller.addPerson(name);
                        }
                } //      Code from: https://stackoverflow.com/questions/8852560/how-to-make-popup-window-in-java
        );
        removePerson.addActionListener(evt -> {
            options = controller.getNames();
            if(options.length != 0) {
                Object temp= JOptionPane.showInputDialog(frame, "Who left the trip?", "Remove a person", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(temp != null) {
                    name = String.valueOf(temp);
                    if (!name.isEmpty()) {
                        toBeRemoved = controller.getPeopleDB().getPerson(name);
                        controller.removePerson(toBeRemoved);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"There are no people yet!");
            }
        });

       // this.add(label);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(this.addPerson);
        this.add(this.removePerson);
    }
}
