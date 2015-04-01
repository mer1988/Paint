package MP;
/**
 * @(#)Lapiz.java
 *
 *
 * @author 
 * @version 1.00 2007/5/13
 */
import java.awt.*;

public class Borrador extends Figuras{

    public Borrador() {
    }
    
    public void pintar(Graphics2D dibujo, Color color, int a, Color color2,Lienzo l){
    	dibujo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	dibujo.setColor(Color.WHITE);
    	dibujo.fillRect(xf,yf,a+10,a+10);
    }
    public String toString (){
    	return "Borrador";
    }
}