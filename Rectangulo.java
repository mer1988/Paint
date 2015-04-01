package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public abstract class Rectangulo extends Figuras{
    
    public int rxi, ryi, w, h;
    
    public Rectangulo(){   
    }

    public abstract void pintar(Graphics2D grafico, Color color, int a, Color color2,Lienzo l );
        
       
	
	public void dimenciones (){
		if (xi>xf){
            if (yi>yf){
                rxi = xf;
                ryi = yf;
                w = xi-xf;
                h = yi-yf;
            }
            else{
                rxi = xf;
                ryi = yi;
                w = xi-xf;
                h = yf-yi;
            }
        }
        else{
            if (yi>yf){
                rxi = xi;
                ryi = yf;
                w = xf-xi;
                h = yi-yf;
            }
            else{
                rxi = xi;
                ryi = yi;
                w = xf-xi;
                h = yf-yi;
            }
        }
	}
	
    public String toString(){
        return "Rectangulo";
    } 

}
