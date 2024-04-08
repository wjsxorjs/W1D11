package amBfClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickBallFall1 extends JFrame {
	
	int x, y;
	int r, g, b;
	
	JPanel p;
	
	class MyCircle extends Thread{
		int x, y, wh;
		Color c;
		boolean falling = true;
		int sleeptime;
		
		public MyCircle(int x, int y) {

			wh = (int)(Math.random()*50+50);
			
			this.x = x-(wh/2);
			this.y = y-(wh/2);
			

			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);
			
			c = new Color(r, g, b);
			
			sleeptime = (int)(Math.random()*50+10);
			
		}
		
		@Override
		public void run() {
			while(true) {
				if(falling) {
					this.y += 5;
					if(this.y>p.getHeight()-this.wh) {
						this.y = p.getHeight()-this.wh;
						falling = false;
					}
				} else {
					break;
				}
				p.repaint();
				try {
					Thread.sleep(sleeptime);
				} catch (InterruptedException e) {}
			}
			ClickBallFall1.this.mcArr.remove(this);
		}
		
		
		
	}
	
	MyCircle mc;
	
	
	ArrayList<MyCircle> mcArr = new ArrayList<MyCircle>();

	
	public ClickBallFall1() {
		
		p = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				
				Image buf = createImage(p.getWidth(), p.getHeight());
				
				Graphics bufG = buf.getGraphics();
				
				for(int i=0;i<mcArr.size();i++) {
					MyCircle mc = mcArr.get(i);
					bufG.setColor(mc.c);
					bufG.fillOval(mc.x, mc.y, mc.wh, mc.wh);
				}
				
				
				g.drawImage(buf, 0, 0, this);
				
			}
			
			
		};
		
		
		this.add(p);
		
		
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		
		
		
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
		
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
				mcArr.add(mc = new MyCircle(x,y));
				mc.start();
			}
			
		});
		
	}

	public static void main(String[] args) {

		new ClickBallFall1();

	}

}
