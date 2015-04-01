package MP;
/**
 * @(#)ToolBar.java
 *
 *
 * @author 
 * @version 1.00 2007/5/8
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ToolBar extends JToolBar{
	public  JButton 	bcolor, lineaC, lineaP, rectangulo, rectOval, rectLl, rectOLl, ovalosV, ovalosF, figLibres,arcOvalos,
						bborrar, blapiz, gradiente;
	public  Color 		color = new Color (255, 135, 222), colorGrad=new Color (255, 135, 222);
	private JPanel 		panel, panel2, panel3;
	private JButton 	butcolor=new JButton();
	public  Figuras 	seleccionada;
	private String gruesos[] = {"1 px", "2 px", "3 px", "4px", "5 px"};
	public JComboBox    Grueso;
	public int a;
	public String 		nom = "";
	
		LineaSimple 		l =   	 new LineaSimple();
    	OvalRelleno 		or = 	 new OvalRelleno();
    	OvalSimple 			os =  	 new OvalSimple();
    	RectSimpRelleno 	rr = 	 new RectSimpRelleno();
    	RectRedondeado 		red = 	 new RectRedondeado();
    	RectRedonRelleno	rll = 	 new RectRedonRelleno();
    	RectSimple			rs = 	 new RectSimple();
		ArcoSimple			as = 	 new ArcoSimple();
		LineaPunteada		lp=		 new LineaPunteada();
		Lapiz				lap =    new Lapiz();
		Borrador			bor =    new Borrador();
		FigLibSimple		fl = 	 new FigLibSimple();	
    
    public ToolBar() {
    	hand handler = new hand();    
    	
    	gradiente =new JButton (new ImageIcon ("grad.jpg"));
    	gradiente.setToolTipText("Gradiente");
    	gradiente.setBackground(new Color(185, 185, 185));  
    	gradiente. setActionCommand("gradiente");
    	gradiente.addActionListener(handler);
    	
    	bborrar = new JButton(new ImageIcon("eraser.jpg"));
    	bborrar.setToolTipText("Borrador");
    	bborrar.setBackground(new Color(185, 185, 185));    	
    	bborrar. setActionCommand("borrador");
    	bborrar.addActionListener(handler);
    	   	
    	
    	blapiz = new JButton(new ImageIcon("pencil.jpg"));
    	blapiz.setToolTipText("Lápiz");
    	blapiz.setActionCommand("Lapiz");
    	blapiz.addActionListener(handler);
    	blapiz.setBackground(new Color(185, 185, 185));
    	
    	bcolor = new JButton(new ImageIcon("color.jpg"));
    	bcolor.addActionListener(new colorH());
    	bcolor.setBackground(new Color(185, 185, 185));
    	
    	lineaC = new JButton(new ImageIcon("linea.jpg"));
    	lineaC.setToolTipText("Dibuja una linea continua");
    	lineaC.setActionCommand("lineaC");
    	lineaC.addActionListener(handler);
    	lineaC.setBackground(new Color(185, 185, 185));
    	
    	lineaP = new JButton(new ImageIcon("lineaP.jpg"));
    	lineaP.setToolTipText("Dibuja una linea punteada");
    	lineaP.setActionCommand("lineaP");
    	lineaP.addActionListener(handler);
    	lineaP.setBackground(new Color(185, 185, 185));
    	
    	
    	rectangulo = new JButton(new ImageIcon("rect.jpg"));
    	rectangulo.setToolTipText("Dibuja un rectángulo vacío");
    	rectangulo.setActionCommand("rectV");
    	rectangulo.addActionListener(handler);
    	rectangulo.setBackground(new Color(185, 185, 185));
    	
    	rectOval = new JButton(new ImageIcon("rectO.jpg"));
    	rectOval.setToolTipText("Dibuja un rectángulo ovalado vacio");
    	rectOval.setActionCommand("rectOV");
    	rectOval.addActionListener(handler);
    	rectOval.setBackground(new Color(185, 185, 185));
    	
    	rectLl = new JButton(new ImageIcon("rectR.jpg"));
    	rectLl.setToolTipText("Dibuja un rectángulo con relleno");
    	rectLl.setActionCommand("rectR");
    	rectLl.addActionListener(handler);
    	rectLl.setBackground(new Color(185, 185, 185));
    	
    	rectOLl = new JButton (new ImageIcon("rectOF.jpg"));
    	rectOLl.setToolTipText("Dibuja un rectángulo ovalado con relleno");
    	rectOLl.setActionCommand("rectOR");    	
    	rectOLl.addActionListener(handler);
    	rectOLl.setBackground(new Color(185, 185, 185));
    	
    	ovalosV = new JButton(new ImageIcon("oval.jpg"));
    	ovalosV.setToolTipText("Dibuja un óvalo vacío");
    	ovalosV.setActionCommand("ovaloV");
    	ovalosV.addActionListener(handler);
    	ovalosV.setBackground(new Color(185, 185, 185));
    	
    	ovalosF = new JButton(new ImageIcon ("ovalF.jpg"));
    	ovalosF.setToolTipText("Dibuja un óvalo con relleno");
    	ovalosF.setActionCommand("ovaloR");
    	ovalosF.addActionListener(handler);
    	ovalosF.setBackground(new Color(185, 185, 185));
    	
    	figLibres = new JButton(new ImageIcon("FL.jpg"));
    	figLibres.setToolTipText("Dibuja figuras libres");
    	figLibres.setBackground(new Color(185, 185, 185));
    	figLibres.setActionCommand("fl");
    	figLibres.addActionListener(handler);
    	

    	
    	arcOvalos = new JButton(new ImageIcon ("AO.jpg"));
    	arcOvalos.setToolTipText("Dibuja arcos de óvalos");
		arcOvalos.setActionCommand("ArcS");
    	arcOvalos.setBackground(new Color(185, 185, 185));
    	arcOvalos.addActionListener(handler);
    	
    	Grueso = new JComboBox (gruesos);
    	Grueso.setVisible(false);
    	Grueso.setBackground(new Color(185, 185, 185));
    	Grueso.addItemListener(new combo_hand());
    	
    	setLayout(new BorderLayout());
    	
    	panel2=new JPanel();
    	panel3=new JPanel();
    	butcolor.setBackground(color);
    	butcolor.setEnabled(false);
    	panel3.add(butcolor, BorderLayout.CENTER);   	
    	panel2.add(panel3, BorderLayout.NORTH);	
    	panel2.add(Grueso, BorderLayout.CENTER);
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(7,1));
       	panel.add(lineaC);
       	panel.add(lineaP);
    	panel.add(rectangulo);
    	panel.add(rectLl);
    	panel.add(rectOval);
    	panel.add(rectOLl);
    	panel.add(ovalosV);
    	panel.add(ovalosF);
    	panel.add(figLibres);
    	panel.add(arcOvalos);
    	panel.add(blapiz);
    	panel.add(bborrar);
    	panel.add(bcolor);
    	panel.add(gradiente);
    	
//    	panel.add(lineaCGrueso);
    	add(panel, BorderLayout.NORTH);
    	add(panel2, BorderLayout.CENTER);
    	setOrientation(VERTICAL);
    	setFloatable(false); 
    	setRollover(true);
    	
    }
    
    public void color_selec (JButton boton){
    	bborrar.setBackground(new Color(185, 185, 185));
    	blapiz.setBackground(new Color(185, 185, 185));
    	bcolor.setBackground(new Color(185, 185, 185));
    	lineaC.setBackground(new Color(185, 185, 185));
    	lineaP.setBackground(new Color(185, 185, 185));
    	rectangulo.setBackground(new Color(185, 185, 185));
    	rectOval.setBackground(new Color(185, 185, 185));
    	rectLl.setBackground(new Color(185, 185, 185));
    	rectOLl.setBackground(new Color(185, 185, 185));
    	ovalosV.setBackground(new Color(185, 185, 185));
    	ovalosF.setBackground(new Color(185, 185, 185));
    	figLibres.setBackground(new Color(185, 185, 185));
    	arcOvalos.setBackground(new Color(185, 185, 185));
    	gradiente.setBackground(new Color(185, 185, 185));
    	
    	boton.setBackground(new Color(155, 155, 155));
    }
    
    private class colorH implements ActionListener{
    	public void actionPerformed(ActionEvent e){ 
    		color = JColorChooser.showDialog(ToolBar.this, "Escoge un color", color);
    		colorGrad = color;
    		panel3.setBackground(null);
    		butcolor.setBackground(color);
    	}	
    }
    
    
    
    private class hand implements ActionListener{
    	public void actionPerformed(ActionEvent e){    		
    	try{
    		 if (seleccionada.toString().equals("Figura Libre Simple")){
    				    seleccionada.Pintar();
    				    seleccionada.repaint();
    				  	
    		 }
    	}catch(Exception ex){
    		
    	}
    		
    		if(e.getActionCommand().equals("lineaC")){
    			 
    			  panel3.setBackground(null);
    			  seleccionada = l;
    			  colorGrad = color;
    			  Grueso.setVisible(true);
    			  color_selec(lineaC);
    			  nom = "";
    			  seleccionada.sw = 1;
    			  seleccionada.sw1 = true;
    		}
    		else{
    			if(e.getActionCommand().equals("rectV") ){
    				  panel3.setBackground(null);
    				  
    				  seleccionada = rs;
    				  	colorGrad = color;
    				  Grueso.setVisible(false);
    				  color_selec(rectangulo);
    				  nom = "";
    				  seleccionada.sw = 1;
    				  seleccionada.sw1 = true;
    			}
    			else{
    				if(e.getActionCommand().equals("rectOV") ){ 
    					
    					seleccionada = red;
    						colorGrad = color;
    					  panel3.setBackground(null);
    					Grueso.setVisible(false);
    					color_selec(rectOval);
    					nom = "";
    					seleccionada.sw = 1;
    					seleccionada.sw1 = true;
    				}
    				else{
    					if(e.getActionCommand().equals("rectR") ){
    						
    						 seleccionada = rr;
    						 	colorGrad = color;
    						   panel3.setBackground(null);
    						 Grueso.setVisible(false);
    						 color_selec(rectLl);
    						 nom = "";
    						 seleccionada.sw = 1;
    						 seleccionada.sw1 = true;
    					}
    					else
							if(e.getActionCommand().equals("rectOR") ){
								 
								 seleccionada = rll;
								 colorGrad = color;
								  panel3.setBackground(null);
								 Grueso.setVisible(false);
								 color_selec(rectOLl);
								 nom = "";
								 seleccionada.sw = 1;
								 seleccionada.sw1 = true;
							}
							else{
								if(e.getActionCommand().equals("ovaloV") ){
									 
									 seleccionada = os;
									 colorGrad = color;
									 panel3.setBackground(null);
									 Grueso.setVisible(false);
									 color_selec(ovalosV);
									 nom = "";	
									 seleccionada.sw = 1;
									 seleccionada.sw1 = true;								 
								}
								else{
									if(e.getActionCommand().equals("ovaloR") ){
										 
										 seleccionada = or;
										 colorGrad = color;
										 panel3.setBackground(null);
										 Grueso.setVisible(false);
										 color_selec(ovalosF);
										 nom = "";	
										 seleccionada.sw = 1;
										 seleccionada.sw1 = true;									 
									}
									else{
										if(e.getActionCommand().equals("ArcS")){
											
											seleccionada = as;
											colorGrad = color;
											panel3.setBackground(null);
											Grueso.setVisible(false);
											color_selec(arcOvalos);	
											nom = "";	
											seleccionada.sw = 1;
											seleccionada.sw1 = true;
											
										}
										else{
											if(e.getActionCommand().equals("lineaP")){
											
												seleccionada = lp;
												colorGrad = color;
												  panel3.setBackground(null);
												Grueso.setVisible(true);
												color_selec(lineaP);
												nom = "";
												seleccionada.sw = 1;
												seleccionada.sw1 = true;
											}
											else{
												if(e.getActionCommand().equals("Lapiz")){
													
													seleccionada = lap;
													  panel3.setBackground(null);
													Grueso.setVisible(true);
													color_selec(blapiz);
													nom = "lapiz";
													seleccionada.sw = 1;
													seleccionada.sw1 = true;
												}
												else{
													if(e.getActionCommand().equals("borrador")){
														
														seleccionada = bor;
														  panel3.setBackground(null);
													
														Grueso.setVisible(true);
														color_selec(bborrar);
														nom = "borrador";
														seleccionada.sw = 1;
														seleccionada.sw1 = true;														
													}
													else{
														if(e.getActionCommand().equals("gradiente")){
															color_selec(gradiente);
															colorGrad = JColorChooser.showDialog(ToolBar.this, "Escoge el color para el gradiente", colorGrad);
    														panel3.setBackground(colorGrad);
    														if (colorGrad==null)	colorGrad=color;    													
														}
														else{
															if (e.getActionCommand().equals("fl")){
																seleccionada = fl;
																nom = "";
																panel3.setBackground(null);
																color_selec(figLibres);
																seleccionada.sw = 1;
																seleccionada.sw1 = true;
															}
														}
													}
												}
											}
										}
									}
								}
							}	
    				}	
    			}
    		}
    	  
    	  
    	}   
         
    }
    private class combo_hand implements ItemListener{
    	public void itemStateChanged( ItemEvent e ){
    		a = Grueso.getSelectedIndex();
    	}
    }
    
    
    
}