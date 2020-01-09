package calculator;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame implements ActionListener, ItemListener{
TextField text,signText;

boolean flag= false;
StringBuilder a= new StringBuilder("");
StringBuilder b= new StringBuilder("");
Button plus,minus,multi,div,clear,one,two,three,four,five,six,seven,eight,nine,zero,point,equal;
public static int n=5;
public Calculator() {
	GridBagLayout gbag = new GridBagLayout();
	setLayout(gbag);
	setFont(new Font("SansSerif",Font.BOLD,35));
	GridBagConstraints gbc = new GridBagConstraints();
	
	//text.setBackground(Color.white);
	signText = new TextField();
	text= new TextField();
	//text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	text.setEditable(false);
	signText.setEditable(false);
	//text.setSize(Window.WIDTH, 2);
	text.setFont(new Font("SansSerif",Font.BOLD,175));
	signText.setFont(new Font("SansSerif",Font.BOLD,175));
	plus= new Button("+");
	minus= new Button("-");
	multi= new Button("*");
	div= new Button("/");
	clear = new Button("CE");
	seven = new Button("7");
	eight = new Button("8");
	nine = new Button("9");
	four = new Button("4");
	five = new Button("5");
	six = new Button("6");
	one = new Button("1");
	two = new Button("2");
	three = new Button("3");
	zero = new Button("0");
	point = new Button(".");
	equal = new Button("=");
	equal.setBackground(Color.blue);
	equal.setForeground(Color.white);
	one.setBackground(Color.white);
	two.setBackground(Color.white);
	three.setBackground(Color.white);
	four.setBackground(Color.white);
	five.setBackground(Color.white);
	six.setBackground(Color.white);
	seven.setBackground(Color.white);
	eight.setBackground(Color.white);
	nine.setBackground(Color.white);
	zero.setBackground(Color.white);
	

	gbc.fill=GridBagConstraints.BOTH;
	gbc.gridx=0;
	gbc.gridy=0;
	gbc.weighty=0.5;
	gbc.weightx=0.5;
	gbc.gridwidth=GridBagConstraints.REMAINDER;
	gbag.setConstraints(signText, gbc);
	gbc.gridx=1;
	gbag.setConstraints(text, gbc);
	add(text);
	add(signText);
	gbc.weighty=2;
	gbc.weightx=0.5;
	gbc.gridx=0;
	gbc.gridy=1;
	
	gbc.gridwidth=1;
	gbag.setConstraints(clear, gbc);
	gbc.gridx=1;
	gbag.setConstraints(seven, gbc);
	gbc.gridx=2;
	gbag.setConstraints(eight, gbc);
	gbc.gridx=3;
	gbag.setConstraints(nine, gbc);
	gbc.gridx=4;
	gbag.setConstraints(div, gbc);
	
	add(clear);
	
	gbc.gridy=2;
	gbc.gridx=1;
	gbag.setConstraints(four, gbc);
	gbc.gridx=2;
	gbag.setConstraints(five, gbc);
	gbc.gridx=3;
	gbag.setConstraints(six, gbc);
	gbc.gridx=4;
	gbag.setConstraints(multi, gbc);
	gbc.gridy=3;
	gbc.gridx=1;
	gbag.setConstraints(one, gbc);
	gbc.gridx=2;
	gbag.setConstraints(two, gbc);
	gbc.gridx=3;
	gbag.setConstraints(three, gbc);
	gbc.gridx=4;
	gbag.setConstraints(minus, gbc);
	gbc.gridx=1;
	gbc.gridy=4;
	gbag.setConstraints(zero, gbc);
	gbc.gridx=2;
	gbag.setConstraints(point, gbc);
	gbc.gridx=3;
	gbag.setConstraints(equal, gbc);
	gbc.gridx=4;
	gbag.setConstraints(plus, gbc);
	add(seven);
	add(eight);
	add(nine);
	add(plus);
	add(minus);
	add(multi);
	add(div);
	add(zero);
	
	add(four);
	add(five);
	add(six);
	add(one);
	add(two);
	add(three);
	add(point);
	add(equal);
	
	
	//plus,minus,multi,div,clear,one,two,three,four,five,six,seven,eight,nine,zero,point,equal
one.addActionListener(this);
two.addActionListener(this);
three.addActionListener(this);
four.addActionListener(this);
five.addActionListener(this);
six.addActionListener(this);
seven.addActionListener(this);
eight.addActionListener(this);
nine.addActionListener(this);
zero.addActionListener(this);
plus.addActionListener(this);
minus.addActionListener(this);
multi.addActionListener(this);
div.addActionListener(this);
point.addActionListener(this);
equal.addActionListener(this);
clear.addActionListener(this);

	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	});
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator appwin = new Calculator();
		appwin.setTitle("Calculator");
		appwin.setVisible(true);
		appwin.setSize(new Dimension(500,500));
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// TODO Auto-generated method stub
		String str = ae.getActionCommand();
		double p,q;
		if(str.equals("9")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("8")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("7")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("6")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("5")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("4")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("3")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("2")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("1")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("0")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals(".")) {
			if(flag) {
				b.append(str);
				text.setText(b.toString());
			}else {
				
				a.append(str);
				text.setText(a.toString());
			}
		}
		else if(str.equals("=")) {

			if(a.toString().equals("")) {}else {
				flag=false;
				if(signText.getText().equals("+")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
				p=p+q;
				a= new StringBuilder(String.valueOf(p));
				b= new StringBuilder();
				
				}
				else if(signText.getText().equals("-")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p-q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("*")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p*q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("/")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p/q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				text.setText(a.toString());
				a= new StringBuilder();
				b= new StringBuilder();
				signText.setText("");
			}
		
		}
		else if(str.equals("+")) {
			if(a.toString().equals("")) {}else {
				flag=true;
				if(signText.getText().equals("+")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
				p=p+q;
				a= new StringBuilder(String.valueOf(p));
				b= new StringBuilder();
				
				}
				else if(signText.getText().equals("-")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p-q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("*")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p*q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("/")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p/q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				text.setText(a.toString());
				signText.setText(str);
			}
		}
		else if(str.equals("-")) {
			if(a.toString().equals("")) {}else {
				flag=true;
				if(signText.getText().equals("+")) {
				p=Double.parseDouble(a.toString());
				q=Double.parseDouble(b.toString());
				p=p+q;
				a= new StringBuilder(String.valueOf(p));
				b= new StringBuilder();
				
				}
				else if(signText.getText().equals("-")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p-q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("*")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p*q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("/")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p/q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				text.setText(a.toString());
				signText.setText(str);
			}
		}
		else if(str.equals("*")) {
			if(a.toString().equals("")) {}else {
				flag=true;
				if(signText.getText().equals("+")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
				p=p+q;
				a= new StringBuilder(String.valueOf(p));
				b= new StringBuilder();
				
				}
				else if(signText.getText().equals("-")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p-q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("*")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p*q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("/")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p/q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				text.setText(a.toString());
				signText.setText(str);
			}
		}
		else if(str.equals("/")) {
			if(a.toString().equals("")) {}else {
				flag=true;
				if(signText.getText().equals("+")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
				p=p+q;
				a= new StringBuilder(String.valueOf(p));
				b= new StringBuilder();
				
				}
				else if(signText.getText().equals("-")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p-q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("*")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p*q;
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				else if(signText.getText().equals("/")) {
					p=Double.parseDouble(a.toString());
					q=Double.parseDouble(b.toString());
					p=p/q;
				
					a= new StringBuilder(String.valueOf(p));
					b= new StringBuilder();
					
					}
				text.setText(a.toString());
				signText.setText(str);
			}
		}
		else if(str.equals("CE")) {
			signText.setText("");
			text.setText("");
			flag=false;
			a= new StringBuilder();
			b= new StringBuilder();
		}
	
	}

}
