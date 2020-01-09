package snake;
import java.awt.Color;
import java.awt.Font;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

import javax.swing.*;
public class Gameplay extends JPanel implements KeyListener,ActionListener{
	
	
	//positions
	private int[] snakexlength= new int[1000];
	private int[] snakeylength= new int[1000];
	private int score =0;
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	private int lengthofsnake=3;
	
	private ImageIcon enemyimage;
	private int[] enemyxpos= {25,50,75,100,125,150,175,200,225,250,275
			,300,325,350,400,450,500,550,575,600,625,650,700,725,750,
			775,800,825};
	private int[] enemyypos= {75,100,125,150,175,200,225,250,275
			,300,325,350,400,450,500,550,575,600,625};
	
	private Random random = new Random(25);
	private int xpos = random.nextInt(25);
	private int ypos = random.nextInt(23);
	//private int xpos = 10;
	//private int ypos = 10;
	private int moves=0;
	private Timer timer;
	private int delay =100;
	
	private ImageIcon snakeimage;
	
	private ImageIcon titleImage;
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
	}
	public void playSound(String soundName)
	 {
	   try 
	   {
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
	    Clip clip = AudioSystem.getClip( );
	    clip.open(audioInputStream);
	    clip.start( );
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }
	public void paint(Graphics g) {
		System.out.println("Inside paint");
		if(moves==0) {
			snakexlength[2]= 50;
			snakexlength[1]=75;
			snakexlength[0]=100;
			
			snakeylength[2]= 100;
			snakeylength[1]=100;
			snakeylength[0]=100;
		}
		//draw title image border
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//draw title image
		titleImage= new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		// draw border for gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		//draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		// draw score
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Scores "+ score, 780, 30);
		
		//draw length of snake
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Length "+ lengthofsnake, 780, 50);
		
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int a=0;a<lengthofsnake;a++) {
			if(a==0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0 && down) {
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			
			// this is not face
			// a identify first index of snake
			// we have to draw body
			if(a!=0) {
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
		}
		
		enemyimage = new ImageIcon("enemy.png");
		if(enemyxpos[xpos]== snakexlength[0] && enemyypos[ypos]==snakeylength[0]) {
			score++;
			playSound("power-up_F_major.wav");
			lengthofsnake++;
			xpos=  random.nextInt(34);
			ypos= random.nextInt(23);
		}
		
		for(int b=1;b<lengthofsnake;b++) {
			if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0]) {
				right=false;left=false;up=false;down=false;
				playSound("game-over-drop.wav");
				g.setColor(Color.white);
				g.setFont(new Font("aerial",Font.BOLD,50));
				g.drawString("Game Over", 300, 300);
				
				g.setFont(new Font("aerial",Font.BOLD,20));
				g.drawString("Space to restart", 350, 340);
			}
		}
		
		try {
		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);}catch(Exception e) {
			System.out.println("Exceptin");
			xpos=10;
			ypos=10;
		}
		System.out.println("Exit paint");
		g.dispose();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key pressed 1 ");
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			moves=0;
			score=0;
			lengthofsnake=3;
			repaint();
		}
		System.out.println("Key pressed 2 ");
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("Moves  "+moves);
			moves++;
			right = true;
			if(!left) {right=true;}else {
				right=false;
				left=true;
			}
			up=false;
			down = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if(!right) {left=true;}else {
				left=false;
				right=true;
			}
			up=false;
			down = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			moves++;
			up = true;
			if(!down) {up=true;}else {
				up=false;
				down=true;
			}
			left=false;
			right = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if(!up) {down=true;}else {
				down=false;
				up=true;
			}
			left=false;
			right = false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		if(right) {
			for(int r=lengthofsnake-1;r>=0;r--) {
				snakeylength[r+1]= snakeylength[r];
			}
			for(int r=lengthofsnake;r>=0;r--) {
				if(r==0) {
					snakexlength[r]=snakexlength[r]+25;
				}else {
					snakexlength[r]=snakexlength[r-1];
				}
				if(snakexlength[r]>850) {
					snakexlength[r]=25;
				}
			}
			repaint();
		}
if(left) {

	for(int r=lengthofsnake-1;r>=0;r--) {
		snakeylength[r+1]= snakeylength[r];
	}
	for(int r=lengthofsnake;r>=0;r--) {
		if(r==0) {
			snakexlength[r]=snakexlength[r]-25;
		}else {
			snakexlength[r]=snakexlength[r-1];
		}
		if(snakexlength[r]<25) {
			snakexlength[r]=850;
		}
	}
	repaint();

		}
if(up) {


	for(int r=lengthofsnake-1;r>=0;r--) {
		snakexlength[r+1]= snakexlength[r];
	}
	for(int r=lengthofsnake;r>=0;r--) {
		if(r==0) {
			snakeylength[r]=snakeylength[r]-25;
		}else {
			snakeylength[r]=snakeylength[r-1];
		}
		if(snakeylength[r]<75) {
			snakeylength[r]=625;
		}
	}
	repaint();

		
}
if(down) {



	for(int r=lengthofsnake-1;r>=0;r--) {
		snakexlength[r+1]= snakexlength[r];
	}
	for(int r=lengthofsnake;r>=0;r--) {
		if(r==0) {
			snakeylength[r]=snakeylength[r]+25;
		}else {
			snakeylength[r]=snakeylength[r-1];
		}
		if(snakeylength[r]>625) {
			snakeylength[r]=75;
		}
	}
	repaint();

		

}
	}
}
