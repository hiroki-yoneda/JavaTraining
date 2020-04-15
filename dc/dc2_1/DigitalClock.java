package dc.dc2_1;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DigitalClock extends JFrame {

	public DigitalClock(){
		setSize(200, 100);
		DCJPanel panel = new DCJPanel();
		add(panel);
		new Timer(1000, panel).start();
	}

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		dc.setVisible(true);
		dc.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
