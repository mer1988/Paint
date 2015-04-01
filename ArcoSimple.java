package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public class ArcoSimple extends Arco{
	
	public ArcoSimple(){
	}
	
	public void pintar(Graphics2D arco, Color color, int a, Color color2,Lienzo l ){
		arco.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		
		super.dimenciones();
		arco.setPaint(new GradientPaint((float)axi,(float) ayi, color, (float)w,(float)h,color2,true));
		if (xi>xf){
			if (yi>yf){
				arco.drawArc(axi, ayi, w, h, 90, 180);
			}
			else{
				arco.drawArc(axi, ayi, w, h, 90, -180);
			}
		}
		else{
			if (yi>yf){
				arco.drawArc(axi, ayi, w, h, 0, 180);
			}
			else{
				arco.drawArc(axi, ayi, w, h, 0, -180);
			}
			
		}		
		
	}
	
	public String toString(){
		return super.toString() + "Simple";
	}
}