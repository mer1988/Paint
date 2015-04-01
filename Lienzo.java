package MP;
/**
 * @(#)Lienzo.java
 *
 *
 * @author 
 * @version 1.00 2007/5/3
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Lienzo extends JDialog{
	private BufferedImage 				buffer1, buffer2, aux, aux2;
	public  ToolBar 					t;
	public  Graphics2D					grafico1, grafico2, gaux, gaux2;
	public  LinkedList<BufferedImage>	deshacer, rehacer;
	private boolean sw = true;
    
    public Lienzo(MainFrame f, ToolBar t){    	
    	super (f);    	
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	setBounds(110,75,screen.width-110,screen.height-80);
    	this.t = t;    
    	buffer1 = new BufferedImage(getSize().width,getSize().height,1);
		buffer2 = new BufferedImage(getSize().width,getSize().height,1);
			  	
	  	grafico1 = buffer1.createGraphics();
	  	grafico2 = buffer2.createGraphics();
  		grafico1.setColor(Color.WHITE);
  		grafico2.setColor(Color.WHITE);
  		grafico1.fillRect(0,0,getSize().width,getSize().height);
	  	grafico2.fillRect(0,0,getSize().width,getSize().height);  			 	  			 
		deshacer = new LinkedList();
		rehacer = new LinkedList();						      	
    	setDefaultLookAndFeelDecorated(false);
    	setResizable(false);
    	setVisible(true);
    	setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    	addMouseListener(new mouse_hand()); 
    	addMouseMotionListener(new mouseM_hand());
    	addKeyListener(new deshacer_hand());   	
    }
    
    
    
    public void pintar_figura(){
    	
    	t.seleccionada.pintar(grafico1, t.color, t.a, t.colorGrad, this);    	
		
	
    }
    
    private class mouse_hand extends MouseAdapter{
    	public void mousePressed( MouseEvent event ){
    		try{    		
    		    	
    			
    			if(t.seleccionada.toString().equals("Figura Libre Simple")){    				
    				
    						if (t.seleccionada.sw==2){
    							t.seleccionada.xf = event.getX();
    							t.seleccionada.yf = event.getY();
    						}    						
    					
    					pintar_figura();
    					repaint();     													
    			}    		
    				
    			t.seleccionada.xi = event.getX();
    			t.seleccionada.yi = event.getY();	
    	 			
    		}
    		catch(Exception e){    			
    		}    		
    	}
    	
    	public void mouseReleased(MouseEvent event){
			try{ 
				    t.seleccionada.xf = event.getX();
				    t.seleccionada.yf = event.getY();
				    if (t.seleccionada.toString()=="Figura Libre Simple"){
    					if (t.seleccionada.sw==1){
    						t.seleccionada.fxf = event.getX();
    						t.seleccionada.fyf = event.getY();
    						t.seleccionada.sw = 2;
    					}
    					else{
    						if (t.seleccionada.sw==2){
    							t.seleccionada.fxf = event.getX();
    							t.seleccionada.fyf = event.getY();
    						}    						
    					}    			
    				}
					repaint();
					guarda();
			}
			catch(Exception e){    				
    		}
							
		}	
			    
    }
    
    
    private class mouseM_hand extends MouseMotionAdapter{
    	
    	public void mouseDragged(MouseEvent event){
    	  try{ 
    		
    		t.seleccionada.xf = event.getX();
    		t.seleccionada.yf = event.getY();  		
    		setTitle(t.seleccionada.toString()+"@ ["+ event.getX()+","+ event.getY()+"]");
    		efecto();
    		pintar_figura();    		
    		if (t.nom.equals("lapiz")|| t.nom.equals("borrador"))  guarda();
    		
    		if (t.nom.equals("lapiz")){
    			t.seleccionada.xi = t.seleccionada.xf;
    			t.seleccionada.yi = t.seleccionada.yf;
    		}   			
    		
    		repaint();
    	  }
    	  catch(Exception e){    				
    	  }    		
    	}
    	
    	public void mouseMoved( MouseEvent event ){
    		try{    		
    			setTitle(t.seleccionada.toString()+"@ ["+ event.getX()+","+ event.getY()+"]");     			  		
    		}
    		catch(Exception e){
    			setTitle("@ ["+ event.getX()+","+ event.getY()+"]");	    			
    		}
    	}  
    }
    
    public void paint(Graphics g)	{	    
		g.drawImage(buffer1,0,0,this);	  	
	}
	
	public void efecto(){
		grafico1.drawImage(buffer2,0,0,this);	
		
	}
	
	public void guarda(){   
	    
	    if (deshacer.size()>=4){	    
	    	 deshacer.removeFirst();   
		}	
	    aux = new BufferedImage(getSize().width,getSize().height,1);
	    gaux = aux.createGraphics();
	    gaux.drawImage(buffer2,0,0,this);
	    deshacer.add(aux);
	    
	    grafico2.drawImage(buffer1,0,0,this);    
	   
	    	
	}

    
	public BufferedImage getImage(){
		return buffer2;
	}
	
	private class deshacer_hand extends KeyAdapter{		
		public void keyPressed(KeyEvent event){				
			if(event.getKeyText( event.getKeyCode()).equals("D")){				
				if(deshacer.size()>0){							
					
					aux2 = new BufferedImage(getSize().width,getSize().height,1);
	   				gaux2 = aux2.createGraphics();
				    gaux2.drawImage(buffer2,0,0,Lienzo.this);
					if (rehacer.size()>=4) rehacer.removeFirst();
					rehacer.add(aux2);
					
					grafico1.drawImage(deshacer.removeLast(),0,0,Lienzo.this);					
					
					grafico2.drawImage(buffer1,0,0,Lienzo.this);		
				   	
					
					repaint();
					
//					
													
				}				
		    }
		    else{
		    	if(event.getKeyText( event.getKeyCode()).equals("R")){
		    	  if(rehacer.size() > 0){
		    	   	
		    		grafico1.drawImage(rehacer.removeLast(),0,0,Lienzo.this);
					grafico2.drawImage(buffer1,0,0,Lienzo.this);
					repaint();
		    	  }
		    	}
		    	
		    }
		}
	}
    
}