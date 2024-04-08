package am;

import java.awt.Color;

public class Runnable_Ex2 implements Runnable { // Thread가 아니다.
												// Thread가 해야할 run()을 가지고 있는
												// runnable 인터페이스를 구현한 객체다.

	// 스레드 동기화를 위한 동기화 관리 객체
	Object synObject = new Object();
	
	
	Frame_Ex2 frame;
	
	public Runnable_Ex2(Frame_Ex2 frame) {
		this.frame = frame;
		
		
	}
	
	// 빨간색 불을 켜는 동작
	public synchronized void redOn() {
		frame.bt_red.setBackground(Color.RED);
		frame.bt_yellow.setBackground(Color.GRAY);
		frame.bt_green.setBackground(Color.GRAY);
	}

	public synchronized void yellowOn() {
		frame.bt_red.setBackground(Color.GRAY);
		frame.bt_yellow.setBackground(Color.YELLOW);
		frame.bt_green.setBackground(Color.GRAY);
	}

	public synchronized void greenOn() {
		frame.bt_red.setBackground(Color.GRAY);
		frame.bt_yellow.setBackground(Color.GRAY);
		frame.bt_green.setBackground(Color.GREEN);
	}
	
	
	@Override
	public void run() {
		//점유된 스레드의 이름을 얻어내자
		String name = Thread.currentThread().getName();
		System.out.println(name);
		
		while(true) {
			// 현재 스레드의 이름이 "R"이면 빨강색을 켠다.
			if(name.equals("R")) {
				redOn();
			} else if(name.equals("Y")) {
				yellowOn();
			} else if(name.equals("G")) {
				greenOn();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
