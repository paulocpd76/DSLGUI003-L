package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Printable;
import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import Controller.DilmoXML;
import Controller.ValtionDIL;
import Proxemic.Dilmo;
import Proxemic.ProxZone;
import dilmo004.Proxemic;
import dilmo004.Proxemic.Entity;

import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Window;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Choice;

import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Gui {


	private static final Object BorderLayout = null;
	private JFrame frame;
	private String xmlPath;
	private String xdsPath;
	private File   xmlPathObjec;
	private JInternalFrame f1[];
	private JSlider[] s;
	JTextArea txtrHol,textArea,textArea_1,textArea_2 ;
	String[] strArray1;
	public ProxZone validationdl;
	public Dilmo dil;
	ArrayList<Proxemic.Entity> entities;
    private Highlighter.HighlightPainter cyanPainter;
    private Highlighter.HighlightPainter redPainter;
	
	public JInternalFrame[] getF1() {
		return f1;
	}

	public void setF1(JInternalFrame[] f1) {
		this.f1 = f1;
	}

	public File getXmlPathObjec() {
		return xmlPathObjec;
	}

	public void setXmlPathObjec(File xmlPathObjec) {
		this.xmlPathObjec = xmlPathObjec;
	}

	String getXmlPath() {
		return xmlPath;
	}

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	public String getXdsPath() {
		return xdsPath;
	}

	public void setXdsPath(String xdsPath) {
		this.xdsPath = xdsPath;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1303, 804);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    txtrHol = new JTextArea();
	    txtrHol.setFont(new Font("Monospaced", Font.BOLD, 18));
		JButton btnNewButton = new JButton("Xml file"
				+ "");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Create a file chooser
		        JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(btnNewButton);
				File file = fc.getSelectedFile();
				setXmlPathObjec(file);
				setXmlPath(file.getAbsolutePath());
				JInternalFrame[] fra = (JInternalFrame[]) getF1();
				if (fra==null) System.out.println("new");
				else {
					
					for (int i = 0; i < fra.length; i++) {
						fra[i].setVisible(false);	
					}
				} 
				
				
				
			}
		});
		btnNewButton.setBounds(800, 282, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnXsdFile = new JButton("Xsd file");
		btnXsdFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog( btnXsdFile);
				 File file = fc.getSelectedFile();
				 setXdsPath(file.getAbsolutePath());
				 
			}
		});
		btnXsdFile.setBounds(800, 340, 97, 25);
		frame.getContentPane().add(btnXsdFile);
		
		
		JPanel panel = new JPanel();
		//panel.add(BorderLayout.CENTER, new JScrollPane(panel));

		panel.setBackground(new Color(0, 255, 127));
		panel.setBounds(23, 13, 758, 469);
		frame.getContentPane().add(panel);
		//frame.getContentPane().add(new JScrollPane(panel));
		//frame.add(BorderLayout., new JScrollPane(panel));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
		
			private Dilmo dil;
			private ProxZone validationdl;
			
			public void actionPerformed(ActionEvent e) {
				  DilmoXML dilmo= new DilmoXML();
				
				if(dilmo.validateXMLSchema(getXdsPath(),getXmlPath())) {
					//System.out.println(getXmlPathObjec().getName());
					//dilmo.getDilmlXmlFile(getXmlPathObjec().getName(), "dilmo002");
					List<Entity> e1 =dilmo.getLitsOfEntity(getXmlPathObjec().getName(), "dilmo004");
					String CPS= dilmo.getCPSinfo(getXmlPathObjec().getName(),"dilmo004");
					ImageIcon cps = new ImageIcon("img/cps2.png", "a pretty but meaningless splat");
					
					JLabel lblNewLabel_1 = new JLabel();
					lblNewLabel_1.setIcon(cps);
					lblNewLabel_1.setBounds(800, -160, 600, 500);
					frame.getContentPane().add(lblNewLabel_1);
					//Image cps = new Image
					//cps.se;
					 String[] arrOfCps = CPS.split("-");
					 //intimate
					 JLabel intimate = new JLabel("Intimate Zone:" +arrOfCps[0]);
					 intimate.setBounds(800, -120, 600, 500);
					 frame.getContentPane().add(intimate);
					 //personal
					 JLabel personal = new JLabel("Personal Zone:" +arrOfCps[1]);
					 personal.setBounds(800, -80, 600, 500);
					 frame.getContentPane().add(personal);
					 //social
					 JLabel social = new JLabel("Social Zone:"    +arrOfCps[2]);
					 social.setBounds(800, -40, 600, 500);
					 frame.getContentPane().add(social);
					//social
					 JLabel puclicZone= new JLabel("Public Zone:"  +arrOfCps[3]);
					 puclicZone.setBounds(800, -1, 600, 500);
					frame.getContentPane().add(puclicZone);
					 
					 this.validationdl = new ProxZone(Double.valueOf(arrOfCps[0]),Double.valueOf(arrOfCps[1]),Double.valueOf(arrOfCps[2]),Double.valueOf(arrOfCps[3]));
			    	 this.dil= new Dilmo(validationdl);
			       	
				
					
					JInternalFrame f1[] = new JInternalFrame[e1.size()];
					
					
					int x=0;
					
					JTextField textField[][]  = new JTextField[e1.size()][4];
					JLabel lblNewLabel[][] = new JLabel[e1.size()][4];
					Choice choicel[][]  = new Choice[e1.size()][4];
					
				
					int iden=1;
			     	int ent=1;
			         strArray1 = new String[e1.size()];
					ImageIcon icon = new ImageIcon("img/identity.png", "a pretty but meaningless splat");
					ImageIcon icon2 = new ImageIcon("img/entity.png", "a pretty but meaningless splat");
					for (int i=0;i<e1.size();i++) {
							String id= e1.get(i).getIdentity();
							id= id.trim();
						  	if(id.equals("person")||id.equals("user")||id.equals("customer")||id.equals("entity")) {
					     		f1[i]= new JInternalFrame(id+Integer.toString(ent));
					     		f1[i].getContentPane().setLayout(new BoxLayout(f1[i].getContentPane(), BoxLayout.Y_AXIS));
					     		f1[i].setFrameIcon(icon2);
					     		String tem=id+Integer.toString(ent).trim();
					     		 double d=  e1.get(i).getDistance();
						        // System.out.println(tem);
					     		 dil.setProxemicDI(tem, d);
			         	    	//System.out.println( this.validationdl.getEntities().size());
					     		//System.out.println(tem);
					     		
					     		ent=ent+1;
					       	
					     	}
					     	else {
					     		
					     		f1[i]= new JInternalFrame(id+Integer.toString(iden));
					     		f1[i].getContentPane().setLayout(new BoxLayout(f1[i].getContentPane(), BoxLayout.Y_AXIS));
					     		f1[i].setFrameIcon(icon);
					     		String tem2=id+Integer.toString(iden).trim();
					     	   
					     		double d=  e1.get(i).getDistance();
					     	//	 System.out.println(tem2+ d);
					     		dil.setProxemicDI(tem2,d);
					     		//System.out.println( this.validationdl.getEntities().size());

					     		iden=iden+1;
					       		}
						     	
					         	
					     	
					     	/*
					     	 * aqui
					     	 */
					     	f1[i].setBounds(x, 70, 180, 180);
						   	panel.add(f1[i]);
						
							f1[i].setVisible(true);
							x=230+x;
							//slider[i]= new JSlider();
							for (int j = 0; j < 4; j++) {
								lblNewLabel[i][0]= new JLabel("Distance");
								lblNewLabel[i][1]= new JLabel("Location");
								lblNewLabel[i][2]= new JLabel("Movement");
								lblNewLabel[i][3]= new JLabel("Orientation");
								textField[i][0]= new JTextField();
								textField[i][1]= new JTextField();
								choicel[i][0]= new Choice();
								choicel[i][1]= new Choice();
								//f1[i].getContentPane().add(lblNewLabel[i][0]);
							
								
								
								textField[i][0].addMouseListener(new MouseListener() {
									
									@Override
									public void mouseReleased(MouseEvent e) {
										// TODO Auto-generated method stub
										System.out.println("Paulo");
											
										//txtrHol.append("xxx");
										
									}
									
									@Override
									public void mousePressed(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void mouseExited(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
									
									@Override
									public void mouseClicked(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
								});
								
							}
							
							try {
								
								e1.get(i).getClass().getMethod("getDistance", null);
								f1[i].getContentPane().add(lblNewLabel[i][0]);
								textField[i][0].setText(Double.toString(e1.get(i).getDistance()));
								f1[i].getContentPane().add(textField[i][0]);
								//f1[i].getContentPane().add(lblNewLabel[i][1]);
								//f1[i].getContentPane().add(textField[i][1]);
								} catch (NoSuchMethodException e2) {
								// TODO Auto-generated catch block
								//e2.printStackTrace();
							 }
							try {
								
								e1.get(i).getClass().getMethod("getLocation", null);
								//textField[i][1].setText(Double.toString(e1.get(i).getLocation()));
								textField[i][1].setText(e1.get(i).getLocation());
								f1[i].getContentPane().add(lblNewLabel[i][1]);
								f1[i].getContentPane().add(textField[i][1]);
								} catch (NoSuchMethodException e2) {
								// TODO Auto-generated catch block
								//e2.printStackTrace();
							 }
							try {
								
								e1.get(i).getClass().getMethod("getMovement", null);
								e1.get(i).getMovement();
								f1[i].getContentPane().add(lblNewLabel[i][2]);
								//System.out.println(e1.get(i).getMovement());
								if (e1.get(i).getMovement()==1.0) {
									choicel[i][0].add("static");
									choicel[i][0].add("negative");
									choicel[i][0].insert("positive",0);	
								}
								if (e1.get(i).getMovement()==0.0) {
									choicel[i][0].add("static");
									choicel[i][0].add("negative");
									choicel[i][0].insert("static",0);	
								}
								if (e1.get(i).getMovement()==-1.0) {
									choicel[i][0].add("static");
									choicel[i][0].add("positive");
									choicel[i][0].insert("negative",0);	
								}
								
								//choicel[i][0].add("stop");
								f1[i].getContentPane().add(choicel[i][0]);
								} catch (NoSuchMethodException e2) {
								// TODO Auto-generated catch block
								//e2.printStackTrace();
							 }
							try {
								//System.out.println(e1.get(i).getClass().getMethod("isOrientation", null));
								e1.get(i).getClass().getMethod("isOrientation", null);
								f1[i].getContentPane().add(lblNewLabel[i][3]);
								//choicel[i][1].add("true");
								//choicel[i][1].add("false");
								if(e1.get(i).isOrientation()) {
									
									choicel[i][1].add("true");
									choicel[i][1].add("false");
								}
								else {
									choicel[i][1].add("false");
									choicel[i][1].add("true");
								}
								f1[i].getContentPane().add(choicel[i][1]);
								} 
							    catch (NoSuchMethodException e2) {
								// TODO Auto-generated catch block
								//e2.printStackTrace();
							 }
							 
							
			
					    }
					
					System.out.println(validationdl.getEntities().size());
						for (int j = 0; j <validationdl.getEntities().size(); j++) {
							
							//System.out.println(validationdl.getEntities().get(j).getIdenEntityName()+"-"+dil.getProxemicDI(validationdl.getEntities().get(j).getIdenEntityName()));
							String nameTem= dil.getProxemicDI(validationdl.getEntities().get(j).getIdenEntityName());
							if(nameTem.equals("intimiZone")) {
								//aqui 
								//txtrHol.setText("hola");
							
								if (txtrHol.getText().trim().isEmpty()) {
									
									txtrHol.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
									
								}
								 else {
									
								txtrHol.append(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
								}
								
							}
							if(nameTem.equals("personalZone")) {
								textArea.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
							}
							if(nameTem.equals("socialZone")) {
								textArea_1.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
							}
							if(nameTem.equals("publicZone")) {
								textArea_2.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
							}
							
						}
					  //txtrHol.setText(Arrays.toString(strArray1));
					
						
				
				}
				else System.out.println("error");
			}
		});
		btnCreate.setBounds(800, 391, 97, 25);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblProxemicBehaviorSimulator = new JLabel("Proxemic Behavior Simulator");
		lblProxemicBehaviorSimulator.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProxemicBehaviorSimulator.setBounds(800, 13, 250, 30);
		frame.getContentPane().add(lblProxemicBehaviorSimulator);
		//JTextArea txtrHol = new JTextArea();
		txtrHol.setForeground(Color.GREEN);
		//txtrHol.setText("\r\n");
		txtrHol.setBackground(Color.BLACK);
		txtrHol.setLineWrap(true);
		txtrHol.setBounds(51, 524, 120, 100);
		frame.getContentPane().add(txtrHol);
		
		JLabel lblIntimimateZone = new JLabel("Intimimate Zone");
		lblIntimimateZone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntimimateZone.setBounds(61, 495, 133, 16);
		frame.getContentPane().add(lblIntimimateZone);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(200, 524, 120, 100);
		frame.getContentPane().add(textArea);
		
		JLabel lblPersonalZonz = new JLabel("Personal Zona");
		lblPersonalZonz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPersonalZonz.setBounds(206, 492, 113, 25);
		frame.getContentPane().add(lblPersonalZonz);
		
		textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.GREEN);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_1.setBackground(Color.BLACK);
		textArea_1.setBounds(359, 524, 120, 100);
		frame.getContentPane().add(textArea_1);
		
		 textArea_2 = new JTextArea();
		textArea_2.setForeground(Color.GREEN);
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_2.setBackground(Color.BLACK);
		textArea_2.setBounds(512, 524, 120, 100);
		frame.getContentPane().add(textArea_2);
		
		JLabel lblSocialZona = new JLabel("Social Zone");
		lblSocialZona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSocialZona.setBounds(379, 491, 78, 25);
		frame.getContentPane().add(lblSocialZona);
		
		JLabel lblPublicZone = new JLabel("Public Zone");
		lblPublicZone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPublicZone.setBounds(537, 491, 78, 25);
		frame.getContentPane().add(lblPublicZone);
		
		
		
		
		
	}
}
