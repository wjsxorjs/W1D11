package pm;

import java.awt.Rectangle;

public class Bullet extends Thread {
	
	Rectangle rect = new Rectangle();
	
	Frame_Ex1 f;
	
	public Bullet(int x, int y, Frame_Ex1 f) {
		
		rect.x = x;
		rect.y = y;
		
		rect.width = f.bullet_img.getWidth(f);
		rect.height = f.bullet_img.getHeight(f);
		
		this.f = f;
		
		
		
	}
	
	@Override
	public void run() {
		
		while(rect.y > 0) {
			
			rect.y -= 3;
			
			f.p.repaint();
			
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
		
		f.b_list.remove(this);
		
	}

}
