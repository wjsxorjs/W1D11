package amBfClass;

import java.awt.Color;

public class MyOvalAns extends Thread {
	
	MyFrameAns f;
	int x, y, wh, speed;
	Color c;
	
	
	public MyOvalAns(int x, int y, MyFrameAns f) {
		
		this.f = f;
		
		wh = (int)(Math.random()*150+50);
		
		this.x = x-(wh/2);
		this.y = y-(wh/2);
		
		speed = (int)(Math.random()*600+10);
		
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		
		c = new Color(r, g, b);
		
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			y += 2;
			if(y >= f.p.getHeight()-wh) break;
			f.p.repaint();
			try {
				Thread.sleep(speed);
			} catch (Exception e) {}
		}
		
		
		// 스레드 소멸 직전 Frame_Ex2에 있는 list에서
		// 현재 객체 삭제
		f.list.remove(this);
		
	}
	
	
	
}
