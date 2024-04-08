package pm;

public class MeteorGen extends Thread {
	
	Frame_Ex1 f;
	
	public MeteorGen(Frame_Ex1 f) {
		this.f = f;
	}
	
	@Override
	public void run() {
		while(true) {
			
//			System.out.println(f.m_list.size());
			
			int meteors = f.m_list.size();
			if(meteors < 10) {
				Meteor m = new Meteor(f);
				f.m_list.add(m);
				m.start();				
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
			
		}
	}
	
	
}
