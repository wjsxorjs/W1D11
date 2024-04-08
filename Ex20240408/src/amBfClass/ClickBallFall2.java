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

public class ClickBallFall2 extends JFrame {
	
	int x, y;
	int r, g, b;
	
	
	JPanel p;
	
	Thread t1;
	
	class MyCircle extends Thread{
		int x, y, wh;
		Color c;
		boolean onScreen = true;
		int sleeptime;
		
		public MyCircle() {
			
			
			wh = (int)(Math.random()*50+50);
			
			this.x = (int)(Math.random()*(p.getWidth()-(wh/2)));
			this.y = -150;

			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);
			
			c = new Color(r, g, b);
			
			sleeptime = (int)(Math.random()*5+5);
			
		}
		
		@Override
		public void run() {
			while(true) {
				this.y += 5;
				if(this.y > p.getHeight()) {
					onScreen = false;					
				}
				p.repaint();
				
				try {
					Thread.sleep(sleeptime);
				} catch (InterruptedException e) {}
			}
		}
		
		
	}
	
	MyCircle mc;
	
	
	ArrayList<MyCircle> mcArr = new ArrayList<MyCircle>();

	
	public ClickBallFall2() {
		
		p = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				
				Image buf = createImage(p.getWidth(), p.getHeight());
				
				Graphics bufG = buf.getGraphics();
				
				for(int i=0;i<mcArr.size();i++) {
					System.out.println(mcArr.size());
					MyCircle mc = mcArr.get(i);
					if(mc.onScreen) {
						bufG.setColor(mc.c);
						bufG.fillOval(mc.x, mc.y, mc.wh, mc.wh);
					} else {
						mcArr.remove(mc);
					}
				}
				
				
				g.drawImage(buf, 0, 0, this);
				
			}
			
			
		};
		
		
		this.add(p);
		
		t1 = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					
					mcArr.add(mc = new MyCircle());
					mc.start();
					try {
						sleep(30);
					} catch (InterruptedException e) {}
				}
			}
			
		};
		
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
		
		t1.start();
		
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
		
		
	}

	public static void main(String[] args) {

		new ClickBallFall2();

	}

}
