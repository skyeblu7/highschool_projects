package FractalTreeLab;

//********************************************************************
//  FractalTreeViewer.java       Author: Kristopher Koepcke
//
//  Demonstrates the use of recursion.
//  @Krkoepcke (19 Feb 2016): converted from an applet to an application
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractalTreeViewer implements ActionListener
{
    private final int WIDTH = 900;
    private final int HEIGHT = 900;

    private final int MIN = 1, MAX = 18;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private FractalTree drawing;
    private JPanel panel, tools;
    private JFrame frame;
    
    private int order = 0;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        FractalTreeViewer viewer = new FractalTreeViewer();
    }

    public FractalTreeViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("Fractal Tree Lab");
        titleLabel.setForeground (Color.black);

        increase = new JButton (new ImageIcon ("increaseButton.gif"));
        increase.setPressedIcon (new ImageIcon ("increasePressedButton.gif"));
        increase.setMargin (new Insets (0, 0, 0, 0));
        increase.addActionListener (this);
        decrease = new JButton (new ImageIcon ("decreaseButton.gif"));
        decrease.setPressedIcon (new ImageIcon ("decreasePressedButton.gif"));
        decrease.setMargin (new Insets (0, 0, 0, 0));
        decrease.addActionListener (this);

        orderLabel = new JLabel ("Order: 0");
        orderLabel.setForeground (Color.black);

        tools.add (titleLabel);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (decrease);
        tools.add (increase);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (orderLabel);

        drawing = new FractalTree(0, WIDTH, HEIGHT);

        panel = new JPanel();
        panel.add (tools);
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

    //-----------------------------------------------------------------
    //  Determines which button was pushed, and sets the new order
    //  if it is in range.
    //-----------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
        if (event.getSource() == increase)
        {
            this.order++;
        }
        else
        {
            this.order--;
        }

        if (order >= MIN && order <= MAX)
        {
            orderLabel.setText ("Order: " + this.order);
            drawing.setCurrent(this.order);
            frame.repaint();
        }
    }
}
