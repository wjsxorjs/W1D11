package am;

public class Thread_Ex3 {
	
	
	
	
	

	public static void main(String[] args) {
		Runnable_Ex3 rx = new Runnable_Ex3();
		
		Thread t1 = new Thread(rx, "형님");
		t1.start();
		
		Thread t2 = new Thread(rx, "아우");
		t2.start();
		

	}

}
