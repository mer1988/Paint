package MP;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

public abstract class Ovalo extends Figuras{
    
    public int oxi, oyi, w, h;
    
    public Ovalo(){        
    }

    public int getH() {
        return h;
    }

    public abstract void pintar(Graphics2D grafico, Color color, int a, Color color2,Lienzo l );
       
    
    public void dimenciones(){
    	 if (xi>xf){
            if (yi>yf){
                oxi = xf;
                oyi = yf;
                w = xi-xf;
                h = yi-yf;
            }
            else{
                oxi = xf;
                oyi = yi;
                w = xi-xf;
                h = yf-yi;
            }
        }
        else{
            if (yi>yf){
                oxi = xi;
                oyi = yf;
                w = xf-xi;
                h = yi-yf;        
            }
            else{
                oxi = xi;
                oyi = yi;
                w = xf-xi;
                h = yf-yi;
            }
        }
    }

    public String toString(){
        return "Ovalo";
    }
    
}
