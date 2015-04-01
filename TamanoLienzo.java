/**
 * @(#)TamanoLienzo.java
 *
 *
 * @author 
 * @version 1.00 2007/5/3
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TamanoLienzo extends JDialog{
	
    private JTextField 		ancho, alto;
    private JButton			aceptar;
    private JLabel			Lancho, Lalto;
    public  int				x, y;
    
    
    public  TamanoLienzo(Lienzo lienzo) {
    	super(lienzo,true);
    	setSize(230,140);
    	getContentPane();
    	setLayout(null);
    	
    	Lancho = new JLabel("Ancho");
    	Lancho.setBounds(20,10,50,20);
    	add(Lancho);
    	
    	ancho = new JTextField();
    	ancho.setBounds(100,10,70,20);
    	add(ancho);
    	
    	Lalto = new JLabel("Alto");
    	Lalto.setBounds(20,35,50,20);
    	add(Lalto);
    	
    	alto = new JTextField();
    	alto.setBounds(100,35,70,20);
    	add(alto);    	
    	
    	aceptar  = new JButton("Aceptar");
    	aceptar.setBounds(75,70,80,30);
    	aceptar.addActionListener(new aceptar_hand(lienzo));
    	add(aceptar);
    	
    	setResizable(false);
    	
    	cuadrarFrame();
    	setVisible(true);
    		
    }
    
    
    
    private void cuadrarFrame(){
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
   	Dimension dialogSize = getSize();
   		if (dialogSize.height > screen.height) {
   		dialogSize.height = screen.height;
    	}
    	if (dialogSize.width > screen.width) {
    	dialogSize.width = screen.width;
   	 	}
      setLocation((screen.width - dialogSize.width)/3 , (screen.height - dialogSize.height)/3);
    }
    
    private class aceptar_hand implements ActionListener{
		public Lienzo otro;
		public aceptar_hand(Lienzo lienzo){
			 otro = lienzo;
		}
		public void actionPerformed(ActionEvent evento){
  			try{
  				 x = Integer.parseInt(ancho.getText());
  				 y = Integer.parseInt(alto.getText());
  				 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  				 if ( x <= screen.width-300  &&  y <= screen.height-120){ 					 
  					 otro.setBounds (300,80,x,y);
  				 	 
  				 }
  				 else{
  				 	 JOptionPane.showMessageDialog(null,"tamaño demaciado grande","CAMBIO",JOptionPane.INFORMATION_MESSAGE);
  				 	 otro.setBounds (300,80,screen.width-300,screen.height-120);  				 	 
  				 }
  				 otro.setMaximumSize(new Dimension(screen.width-300,screen.height-120));
  				 otro.setVisible(true);
  				 dispose();
  			}
  			catch(Exception e){
  				System.out.println(e);
  				JOptionPane.showMessageDialog(null,"alguno de los parametros digitados no es valido \n solo valores enteros y positivos","ERROR",JOptionPane.ERROR_MESSAGE);
  			}
  			
  	    }
	
	}
    
}