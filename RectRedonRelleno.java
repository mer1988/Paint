package MP;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.geom.*;

public class RectRedonRelleno extends Rectangulo{
    
 
    
    public RectRedonRelleno(){        
    }
    
    public void pintar(Graphics2D rect, Color color, int a, Color color2,Lienzo l ){
        rect.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rect.setColor(color);
        super.dimenciones();
        rect.setPaint(new GradientPaint((float) rxi,(float) ryi, color, (float)w,(float)h,color2,true));
        rect.fillRoundRect(rxi, ryi, w, h, 50, 50);
    }

    public String toString(){
        return super.toString() + " redondeado relleno";
    }    

}