package dc.dc2_3;

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

	private Property prop;

	public DCJPanel(Property prop) {
		this.prop = prop;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		time = String.format("%1$tH:%1$tM:%1$tS", new Date());
		int size = prop.getFontSize();
		g.setColor(prop.getBackColor());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(prop.getClockColor());
		g.setFont(prop.getFontSetting());
		g.drawString(time, 0, size);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
