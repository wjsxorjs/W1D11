package amBfClass;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameAns extends JFrame {
	
	ArrayList<MyOvalAns> list = new ArrayList<MyOvalAns>();
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {

			Image buf = createImage(this.getWidth(), this.getHeight());
			
			Graphics bufG = buf.getGraphics();
			
			for(int i=0;i<list.size();i++) {
				MyOvalAns mo = list.get(i);
				bufG.setColor(mo.c);
				bufG.fillOval(mo.x, mo.y, mo.wh, mo.wh);
			}
			
			g.drawImage(buf, 0, 0, this);
			
		}
		
	};
	
	
	public MyFrameAns() {
		
		this.add(p);
		
		this.setBounds(300, 100, 600, 600);
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
				int x = e.getX();
				int y = e.getY();
				
				
				// 내부클래스에서 바깥쪽클래스를 지칭할 때는
				// 반드시 바깥쪽클래스명.this
				MyOvalAns mo = new MyOvalAns(x, y, MyFrameAns.this);
				
				list.add(mo);
				mo.start();
			}
			
			
		});
	}
	
	
	

	public static void main(String[] args) {

		new MyFrameAns();

	}

}
