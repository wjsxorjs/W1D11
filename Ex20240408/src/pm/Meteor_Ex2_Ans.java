package pm;

import java.awt.Rectangle;

public class Meteor_Ex2_Ans extends Thread {
	// 운석을 의미하는 클래스
	Rectangle rect = new Rectangle();
	int speed;
	
	// 현재 운석객체는 Frame정보를 가지고 있어야 한다. 이유는
	// 그곳에 있는 ArrayList와 JPanel등을 접근해야 한다.
	Frame_Ex2_Ans f;
	
	public Meteor_Ex2_Ans(Frame_Ex2_Ans f, int w, int h) {
		this.f = f;
		
		rect.width = w;
		rect.height = h;
		
		speed = (int)(Math.random()*650+20);
	}
	
	@Override
	public void run() {
		// 무한반복을 통해 y값을 증가시킨다.
		// 이때 화면에 도달할 경우 무한반복을 탈출하자!
		while(true) {
			rect.y += 3;
			if(rect.y >= f.p.getSize().height - rect.height) {
				break;
			}
			try {
				Thread.sleep(speed);
			} catch (Exception e) {}
			
			f.p.repaint();
		}
	}
	
	
	
}
