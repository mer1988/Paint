package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public class OvalRelleno extends Ovalo{
    
    
    
    public OvalRelleno(){        
    }

    public void pintar(Graphics2D oval, Color color, int a, Color color2,Lienzo l ){
        oval.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        oval.setColor(color);
        super.dimenciones();
        oval.setPaint(new GradientPaint((float)oxi,(float) oyi, color, (float)w,(float)h,color2,true));
        oval.fillOval(oxi, oyi, w, h);
    }    

    public String toString(){
        return super.toString() + " relleno";
    }
    
}
