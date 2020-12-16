package jframe.panels;

import controller.RegisterController;
import jframe.BarGraph;
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

        graph.addActionListener(evt->{
            init();
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(graph);
    }
    public void changeColor()
    {
        graph.setBackground(Color.GREEN);
    }
    public void init()
    {
        JFrame frameGraph = new JFrame("Bar chart");
        frameGraph.setSize(500,500);
        BarGraph graph = new BarGraph(this.controller);
        for(Person person: controller.getPeopleDB().getList())
        {
            int value = (int)((person.getTotalDebt())/controller.getPeopleDB().getSmallestDebt());
            if(value==0) {
                if(graph.getBars().containsKey(Color.BLACK))
                graph.addBar(Color.cyan,1);
                else graph.addBar(Color.black,1);
            }
            else if(graph.getBars().containsKey(Color.GREEN))
            {
                graph.addBar(Color.RED,value);
            }
            else if(graph.getBars().containsKey(Color.BLUE))
            {
                graph.addBar(Color.GREEN,value);
            }
            else if(graph.getBars().containsKey(Color.YELLOW)) {
                graph.addBar(Color.BLUE, value);
            }
            else if(graph.getBars().containsKey(Color.GRAY)) {
                graph.addBar(Color.YELLOW, value);
            }
            else graph.addBar(Color.GRAY,value);
        }
        frameGraph.getContentPane().add(graph);
        frameGraph.setVisible(true);
    }
}
