package am;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame_Ex2 extends JFrame {
	
	
	JButton bt_red, bt_yellow, bt_green;
	
	// 스레드들이 수행할 일을 가진 객체(Runnable)
	Runnable_Ex2 rx;
	
		
	public Frame_Ex2() {

		this.setTitle("신호등 동기화");
		
		this.setLayout(new GridLayout(1,3));
		
		bt_red = new JButton();
		bt_red.setBackground(Color.RED);
		
		bt_yellow = new JButton();
		bt_yellow.setBackground(Color.YELLOW);
		
		bt_green = new JButton();
		bt_green.setBackground(Color.GREEN);
		
		this.add(bt_red);
		this.add(bt_yellow);
		this.add(bt_green);
		
		this.setBounds(200, 200, 300, 150);
		this.setResizable(false);
		this.setVisible(true);
		
		
		
		rx = new Runnable_Ex2(this);
		
		Thread t_red = new Thread(rx, "R");
		t_red.start(); // rx의 run을 수행하러간다.
		
		Thread t_yellow = new Thread(rx, "Y");
		t_yellow.start();
		
		Thread t_green = new Thread(rx, "G");
		t_green.start();
		
		
		
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	}

	public static void main(String[] args) {
		// 프로그램 시작
		new Frame_Ex2();

	}

}
