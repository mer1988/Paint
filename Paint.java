package MP;
/**
 * @(#)Paint.java
 *
 *
 * @author 
 * @version 1.00 2007/5/3
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Paint {
	private static MainFrame 	 principal;
	
	
    public Paint() {
    }
     public static void main (String[] Args){
     		SplashScreen splash = new SplashScreen(2500, new ImageIcon("splash.jpg") );
     		principal = new MainFrame();      		    				
     }
    
}