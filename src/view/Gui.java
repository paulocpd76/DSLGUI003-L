package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import Controller.BehaviourEI;
import Controller.DilmoXML;
import Controller.EventIdentity;
import Controller.ValtionDIL;
import Proxemic.Dilmo;
import Proxemic.Distance;
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
import java.awt.Button;
import javax.swing.JRadioButton;

public class Gui<E> {


	private static final Object BorderLayout = null;
	private JFrame frame;
	private String xmlPath;
	private String xdsPath;
	private File   xmlPathObjec;
	private JInternalFrame f1[];
	//private JSlider[] slider;
	JTextArea txtrHol,textArea,textArea_1,textArea_2,textArea_3 ;
	JLabel intimate,personal,social,puclicZone;
	JTextField textField[][];
	Choice choicel[][] ;
	String[] strArray1;
	public String[] arrOfCpsGeneral ;
	JRadioButton rdbtnIntimateZone,radioButton_1,radioButton_2,radioButton_3;
	ButtonGroup group;
	JButton btnNewButton_1;
	public String[] getArrOfCpsGeneral() {
		return arrOfCpsGeneral;
	}

	public void setArrOfCpsGeneral(String[] arrOfCpsGeneral) {
		this.arrOfCpsGeneral = arrOfCpsGeneral;
	}

	public ProxZone validationdl,ProxZone;
	public Dilmo dil;
	ArrayList<Proxemic.Entity> entities;
    private Highlighter.HighlightPainter cyanPainter;
    private Highlighter.HighlightPainter redPainter;
    List<Entity> e1 ;
    
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
				//txtrHol,textArea,textArea_1,textArea_2 ;
				txtrHol.setText("");
				textArea.setText("");
				textArea_1.setText("");
				textArea_2.setText("");
				if (fra==null) System.out.println("new");
				else {
					 intimate.setText("");
					 personal.setText("");
					 social.setText("");
					 puclicZone.setText("");
					 System.out.println("fra"+fra.length);
					for (int i = 0; i < fra.length; i++) {
					fra[i].setVisible(false);	
					}
				} 
				
				
				
			}
		});
		btnNewButton.setBounds(821, 120, 97, 25);
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
		btnXsdFile.setBounds(946, 120, 97, 25);
		frame.getContentPane().add(btnXsdFile);
		
		
		JPanel panel = new JPanel();
		//panel.add(BorderLayout.CENTER, new JScrollPane(panel));

		panel.setBackground(new Color(0, 255, 127));
		panel.setBounds(23, 13, 758, 332);
		frame.getContentPane().add(panel);
		//frame.getContentPane().add(new JScrollPane(panel));
		//frame.add(BorderLayout., new JScrollPane(panel));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
		
			//private Dilmo dil;
		//	private ProxZone validationdl;
			
			public void actionPerformed(ActionEvent e) {
				  DilmoXML dilmo= new DilmoXML();
				  if(dilmo.validateXMLSchema(getXdsPath(),getXmlPath())) {
					//System.out.println(getXmlPathObjec().getName());
					//dilmo.getDilmlXmlFile(getXmlPathObjec().getName(), "dilmo002");
					e1 =dilmo.getLitsOfEntity(getXmlPathObjec().getName(), "dilmo004");
					String CPS= dilmo.getCPSinfo(getXmlPathObjec().getName(),"dilmo004");
					ImageIcon cps = new ImageIcon("img/cps2.png", "a pretty but meaningless splat");
					
					JLabel lblNewLabel_1 = new JLabel();
					lblNewLabel_1.setIcon(cps);
					lblNewLabel_1.setBounds(870, -170, 600, 500);
					frame.getContentPane().add(lblNewLabel_1);
					//Image cps = new Image
					//cps.se;
					 String[] arrOfCps = CPS.split("-");
					 setArrOfCpsGeneral(arrOfCps);
					 //intimate
					 intimate = new JLabel(arrOfCps[0]);
					 intimate.setBounds(890, 204, 150, 16);
					 frame.getContentPane().add(intimate);
					 //personal
					 personal = new JLabel(arrOfCps[1]);
					 personal.setBounds(1045, 204, 150, 16);
					 frame.getContentPane().add(personal);
					 //social
					 social = new JLabel(arrOfCps[2]);
					 social.setBounds(880, 325, 100, 16);
					 frame.getContentPane().add(social);
					//social
					 puclicZone= new JLabel(arrOfCps[3]);
					 puclicZone.setBounds(1028, 325,100, 16);
					 frame.getContentPane().add(puclicZone);
					 //button 
					 btnNewButton_1.setEnabled(true);
					validationdl = new ProxZone(Double.valueOf(arrOfCps[0]),Double.valueOf(arrOfCps[1]),Double.valueOf(arrOfCps[2]),Double.valueOf(arrOfCps[3]));
			    	dil= new Dilmo(validationdl);
			       	JInternalFrame f1[] = new JInternalFrame[e1.size()];
					setF1(f1);
					
					int x=0;
					textField  = new JTextField[e1.size()][4];
					JLabel lblNewLabel[][] = new JLabel[e1.size()][4];
					choicel = new Choice[e1.size()][4];
					JSlider   slider[][] = new JSlider[e1.size()][4];
				
					int iden=1;
			     	int ent=1;
			         strArray1 = new String[e1.size()];
					ImageIcon icon = new ImageIcon("img/identity.png", "a pretty but meaningless splat");
					ImageIcon icon2 = new ImageIcon("img/entity.png", "a pretty but meaningless splat");
					for (int i=0;i<e1.size();i++) {
							String id= e1.get(i).getIdentity();
							id= id.trim();
						  	if(id.equals("person")||id.equals("user")||id.equals("customer")||id.equals("Entity")) {
					     		f1[i]= new JInternalFrame(id+Integer.toString(ent));
					     		f1[i].getContentPane().setLayout(new BoxLayout(f1[i].getContentPane(), BoxLayout.Y_AXIS));
					     		f1[i].setFrameIcon(icon2);
					     		String tem=id+Integer.toString(ent).trim();
					     		 double d=  e1.get(i).getDistance();
						        dil.setProxemicDI(tem, d);
					     		ent=ent+1;
					       	
					     	}
					     	else {
					     		//remove idenumber
					     		//f1[i]= new JInternalFrame(id+Integer.toString(iden));
					     		f1[i]= new JInternalFrame(id);
					     		f1[i].getContentPane().setLayout(new BoxLayout(f1[i].getContentPane(), BoxLayout.Y_AXIS));
					     		f1[i].setFrameIcon(icon);
					     		//String tem2=id+Integer.toString(iden).trim();
					     		String tem2=id.trim();
					     	   	double d=  e1.get(i).getDistance();
					     		dil.setProxemicDI(tem2,d);
					     	   	
					     		iden=iden+1;
					       		}
					     	f1[i].setBounds(x, 70, 40, 180);
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
								textField[i][2]= new JTextField();
								choicel[i][0]= new Choice();
								choicel[i][1]= new Choice();
							    slider[i][0]=  new JSlider();
								textField[i][0].addMouseListener(new MouseListener() {
										@Override
									public void mouseReleased(MouseEvent e) {
										// TODO Auto-generated method stub
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
							final int r=i;
							try {
								
								//Slider Paulo
								slider[i][0].setBounds(10, 10, 10, 20);				
								slider[i][0].setMinimum(0);
								slider[i][0].setMaximum(10);
								slider[i][0].setValue((int)e1.get(i).getDistance());
								f1[i].getContentPane().add(slider[i][0]);	
								slider[i][0].addChangeListener(new javax.swing.event.ChangeListener() {
								Distance dist= new Distance();
								 @Override
									public void stateChanged(ChangeEvent e) {
										JInternalFrame[] fra = (JInternalFrame[]) getF1();
										Double disTem;
										if(slider[r][0].getValue()==0) {
											 disTem= 0.4;
											 textField[r][0].setText(Double.toString(disTem));
										}else {
											 disTem= Double.valueOf(slider[r][0].getValue());
										}
										String dinamic=dist.setDynamicDistance(Double.valueOf(slider[r][0].getValue()));
										if(dinamic.equals("down++")) {
											textField[r][2].setText("positive");
										}
										if(dinamic.equals("up++")) {
											textField[r][2].setText("negative");	
										}
										if(dinamic.equals("stop")) {
											textField[r][2].setText("static");	
																			
										}
										String nameEnSlider= validationdl.getEntities().get(r).getIdenEntityName();
										textField[r][0].setText(Double.toString(disTem));
										double in=Double.valueOf(arrOfCpsGeneral[0]);
										double pe=Double.valueOf(arrOfCpsGeneral[1]);
										double so=Double.valueOf(arrOfCpsGeneral[2]);
										double pu=Double.valueOf(arrOfCpsGeneral[3]);
										ProxZone pz= new ProxZone(in, pe, so, pu);
										Dilmo dilTem= new Dilmo(pz);
										for (int n = 0; n < validationdl.getEntities().size(); n++) {
											 String	nameTem =validationdl.getEntities().get(n).getIdenEntityName();
									    	dilTem.setProxemicDI(nameTem,Double.valueOf(textField[n][0].getText()));
									    	//System.out.println(nameTem+"-"+textField[n][0].getText());
									    	dilTem.getProxemicDI(nameTem);
									    	Double.valueOf(slider[r][0].getValue());
									    } 
										
										txtrHol.setText("");
										textArea.setText("");
										textArea_1.setText("");
										textArea_2.setText("");
										if(textField[r][1].getText().equals("null")) {
											System.out.println("location nulll");
											 
										}
										else {
											// String[] arrOfCps = CPS.split("-");
											String[] loctem= textField[r][1].getText().split(",");
											System.out.println(loctem[0]+"-"+loctem[1]);
											double co=Double.valueOf(loctem[1]);
											double ca=Double.valueOf(loctem[0]);
											//System.out.println(Math.atan(co/ca));
											System.out.println(Math.toDegrees(Math.atan(co/ca)));
											double angle= 45.0;
											double valCo=Math.sin(Math.atan(co/ca));
											double valCa=Math.cos(Math.atan(co/ca));
											System.out.println(valCa+"/"+valCo);
											co=Double.valueOf(textField[r][0].getText())* valCo;
											ca=Double.valueOf(textField[r][0].getText())* valCa;
										    textField[r][1].setText(Double.toString(ca).substring(0, 3)+","+Double.toString(co).substring(0, 3));
										 	}
										   //pz.getEntities().size();
										for (int j = 0; j < pz.getEntities().size(); j++) {
											String nameTem2= dilTem.getProxemicDI(pz.getEntities().get(j).getIdenEntityName());
											if(nameTem2.equals("intimiZone")) {
												if (txtrHol.getText().trim().isEmpty()) {
												txtrHol.setText(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												 else {
													
												txtrHol.append(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												
											}
											if(nameTem2.equals("personalZone")) {
												if (textArea.getText().trim().isEmpty()) {
												textArea.setText(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												 else {
													
												textArea.append(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												
											}
											if(nameTem2.equals("socialZone")) {
												if (textArea_1.getText().trim().isEmpty()) {
												textArea_1.setText(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												 else {
													
												textArea_1.append(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												
											}
											if(nameTem2.equals("publicZone")) {
												if (textArea_2.getText().trim().isEmpty()) {
												textArea_2.setText(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												 else {
													
												textArea_2.append(pz.getEntities().get(j).getIdenEntityName()+"\n");
												}
												
											}
										}
										
										System.out.println(pz.getEntities().size());
										
									}
								});
							   
								e1.get(i).getClass().getMethod("getDistance", null);
								f1[i].getContentPane().add(lblNewLabel[i][0]);
								textField[i][0].setText(Double.toString(e1.get(i).getDistance()));
								f1[i].getContentPane().add(textField[i][0]);
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
									textField[i][2].setText("positive");
									/*
									choicel[i][0].add("static");
									choicel[i][0].add("negative");
									choicel[i][0].insert("positive",0);	
									*/
								}
								if (e1.get(i).getMovement()==0.0) {
									textField[i][2].setText("static");
									/*
									 * choicel[i][0].add("static");
									choicel[i][0].add("negative");
									choicel[i][0].insert("static",0);
									 */
										
								}
								if (e1.get(i).getMovement()==-1.0) {
									textField[i][2].setText("negative");
									/*
									 * choicel[i][0].add("static");
									choicel[i][0].add("positive");
									choicel[i][0].insert("negative",0);	
									 */
									
								}
								
								//choicel[i][0].add("stop");
								//f1[i].getContentPane().add(choicel[i][0]);
								f1[i].getContentPane().add(textField[i][2]);
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
                                 if (textArea.getText().trim().isEmpty()) {
                                	 textArea.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
								}
								 else {
								textArea.append(validationdl.getEntities().get(j).getIdenEntityName()+"\n");}
							}
							if(nameTem.equals("socialZone")) {
								  if (textArea_1.getText().trim().isEmpty()) {
									  textArea_1.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
									}
									 else {
									textArea_1.append(validationdl.getEntities().get(j).getIdenEntityName()+"\n");}
							}
							if(nameTem.equals("publicZone")) {
								 if (textArea_2.getText().trim().isEmpty()) {
									  textArea_2.setText(validationdl.getEntities().get(j).getIdenEntityName()+"\n");
									}
									 else {
									textArea_2.append(validationdl.getEntities().get(j).getIdenEntityName()+"\n");}
							}
							
						}
					 	}
				else System.out.println("error");
			}
		});
		btnCreate.setBounds(892, 160, 97, 25);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblProxemicBehaviorSimulator = new JLabel("Proxemic Behavior Simulator");
		lblProxemicBehaviorSimulator.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProxemicBehaviorSimulator.setBounds(820, 13, 250, 30);
		frame.getContentPane().add(lblProxemicBehaviorSimulator);
		//JTextArea txtrHol = new JTextArea();
		txtrHol.setForeground(Color.GREEN);
		//txtrHol.setText("\r\n");
		txtrHol.setBackground(Color.BLACK);
		txtrHol.setLineWrap(true);
		txtrHol.setBounds(800, 230, 120, 88);
		frame.getContentPane().add(txtrHol);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(950, 230, 120, 88);
		frame.getContentPane().add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.GREEN);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_1.setBackground(Color.BLACK);
		textArea_1.setBounds(800, 350, 120, 88);
		frame.getContentPane().add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setForeground(Color.GREEN);
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_2.setBackground(Color.BLACK);
		textArea_2.setBounds(950, 350, 120, 88);
		frame.getContentPane().add(textArea_2);
		
		btnNewButton_1 = new JButton("Action");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String zone="";
				if(rdbtnIntimateZone.isSelected())zone="intimiZone";
				if(radioButton_1.isSelected())zone="personalZone";
				if(radioButton_2.isSelected())zone="socialZone";
				if(radioButton_3.isSelected())zone="publicZone";
				
				textArea_3.setText("");
				for (int i = 0; i < validationdl.getEntities().size(); i++) {
			    	String eachEnZ=validationdl.getEntities().get(i).getIdenEntityName();
			    	//System.out.println(zone+"-"+eachEnZ);
			    	//System.out.println(textField[i][1].getText());
			    	//textField[i][1].getText();
			    	dil.setProxemicDistance(Double.valueOf(textField[i][0].getText()));
			        // dil.setProxemicDistance(Do);
			     //  System.out.println(dil.getProxemicZoneByDistance());
			    	if(zone.equals(dil.getProxemicZoneByDistance())) {
			    		JInternalFrame[] fraTem = (JInternalFrame[]) getF1();
			    		
			    		//System.out.println(fraTem[i].getName());
			    		String location=textField[i][1].getText();
			    		String movement=textField[i][2].getText();
			    		String ori =choicel[i][1].getSelectedItem();
			    		BehaviourEI be= new BehaviourEI(zone,location, movement, ori);
			    		//System.out.println(be.getLocation()+be.getMovement()+be.isOrientation());
			    		
			    		be.getEvent();
			    		if (textArea_3.getText().trim().isEmpty()) {
			    		textArea_3.setText(fraTem[i].getTitle()+":"+be.getEvent()+"\n");
			    		}
			    		else {
			    			textArea_3.append(fraTem[i].getTitle()+":"+be.getEvent()+"\n");
			    		}
			    		}
			    	
			    	
			    	//System.out.println(dil.getProxemicDI(eachEnZ));;
			    	
				}
			  
			    /*
			     * 	for (int j = 0; j <validationdl.getEntities().size(); j++) {
					dil.setProxemicDistance(e1.get(j).getDistance());
					if(dil.getProxemicZoneByDistance().equals(zone)) {
						// Double DistTem=e1.get(j).getDistance();
						 String LocTem =e1.get(j).getLocation();
						 Double movTem=e1.get(j).getMovement();
						 Boolean orTem= e1.get(j).isOrientation();
						//System.out.println(LocTem);
						EventIdentity event= new EventIdentity(LocTem, movTem, orTem, e1.get(j).getIdentity());
						System.out.println(event.getEvent("PZ"));
						}
					
					
				}
			     */
				 
				  
				 	
				  
			
			
					
			
			}
		});
		btnNewButton_1.setBounds(688, 405, 90, 33);
		frame.getContentPane().add(btnNewButton_1);
		textArea_3 = new JTextArea();
		textArea_3.setForeground(Color.GREEN);
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_3.setBackground(Color.BLACK);
		textArea_3.setBounds(23, 358, 653, 80);
		frame.getContentPane().add(textArea_3);
		
		
		//radio
		rdbtnIntimateZone = new JRadioButton("Intimate zone");
		rdbtnIntimateZone.setBackground(Color.WHITE);
		radioButton_1 = new JRadioButton("Personal zone");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_2 = new JRadioButton("Social zone");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_3 = new JRadioButton("Public zone ");
		radioButton_3.setBackground(Color.WHITE);
		group = new ButtonGroup();
		rdbtnIntimateZone.setSelected(true);
		group.add(rdbtnIntimateZone);
	    group.add(radioButton_1);
	    group.add(radioButton_2);
	    group.add(radioButton_3); 
	     
	    radioButton_1.setBounds(930, 200, 113, 25);
	    radioButton_2.setBounds(782, 320, 97, 25);
		rdbtnIntimateZone.setBounds(782, 200, 107, 25);
		radioButton_3.setBounds(930, 320, 97, 25);
		
		frame.getContentPane().add(rdbtnIntimateZone);
		frame.getContentPane().add(radioButton_1);
		frame.getContentPane().add(radioButton_2);
		frame.getContentPane().add(radioButton_3);
		
	}
}
