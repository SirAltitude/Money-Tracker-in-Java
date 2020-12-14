package jframe.panels;

import controller.RegisterController;

import javax.swing.*;

public class GraphPanel extends JPanel {
    private JButton graph;
    private RegisterController controller;

    public GraphPanel(RegisterController controller, JFrame frame)
    {
        this.graph = new JButton("Create Graph");
        this.controller = controller;

        graph.addActionListener(evt->
                System.out.println("Test"));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(graph);
    }
}
