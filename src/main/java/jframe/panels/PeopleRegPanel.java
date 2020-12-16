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
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.addPerson = new JButton("Add Person");
        addPerson.setFont(new Font("Dialog", Font.PLAIN, 32));
        addPerson.setSize(200,55);
        addPerson.setBackground(Color.green);
        addPerson.revalidate();

        this.removePerson = new JButton("Remove Person");
        removePerson.setFont(new Font("Dialog", Font.PLAIN, 32));
        removePerson.setSize(200,55);
        removePerson.setBackground(Color.RED);
        removePerson.revalidate();

        this.controller = controller;

        addPerson.addActionListener(evt -> {
            if(controller.getPeopleDB().getList().size()<=4) {
                name = JOptionPane.showInputDialog(frame, "What is the person's name?", null);
                if (!(name == null) && !name.isEmpty())
                    if (controller.getPeopleDB().hasPerson(name)) {
                        JOptionPane.showMessageDialog(frame, "This person has already been added!");
                    } else {
                        controller.addPerson(name);
                    }
            } else JOptionPane.showMessageDialog(frame,"Maximum number of people reached!");
            SwingUtilities.updateComponentTreeUI(frame);
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


        this.add(this.addPerson);
        this.add(this.removePerson);
    }
    public void changeColor()
    {
        removePerson.setBackground(Color.green);
    }
}
