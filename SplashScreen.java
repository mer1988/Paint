package MP;
import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {
  private int 			duration;
  private ImageIcon 	image;

  public SplashScreen(int d, ImageIcon image) {
    duration = d;
    this.image = image;
    showSplash();
  }

  public void showSplash() {
    JPanel content = (JPanel) getContentPane();
    content.setBackground(Color.white);
    
    int width = image.getIconWidth()+2; 
    int height = image.getIconHeight()+2;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;
    setBounds(x, y, width, height);

    
    JLabel label = new JLabel(image);    
    content.add(label, BorderLayout.CENTER);    
    Color oraRed = Color.BLACK;
    content.setBorder(BorderFactory.createLineBorder(oraRed, 2));

    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try {
      Thread.sleep(duration);
    } catch (Exception e) {
    }

    setVisible(false);
    dispose();
  }
  

}