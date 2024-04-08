package am;

public class Bullet_Ex4 extends Thread {
	int x, y;
	int w=8, h=20;
	Frame_Ex4 f;
	
	// 현재객체가 총알을 의미하면서, 현재객체를
	// 스페이스바가 눌려질 때마다 생성되어 JFrame의
	// 멤버변수인 ArrayList에 저장되어야 한다. 즉, ArrayList를 접근할 때가 생긴다.
	// 그래서 ArrayList를 가지는 JFrame의 주소가 필요함.
	
	public Bullet_Ex4(int x, int y, Frame_Ex4 f) {
		this.x = x - (w/2);
		this.y = y - h;
		
		this.f = f;
		
	}
	
	@Override
	public void run() {
		// 일정시간동안 쉬면서 y좌표를 감소시킨다.
		while(true) {
			y -= 3;
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
			
			// 좌표값이 변경되었으므로 다시 그려야한다.
			f.p.repaint();
			
			// 현재 무한반복을 탈출하기 위한 비교문
			// (현재 총알객체가 화면 위로 사라진 후)
			
			if(y < -20) {
				break; 	// 무한반복 탈출과 함께 현재객체를 소멸시켜야한다.
						//						(ArrayList에서 삭제)
			}
			
		}
		
		// 현재 총알 객체 ArrayList에서 삭제
		f.b_list.remove(this);
	}

}
