package MP;
/**
 * @(#)Lapiz.java
 *
 *
 * @author 
 * @version 1.00 2007/5/13
 */
import java.awt.*;

public class Lapiz extends Figuras{
	int x1, y2;
	
    public Lapiz() {
    }
    
    public void pintar(Graphics2D dibujo, Color color, int a, Color color2, Lienzo l){
    	
    	dibujo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	dibujo.setColor(color);
    	dibujo.setStroke(new BasicStroke( a+1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{ 10f, 0f }, 0 ));
    	dibujo.drawLine(xi, yi,xf,yf);
    
    }
    public String toString (){
    	return "lapiz";
    }
}