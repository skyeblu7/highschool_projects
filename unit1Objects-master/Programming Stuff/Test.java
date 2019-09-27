import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Test
{
    public static void main(String[] args) throws Exception
    {
       URL imageLocation = new URL(
             "https://s-media-cache-ak0.pinimg.com/236x/07/27/ca/0727cae96cdccc7b8db0713ab102c336.jpg");
       JOptionPane.showMessageDialog(null, "Justice", "Title",
             JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }
}