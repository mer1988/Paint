package MP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public abstract class  Figuras{
    
    public int xi, yi, xf, yf, fxf, fyf;
    public int fxi, fyi;
    public int sw = 1;
    public boolean sw1 = true;
    
    public Figuras(){        
    	
    }
    
    public abstract void pintar(Graphics2D grafico, Color color, int a, Color color2, Lienzo l);
    public abstract String toString();	
    public void Pintar(){
    }
    public void repaint(){
    }
}