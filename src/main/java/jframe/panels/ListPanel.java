package jframe.panels;

import database.RegistrationTickets;

import javax.swing.*;

public class ListPanel extends JPanel {


    private JList<RegistrationTickets> entryJList;
    private DefaultListModel<RegistrationTickets> entryListModel;

    public ListPanel()
    {
       // JLabel label = new JLabel("Registrations");
        entryListModel = new DefaultListModel<>();
        entryJList = new JList<>(entryListModel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //this.add(label);
        this.add(entryJList);
    }

    public void addEntry(RegistrationTickets entry)
    {
        this.entryListModel.addElement(entry);
    }
}

