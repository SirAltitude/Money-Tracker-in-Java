package jframe;

import controller.RegisterController;
import person.Person;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BarGraph extends JPanel {
    private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>();
    private RegisterController controller;

    public BarGraph(RegisterController controller)
    {
        this.controller = controller;
    }

    /**
     * Add new bar to chart
     *
     * @param color color to display bar
     * @param value size of bar
     */
    public void addBar(Color color, int value) {
        bars.put(color, value);
        repaint();
    }

    public Map<Color,Integer> getBars()
    {
        return this.bars;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // determine longest bar
        int max = Integer.MIN_VALUE;
        max = Math.max(max,(int)(controller.getPeopleDB().getGreatestDebt()/controller.getPeopleDB().getSmallestDebt()));
        System.out.println(max);

        // paint bars
        int width = (getWidth() / bars.size()) - 2;
        int x = 1;
        for (Color color : bars.keySet()) {
            int value = bars.get(color);
            int height = (int) ((getHeight() - 5) * ((double) value / max));
            g.setColor(color);
            g.fillRect(x, getHeight() - height, width, height);
            g.setColor(Color.black);
            g.drawRect(x, getHeight() - height, width, height);
            x += (width + 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bars.size() * 10 + 2, 50);
    }
}