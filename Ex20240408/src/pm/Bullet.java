package pm;

import java.awt.Rectangle;

public class Bullet extends Thread {
	
	Rectangle rect;
	
	Frame_Ex1 f;
	
	public Bullet(int x, int y, Frame_Ex1 f) {
		
		rect.x = x;
		rect.y = y;
		
		rect.width = f.
		
		this.f = f;
		
		
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			y -= 3;
			
			f.p.repaint();
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
		
	}

}
