 package MP;
 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

public class FigLibSimple extends Figuras{
	
	Graphics2D otro;
	Lienzo l;
	
	public FigLibSimple(){
	}
	
	public void pintar(Graphics2D fl, Color color, int a, Color color2, Lienzo l){
		fl.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        fl.setColor(color);        
        otro = fl;
        this.l = l;
        if (sw1){
        	fxi = xi;
        	fyi = yi;
        	sw1 = false;
        }
        if (sw==1){
        	fl.drawLine(xi, yi, xf, yf);
        	fxi = xi;
        	fyi = yi;
        }
        else{
        	if (sw==2){
        		fl.drawLine(fxf, fyf, xf, yf); 
        	}       	 			        	 
        }	 
	}	
		
	public String toString(){
		return "Figura Libre Simple";
	}
	public void Pintar(){
		otro.drawLine(xf,yf,fxi,fyi);
    	
	}
	public void repaint(){
		l.repaint();
		l.guarda();
	}
	
}	