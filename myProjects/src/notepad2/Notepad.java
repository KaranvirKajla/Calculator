package notepad2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.InputEvent;

public class Notepad {
	String filename;
	private JLabel l;
	private String paste = "";
	private JFrame frame;
	private ButtonGroup bgStyle= new ButtonGroup();
	private ButtonGroup bgJustify= new ButtonGroup();
	private JButton yes=new JButton("Yes"),no= new JButton("No");
	private JDialog exit;
	//Clipboard clipboard= frame.getToolkit().getSystemClipboard();
File selectedFile;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad window = new Notepad();
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
	public Notepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 879, 456);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JScrollPane jsp = new JScrollPane(textArea);
		frame.getContentPane().add(jsp);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				 exit = new JDialog();
				 exit.getContentPane().setLayout(new FlowLayout());
				exit.setTitle("Exiting");
				JLabel txt = new JLabel("Do you really want to exit ?");
				exit.getContentPane().add(txt);
				exit.getContentPane().add(yes);
				exit.getContentPane().add(no);
				exit.setVisible(true);
				exit.setBounds(500, 300, 200, 115);;
			}
		});
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exit.dispose();
			}
			
		});
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		int[] sizeArray= {8,9,10,11,12,14,16,18,20,22,24,25,26,28,36,48,72};
		JComboBox size = new JComboBox();
		size.setFont(new Font("Tahoma", Font.PLAIN, 20));
		size.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(size.getSelectedItem()=="Custom") {
					JDialog sizeDialog = new JDialog();
					JTextField text = new JTextField(5);
					
					JButton ok = new JButton("OK");
					JButton close = new JButton("Close");
					sizeDialog.setVisible(true);
					sizeDialog.setSize(400,400);
					sizeDialog.getContentPane().add(text);
					sizeDialog.getContentPane().add(ok);
					sizeDialog.getContentPane().add(close);
					sizeDialog.getContentPane().setLayout(new FlowLayout());
					close.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							sizeDialog.dispose();
						}
						
					});
					ok.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String str = text.getText();int i;
							for( i=0;i<str.length();i++) {
								if(str.charAt(i)>='0' && str.charAt(i)<='9') {
									System.out.println("\nif");
								}else {System.out.println("\nelse");
									break;
								}
							}
							if(i==str.length()) {
								Font old = textArea.getFont();
								int num = Integer.parseInt(text.getText());
								System.out.println("\nnum " + num);
								textArea.setFont(new Font(old.getName(),old.getStyle(),num));
							}
							else {text.setText("Put only integer values ");}
						}
					});
				}else
				{int s =  (int) size.getSelectedItem();
				Font old = textArea.getFont();
				//textArea.setFont(old.deriveFont(s));
				//size.setSelectedItem(18);
				textArea.setFont(new Font(old.getName(), old.getStyle(), s));}
			}
		});
		
		JComboBox font = new JComboBox();
		font.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GraphicsEnvironment ge ;
		ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontList[]=ge.getAvailableFontFamilyNames();
		for(int i=0;i<fontList.length;i++) {
		//	System.out.println(fontList[i]);
			font.addItem(fontList[i]);
		}
		//font.setSelectedItem(14);
		//font.setSelectedIndex(5);
		//font.addItem("");
		//textArea.setFont(new Font("Tahoma", Font.PLAIN, 100));
		font.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font old= textArea.getFont();
				String s= (String) font.getSelectedItem();
				textArea.setFont(new Font(s,old.getStyle(),old.getSize()));
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(font);
		size.addItem(8);
		size.addItem(9);
		size.addItem(10);
		size.addItem(11);
		size.addItem(12);
		size.addItem(14);
		size.addItem(16);
		size.addItem(18);
		size.addItem(20);
		size.addItem(22);
		size.addItem(24);
		size.addItem(25);
		size.addItem(26);
		size.addItem(28);
		size.addItem(36);
		size.addItem(48);
		size.addItem(72);
		size.addItem("Custom");
		
		panel.add(size);
		
		JComboBox color = new JComboBox();
		color.setFont(new Font("Tahoma", Font.PLAIN, 20));
		color.addItem("black");
		
		color.addItem("orange");
		color.addItem("red");
		color.addItem("blue");
		color.addItem("cyan");
		color.addItem("darkGray");
		color.addItem("green");
		color.addItem("magenta");
		color.addItem("pink");
		color.addItem("white");
		color.addItem("yellow");
		
		
		color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s= color.getSelectedIndex();
				//textArea.setForeground(s);
				switch(s) {
				case 0:
					textArea.setForeground(Color.black);
					break;
				case 1:
					textArea.setForeground(Color.orange);
					break;
				case 2:
					textArea.setForeground(Color.red);
					break;
				case 3:
					textArea.setForeground(Color.blue);
					break;
				case 4:
					textArea.setForeground(Color.cyan);
					break;
				case 5:
					textArea.setForeground(Color.darkGray);
					break;
				case 6:
					textArea.setForeground(Color.green);
					break;
				case 7:
					textArea.setForeground(Color.magenta);
					break;
					
				case 8:
					textArea.setForeground(Color.pink);
					break;
				case 9:
					textArea.setForeground(Color.white);
					break;
					
				case 10:
					textArea.setForeground(Color.yellow);
					break;
							
				}
			}
		});
		panel.add(color);
		
		JComboBox background = new JComboBox();
		background.setFont(new Font("Tahoma", Font.PLAIN, 20));
background.addItem("black");
		
		background.addItem("orange");
		background.addItem("red");
		background.addItem("blue");
		background.addItem("cyan");
		background.addItem("darkGray");
		background.addItem("green");
		background.addItem("magenta");
		background.addItem("pink");
		background.addItem("white");
		background.addItem("yellow");
		background.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int s= background.getSelectedIndex();
				//textArea.setForeground(s);
				switch(s) {
				case 0:
					textArea.setBackground(Color.black);
					break;
				case 1:
					textArea.setBackground(Color.orange);
					break;
				case 2:
					textArea.setBackground(Color.red);
					break;
				case 3:
					textArea.setBackground(Color.blue);
					break;
				case 4:
					textArea.setBackground(Color.cyan);
					break;
				case 5:
					textArea.setBackground(Color.darkGray);
					break;
				case 6:
					textArea.setBackground(Color.green);
					break;
				case 7:
					textArea.setBackground(Color.magenta);
					break;
					
				case 8:
					textArea.setBackground(Color.pink);
					break;
				case 9:
					textArea.setBackground(Color.white);
					break;
					
				case 10:
					textArea.setBackground(Color.yellow);
					break;
							
				}
			
			}
		});
		panel.add(background);
		
		JCheckBox chckbxUnderline = new JCheckBox("Underline");
		chckbxUnderline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
				fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				Font old= textArea.getFont();
				//Font boldUnderline = 
						textArea.setFont(new Font(old.getName(),old.getStyle(), old.getSize()).deriveFont(fontAttributes));

			}
		});
		panel.add(chckbxUnderline);
		
		JRadioButton rdbtnPlain = new JRadioButton("Plain");
		rdbtnPlain.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPlain.setSelected(true);
		rdbtnPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Font old= textArea.getFont();
				if(rdbtnPlain.isSelected()==true) {
				textArea.setFont(new Font(old.getName(),Font.PLAIN,old.getSize()));}
			}
		});
		panel.add(rdbtnPlain);
		
		JRadioButton rdbtnBold = new JRadioButton("Bold");
		rdbtnBold.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font old= textArea.getFont();
				if(rdbtnBold.isSelected()==true) {
				textArea.setFont(new Font(old.getName(),Font.BOLD,old.getSize()));}
			}
		});
		panel.add(rdbtnBold);
		
		JRadioButton rdbtnItalic = new JRadioButton("Italic");
		rdbtnItalic.setFont(new Font("Tahoma", Font.ITALIC, 20));
		rdbtnItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font old= textArea.getFont();
				if(rdbtnItalic.isSelected()==true) {
				textArea.setFont(new Font(old.getName(),Font.ITALIC,old.getSize()));}
			}
		});
		panel.add(rdbtnItalic);
		
		JRadioButton rdbtnBoldItalic = new JRadioButton("Bold Italic");
		rdbtnBoldItalic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtnBoldItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font old= textArea.getFont();
				if(rdbtnBoldItalic.isSelected()==true) {
				textArea.setFont(new Font(old.getName(),Font.ITALIC | Font.BOLD,old.getSize()));}
			}
		});
		panel.add(rdbtnBoldItalic);
		bgStyle.add(rdbtnPlain);
		bgStyle.add(rdbtnBold);
		bgStyle.add(rdbtnItalic);
		bgStyle.add(rdbtnBoldItalic);
		
		JRadioButton rdbtnRightJustified = new JRadioButton("Right  Justified");
		rdbtnRightJustified.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			}
		});
		
		JRadioButton rdbtnLeftJustify = new JRadioButton("Left Justify");
		rdbtnLeftJustify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			}
		});
		bgJustify.add(rdbtnLeftJustify);
		bgJustify.add(rdbtnRightJustified);
		panel.add(rdbtnLeftJustify);
		panel.add(rdbtnRightJustified);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		/*class myHighlighter extends DefaultHighlighter.DefaultHighlightPainter{

			public myHighlighter(Color arg0) {
				super(arg0);
				// TODO Auto-generated constructor stub
			}
			
		}
		
		/*DefaultHighlighter.DefaultHighlightPainter highlighter = new myHighlighter(Color.yellow);
		
		public void searchTextArea(JTextComponent textComp, String textString) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
				HighLighter hilight = textComp.getHighlighter();
				Document doc = textComp.getDocument();
				String text = doc.getText(0, doc.getLength());
				
				int pos =0;
				while(pos=text.toUpperCase().indexOf(textString.toUpperCase())>0) {
					
				};
			}
		}*/
		
		panel.add(btnSearch);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 97));
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNew.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				frame.setTitle("New File");
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JFileChooser j = new JFileChooser(); 
				j.showOpenDialog(null);*/ 
				 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				  
		            // invoke the showsOpenDialog function to show the save dialog 
		            int r = j.showOpenDialog(null); 
		  
		            if (r == JFileChooser.APPROVE_OPTION) {
					     selectedFile = j.getSelectedFile();
					    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					}
		            try {
		            	BufferedReader reader = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
		            	StringBuilder sb = new StringBuilder();
		            	String line = "";
		            	while((line=reader.readLine())!=null) {
		            		sb.append(sb.toString());
		            	}
		            	textArea.setText(sb.toString());
		            	reader.close();
		            }catch(Exception e1) {
		            	System.out.println("Exception occurred");
		            }
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				  
		            // invoke the showsOpenDialog function to show the save dialog 
		            int r = j.showSaveDialog(null); 
		  
		            if (r == JFileChooser.APPROVE_OPTION) {
					     selectedFile = j.getSelectedFile();
					  //  filename = j.getSelectedFile();
					    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					}
		            try {
		            	FileWriter fileWriter = new FileWriter( selectedFile.getAbsolutePath());
		            	fileWriter.write(textArea.getText());
		            	frame.setTitle(filename);
		            	fileWriter.close();
		            }catch(Exception e) {
		            	System.out.println("File not found");
		            }
			}
		});
		mnFile.add(mntmSave);
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setIcon(new ImageIcon("C:\\Users\\Karanvir Kajla\\Desktop\\java\\practice\\myApplet\\icons8-cut-100.png"));
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_CUT, 0));
		mntmCut.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*String cutString = textArea.getSelectedText();
				StringSelection cutSelection = new StringSelection(cutString);
				clipboard.setContents(cutSelection, cutSelection);
				textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());*/
				String cutString = textArea.getSelectedText();
				int index = textArea.getSelectionStart();
				System.out.println(cutString + index);
				filename= textArea.getText();
				paste=textArea.getSelectedText();
				filename.replace(cutString,"");
				textArea.setText(textArea.getText().replace(textArea.getSelectedText(),""));
			}
		});
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setIcon(new ImageIcon("C:\\Users\\Karanvir Kajla\\Desktop\\java\\practice\\myApplet\\icons8-copy-200.png"));
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cutString = textArea.getSelectedText();
				int index = textArea.getSelectionStart();
				System.out.println(cutString + index);
				filename= textArea.getText();
				paste=textArea.getSelectedText();
				
			}
		});
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setIcon(new ImageIcon("C:\\Users\\Karanvir Kajla\\Desktop\\java\\practice\\myApplet\\icons8-paste-64.png"));
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("pate  " + paste);
				int index = textArea.getSelectionStart();
				System.out.println("index  " + index);
				String original = textArea.getText();
				String str = "";
				for(int i=0;i<original.length();i++) {
					str=str+ original.charAt(i);
					if(i==index-1) {str=str+paste;}
					
				}
				textArea.setText(str);
			}
		});
		mnEdit.add(mntmPaste);
		
		
	}

}
