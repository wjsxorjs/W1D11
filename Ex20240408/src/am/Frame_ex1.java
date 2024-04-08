package am;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Frame_ex1 extends JFrame {
	
	JProgressBar redBar, greenBar, blueBar;
	
	// 수행상태
	boolean bRed = true, bGreen = true, bBlue = true;
	
	
	public Frame_ex1() {
		
	}
	
	

	public static void main(String[] args) {
		// 프로그램 시작

		new Frame_ex1();

	}

}
