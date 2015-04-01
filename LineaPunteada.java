package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;


public class LineaPunteada extends Figuras{    
    
    public LineaPunteada(){        
    }
    
    public void pintar(Graphics2D linea, Color color, int a, Color color2,Lienzo l ){
   		linea.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        linea.setPaint(new GradientPaint((float)xi,(float) yi, color, (float)xf,(float)yf,color2,true));       
        linea.setStroke(new BasicStroke( a+1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{ 8f, 6f }, 1 ));
        linea.drawLine(xi, yi, xf, yf);
        linea.setStroke(new BasicStroke( a+1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{ 10f, 0f }, 0 ));
    }
    public String toString(){
    	return "Linea Punteada";
    }
}