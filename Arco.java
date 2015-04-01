package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public abstract class Arco extends Figuras{
	
	public int axi, ayi, w, h;
	
	public Arco(){
	}
	
	public abstract void pintar(Graphics2D grafico, Color color, int a, Color color2,Lienzo l );
	
	public void dimenciones(){
    	 if (xi>xf){
            if (yi>yf){
                axi = xf;
                ayi = yf;
                w = xi-xf;
                h = yi-yf;
            }
            else{
                axi = xf;
                ayi = yi;
                w = xi-xf;
                h = yf-yi;
            }
        }
        else{
            if (yi>yf){
                axi = xi;
                ayi = yf;
                w = xf-xi;
                h = yi-yf;        
            }
            else{
                axi = xi;
                ayi = yi;
                w = xf-xi;
                h = yf-yi;
            }
        }
    }
	
	public String toString(){
		return "Arco ";
	}
}