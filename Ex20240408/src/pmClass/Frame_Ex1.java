package pmClass;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame_Ex1 extends JFrame {

	// 크기객체 Dimension
	Dimension d = new Dimension(390, 590);
	
	// 필요한 각 이미지들
	Image back_img, me_img, meteor_img;
	Me me = new Me();
	
	JPanel p = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			// 배경 그리기
			g.drawImage(back_img, 0, 0, this);
			
			// 주인공 그리기
			g.drawImage(me_img, me.pos.x, me.pos.y, this);
		}
		
	};
	
	public Frame_Ex1() {
		// 이미지 객체들 초기화
		back_img = new ImageIcon("src/images/back.jpg").getImage();
		me_img = new ImageIcon("src/images/me.png").getImage();
		meteor_img = new ImageIcon("src/images/meteor.png").getImage();
		
		init_game();//게임초기화
		init_me_pos();//주인공 이미지 초기화
		
		this.setLocation(300, 100);//창의 위치
		this.pack(); // 컴포넌트들의 크기에 맞게 사이즈설정
			// 이 경우 패널을 넣었으니 패널의 사이즈에 맞춘다.
		this.setResizable(false);
		this.setVisible(true);
		
		//종료이벤트
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//키이벤트 감지자 등록
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// 방향키들 중 좌/우측을 받아내어
				// me의 pos의 x값을 증/감소 시킨다.
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						me.pos.x -= 3;
						if(me.pos.x < 0)
							me.pos.x = 0;
						break;
					case KeyEvent.VK_RIGHT:
						me.pos.x += 3;
						if(me.pos.x > d.width-me.pos.width)
							me.pos.x = d.width-me.pos.width;
						break;
				}//switch의 끝
				//좌표가 변경되었으므로 그림을 다시 그린다.
				p.repaint();
			}
		});
	}
	
	private void init_game() {
		// 크기객체(Dimension)을 가지고 JPanel의크기를 예약하자!
		p.setPreferredSize(d);
		
		//크기가 예약된 JPanel을 현재 창 가운데에 추가
		this.add(p);
	}
	
	private void init_me_pos() {
		int imgWidth = me_img.getWidth(this);//주인공 이미지의 너비
		int imgHeight = me_img.getHeight(this);//주인공 이미지의 높이
		
		// me객체 안에 Rectangle의 x,y,width, height지정
		me.pos.x = (d.width - imgWidth)/2;
		me.pos.y = d.height-imgHeight-5;
		me.pos.width = imgWidth;
		me.pos.height = imgHeight;
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame_Ex1();
	}

}
