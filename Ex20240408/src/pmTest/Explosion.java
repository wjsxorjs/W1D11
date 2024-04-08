package pmTest;


import javax.swing.ImageIcon;

public class Explosion extends Thread {
	int x, y;
	Frame f;
	
	public Explosion(int x, int y, Frame f) {
		this.x = x;
		this.y = y;
		
		this.f = f;
	}
	
	@Override
	public void run() {
		
		for(int i =1; i<=27;i++) {
			String filePath = new StringBuffer("src/images/exp_enemy_1/")
																		.append(i)
																		.append(".png")
																		.toString();
			f.explosion_img = new ImageIcon(filePath).getImage();
			f.p.repaint();
			
		}
		
	}
	

}
