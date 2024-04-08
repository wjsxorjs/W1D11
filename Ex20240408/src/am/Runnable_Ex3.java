package am;

public class Runnable_Ex3 implements Runnable {

	int 농심라면 = 10;
	
	int sleepTime = 1000;
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		while(농심라면>0) {
			synchronized (this) {
				// 교착상태(Deadlock)
//				if(false)
					notify(); // 잠든 스레드 깨우기
				
				농심라면--;
				System.out.printf("--[%s] 먼저(농심라면: %d)\n", name, 농심라면);
				
				try {
					wait(); // 대기상태: 누군가가 깨우기 전까지 무조건 대기
					Thread.sleep(sleepTime);
					sleepTime -= 100;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
