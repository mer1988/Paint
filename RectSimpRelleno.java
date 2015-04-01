package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public class RectSimpRelleno extends Rectangulo{
    
   
    
    public RectSimpRelleno(){        
    }
    
    public void pintar(Graphics2D rect, Color color, int a, Color color2,Lienzo l ){
        rect.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);        
        super.dimenciones();
        rect.setPaint(new GradientPaint((float)rxi,(float) ryi, color, (float)w,(float)h,color2,false));
        rect.fillRect(rxi, ryi, w, h);
    }
    

    public String toString(){
        return super.toString() + " simple relleno";
    }    

}
