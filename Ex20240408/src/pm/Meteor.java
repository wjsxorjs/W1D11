package pm;

import java.awt.Rectangle;

public class Meteor extends Thread {

	Rectangle rect = new Rectangle();
	int speed;
	
	Frame_Ex1 f;
	
	
	public Meteor(Frame_Ex1 f) {
		rect.x = (int)(Math.random()*(f.d.width - f.meteor_img.getWidth(f))+0);
		rect.y = -30;
		rect.width = f.meteor_img.getWidth(f);
		rect.height = f.meteor_img.getHeight(f);
		speed = (int)(Math.random()*20+20);
		
		this.f = f;
		
	}
	
	
	
	@Override
	public void run() {
		while(rect.y < f.d.height-rect.height) {
			rect.y += 5;
			f.p.repaint();
			try {
				Thread.sleep(speed);
			} catch (Exception e) {}
		}
		
		f.m_list.remove(this);
	}
	
}
