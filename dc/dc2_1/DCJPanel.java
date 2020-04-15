package dc.dc2_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;

public class DCJPanel extends JPanel implements ActionListener {
	private String time;

	Image imgBuf;
	Graphics gBuf;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		time = String.format("%1$tH:%1$tM:%1$tS", new Date());

		imgBuf = createImage(getWidth(), getHeight());
		gBuf = imgBuf.getGraphics();
		gBuf.drawString(time, 80, 50);

        g.drawImage(imgBuf, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
