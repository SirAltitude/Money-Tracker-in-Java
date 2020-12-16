package jframe.panels;

import controller.RegisterController;
import jframe.ChartPanel;
import person.Person;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private JButton graph;
    private RegisterController controller;

    public GraphPanel(RegisterController controller, JFrame frame)
    {
        this.graph = new JButton("Create Graph");
        graph.setBackground(Color.RED);
        graph.setFont(new Font("Dialog", Font.PLAIN, 32));
        graph.revalidate();
        this.controller = controller;

        graph.addActionListener(evt->
            init()
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(graph);
    }
    public void changeColor()
    {
        graph.setBackground(Color.GREEN);
    }
    public void init()
    {
        JFrame f = new JFrame();
        f.setSize(400,300);
        double[] values = new double[(controller.getPeopleDB().getList().size())];
        String[] names = new String[values.length];
        int i=0;
        for(Person person: controller.getPeopleDB().getList())
        {
            values[i] = person.getTotalDebt();
            names[i] = person.getName()+": "+person.getTotalDebt()+"eur";
            i++;
        }
        f.getContentPane().add(new ChartPanel(values,names,"Bar Chart"));
        f.setVisible(true);
    }
}
