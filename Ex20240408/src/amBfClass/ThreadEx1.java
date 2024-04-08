package amBfClass;

public class ThreadEx1 extends Thread {
	
	BallMovingEx1 fe5;
	
	// 현재 스레드가 해야할 일은 Frame_Ex5의 멤버 변수들 중
	// x값을 5씩 증가해야한다. 그래서 Frame_Ex5의 주소를
	// 현재 객체가 생성될 때 받아야한다.
	
	public ThreadEx1(BallMovingEx1 f) {
		fe5 = f;
	}
	
	
	@Override
	public void run() {
		
//		while(fe5.x<fe5.p.getWidth()-50) {
//			fe5.x += 5;
//			fe5.p.repaint();
//			try {
//				Thread.sleep(50);
//			} catch (Exception e) {}
//		} // while문의 끝
//		
//		fe5.x=fe5.p.getWidth()-50;
		while(true) {
			fe5.x += fe5.xInc;
			fe5.y += fe5.yInc;
			
			if(fe5.x >= fe5.p.getWidth()-50) {
				fe5.x = fe5.p.getWidth()-50;
				fe5.xInc *= -1;
				break;
			} else if(fe5.x <= 0) {
				fe5.x = 0;
				fe5.xInc *= -1;
				break;
			}
			if(fe5.y >= fe5.p.getHeight()-50) {
				fe5.y = fe5.p.getHeight()-50;
				fe5.yInc *= -1;
				break;
			} else if(fe5.y <= 0) {
				fe5.y = 0;
				fe5.yInc *= -1;
				break;
			}

			fe5.p.repaint();
			
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}

	
	
	
}
