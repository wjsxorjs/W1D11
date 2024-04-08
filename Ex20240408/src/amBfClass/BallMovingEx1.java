package amBfClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallMovingEx1 extends JFrame {
	
	int x = 210, xInc = 5;
	
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			// JPanel의 크기와 같은 이미지 객체 생성
			Image buf = createImage(this.getWidth(), this.getHeight());
			
			// 준비된 이미지 객체에만 그림을 그릴 수 있는 붓과 같은 객체
			Graphics buf_g = buf.getGraphics();
			buf_g.setColor(Color.GREEN);
			buf_g.fillOval(x, 245, 50, 50);
			
			g.drawImage(buf, 0, 0, this);
		}
		
	};
	
	ThreadEx1 t1;
	
	public BallMovingEx1() {
		this.add(p);
		
		this.setBounds(300, 100, 500, 500);
		this.setVisible(true);
		this.setTitle("Press Space");
			
		
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
				if(code == KeyEvent.VK_SPACE) {
					t1 = new ThreadEx1(BallMovingEx1.this);		// 스레드 생성
					t1.start();									// 스레드 구동	
					
				}
				
			}
		});
		
		
		
	}
	
	

	public static void main(String[] args) {
		// 
		new BallMovingEx1();

	}

}
