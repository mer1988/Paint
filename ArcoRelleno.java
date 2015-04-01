package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public class ArcoRelleno extends Arco{
	
	public ArcoRelleno(){
	}
	
	public void pintar(Graphics2D arco, Color color, int a){
		arco.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		arco.setColor(color);
		super.dimenciones();
		arco.fillArc(axi, ayi, w, h, 0, 145);				
	}
	
	public String toString(){
		return super.toString() + "Relleno";
	}
}