import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ButtonPanel extends JPanel
{
    private JButton clearButton, pickColorButton;
    private JPanel currentDrawingColor;
    private DrawingCanvas canvas;

    /**
     * Constructor for objects of class ButtonPanel
     */
    public ButtonPanel(DrawingCanvas c)
    {
        canvas = c;
        
        this.pickColorButton = new JButton("Pick Color");
        this.clearButton = new JButton("Clear");
        this.currentDrawingColor = new JPanel();
        
        
        ButtonClickListener clearButtonListener = new ButtonClickListener();
        ButtonClickListener pickColorButtonListener = new ButtonClickListener();
        
        currentDrawingColor.setBackground(canvas.getColor());
        
        this.add(this.pickColorButton);
        this.add(currentDrawingColor);
        this.add(this.clearButton);
        
        clearButton.addActionListener(clearButtonListener);
        pickColorButton.addActionListener(pickColorButtonListener);
    }

    public class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getActionCommand().equals(pickColorButton.getText()))
            {
                canvas.pickColor();
                currentDrawingColor.setBackground(canvas.getColor());
            }
            else if(event.getActionCommand().equals(clearButton.getText()))
            {
                canvas.clearCanvas();
            }
            canvas.repaint();
        }
    }
}
