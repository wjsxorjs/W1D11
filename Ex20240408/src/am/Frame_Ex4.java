package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Ex4 extends JFrame {

	int x, y; // 상자의 위치
	int w=50, h=30; // 상자의 너비높이
	
	
	//사용자가 Space바를 누를 때마다 총알객체를 생성하여 저장할 곳.
	ArrayList<Bullet_Ex4> b_list = new ArrayList<Bullet_Ex4>();
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			// 현재 p와 동일한 크기의 이미지 객체 생성
			Image buf = createImage(this.getWidth(), this.getHeight());
			Graphics bufG = buf.getGraphics();
			
			bufG.setColor(Color.GREEN);
			bufG.fillRect(x, y, w, h); 	// 상자: 비행선
			bufG.setColor(Color.RED);
			for(int i=0; i<b_list.size();i++) {
				Bullet_Ex4 b = b_list.get(i);
				
				bufG.fillRect(b.x, b.y, b.w, b.h); // 총알 객체들
			}
				
			
			g.drawImage(buf, 0, 0, this);
			
			
		}
		
	};
	
	public Frame_Ex4() {
		
		this.add(p);
		
		
		this.setBounds(300, 100, 600, 500);
		this.setVisible(true);
		
		// 상자를 그릴 위치값 구하기
		
		x = p.getSize().width / 2 - (w/2); 			
		y = p.getSize().height - (h*14/10); 		
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch(code) {
				case KeyEvent.VK_RIGHT:
					x += 5;
//					int x1 = Frame_Ex4.this.x + (w/2);
//					int y1 = Frame_Ex4.this.y;
//					Bullet_Ex4 b1 = new Bullet_Ex4(x1, y1, Frame_Ex4.this);
//					b_list.add(b1);
//					b1.start();
					if(x>p.getWidth()-w)
						x = p.getWidth()-w;
					break;
					
				case KeyEvent.VK_LEFT:
					x -= 5;
//					int x2 = Frame_Ex4.this.x + (w/2);
//					int y2 = Frame_Ex4.this.y;
//					Bullet_Ex4 b2 = new Bullet_Ex4(x2, y2, Frame_Ex4.this);
//					b_list.add(b2);
//					b2.start();
					if(x<0)
						x=0;
					break;

				case KeyEvent.VK_SPACE:
					int x = Frame_Ex4.this.x + (w/2);
					int y = Frame_Ex4.this.y;
					
					Bullet_Ex4 b = new Bullet_Ex4(x, y, Frame_Ex4.this);
					b_list.add(b);
					b.start();
					break;
				}
				p.repaint();
			}
			
		});
		
		
	}
	
	
	public static void main(String[] args) {

		new Frame_Ex4();

	}

}
