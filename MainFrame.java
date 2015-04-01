package MP;
/**
 * @(#)MainFrame.java
 *
 *
 * @author 
 * @version 1.00 2007/5/3
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class MainFrame extends JFrame{
	private MainFrame 					MFrame;
	public  ToolBar  					Tbar;
	private GridBagLayout			 	esquema;
    private GridBagConstraints 			restriccion;
	private JDesktopPane				jdpDesktop;
	public  JMenu 		 				Archivo;
	public  JMenuBar 					MenuArchivo;
    public  JMenuItem 				    Nuevo, cerrar, guardar;
    public  JButton 					Brehacer, Bdeshacer, Bguardar, Bnuevo;
    public  JPanel 						Pbotones;
	private int 						x, y;
	public  Lienzo						lienzo;
	private FileDialog 					file;
	private Dialog 						saveDialog = new Dialog(this);
    private MediaTracker 				media;
	private Image					 	imagen;
    
    
    public MainFrame() {
    	super ("Art Creator");
    	MFrame = this;
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	graficos(); 
    	setVisible(true); 
    	setResizable(false);
    	Image logo;
        logo = Toolkit.getDefaultToolkit().createImage("logo.gif");
        setIconImage(logo);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    
    
   
    public void graficos (){		
		
		guardar_hand guardarImagen = new guardar_hand();

		
		Nuevo = new JMenuItem();
		Nuevo.setText("Nuevo");
		Nuevo.addActionListener(new nuevo_hand());
		
		cerrar = new JMenuItem();
		cerrar.setText("Cerrar");
		cerrar.addActionListener(new cerrar_hand());
		
		guardar = new JMenuItem();
		guardar.setText("Guardar");
		guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        guardar.setMnemonic('S');
        guardar.addActionListener(guardarImagen);
        
        Archivo = new JMenu();
        Archivo.setText("Archivo");
        Archivo.add(Nuevo);
        Archivo.addSeparator(); 
        Archivo.add(guardar);
        Archivo.addSeparator(); 
        Archivo.add(cerrar);
        
        
        MenuArchivo=new JMenuBar();
        MenuArchivo.add(Archivo);
                
        setJMenuBar(MenuArchivo);
        jdpDesktop = new JDesktopPane();
        jdpDesktop.setBackground(new Color(196,196,196));
        setContentPane(jdpDesktop);
        
        esquema = new GridBagLayout();
        restriccion= new GridBagConstraints();
	    restriccion.fill = GridBagConstraints.HORIZONTAL;
        
        setLayout(new BorderLayout());
        Pbotones = new JPanel();
        Pbotones.setLayout(esquema);
        
        Bguardar = new JButton (new ImageIcon("save.png"));
        Bguardar.addActionListener(guardarImagen);
        Bnuevo = new JButton (new ImageIcon("new.png"));        
        Bnuevo.addActionListener(new nuevo_hand());
        
        
        Bguardar.setBackground(new Color(210, 210, 210));
        Bnuevo.setBackground(new Color(210, 210, 210));
        
        Tbar = new ToolBar();
        
        agregarComponente( Bnuevo			, 0, 0, 1, 1, Pbotones );
        agregarComponente( Bguardar			, 0, 1, 1, 1, Pbotones );
      
		
		JPanel panelNorte =new JPanel();
		panelNorte.setLayout(new BorderLayout());
        panelNorte.add(Pbotones, BorderLayout.WEST);
        add(panelNorte, BorderLayout.NORTH);
        add(Tbar, BorderLayout.WEST);
        
        
    }
    
   private void agregarComponente( Component componente, 
   									int fila, int columna, 	
   									int anchura, int altura, Container con){

    restriccion.gridx = columna;
    restriccion.gridy = fila;
       

    restriccion.gridwidth = anchura;
    restriccion.gridheight = altura;
       

    esquema.setConstraints( componente, restriccion );
    if (con != null) 
    	con.add( componente );
	}//END: agregarComponente

	public void exitInternalFrame(){
		this.setVisible(false);
	}
    
    
    private class nuevo_hand implements ActionListener{
		public void actionPerformed(ActionEvent evento){  			
  			try{ 	
  			 
  			lienzo = new Lienzo(MFrame, Tbar); 			  			
  			}
  	    	catch(Exception e){
  	    		System.out.println(e);
  	    	}
  	    	
  	    }	
	}
    
    private class guardar_hand implements ActionListener{
    	public void actionPerformed(ActionEvent evento){
    		try {
    		file = new FileDialog(saveDialog , "Guardar", FileDialog.SAVE);
    		file.setVisible(true);
    		File a = new File(file.getDirectory()+ file.getFile()+".png");
    		ImageIO.write(lienzo.getImage(), "png", a);
    		}
    		catch (Exception ex) {
			  	System.out.println (ex);
			  }
    		
    	
			  	 		
    	}
    }
    
    private class cerrar_hand implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		try{
    	 			System.exit(0);
	   	 		
			}
			catch (Exception ex) {
			}
    	}
    }    	
}