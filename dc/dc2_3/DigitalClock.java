package dc.dc2_3;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JWindow;
import javax.swing.Timer;

public class DigitalClock extends JWindow implements ActionListener  {
	private PropertyPopupMenu propPopupMenu;
	private Rectangle2D clockStrSize;
	Property prop;

	public DigitalClock(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		prop = new Property();
		// DigitalClock
		DCJPanel panel = new DCJPanel(prop);
		add(panel);
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		clockStrSize = getGraphics().getFontMetrics(prop.getFontSetting()).getStringBounds("00:00:00", getGraphics());
		setSize((int) clockStrSize.getWidth(), (int) clockStrSize.getHeight());
	}

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		new Timer(1000, dc).start();
		dc.setVisible(true);
	}

	private MouseAdapter mouseAdapter = new MouseAdapter() {

		private Point start;
		private int currentButton;

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				propPopupMenu = new PropertyPopupMenu(prop);
				propPopupMenu.show(e.getComponent(), e.getX(), e.getY());
				System.out.println("Clicked");
			}
			super.mouseClicked(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			currentButton = e.getButton();
			if (e.getButton() == MouseEvent.BUTTON1) {
				start = e.getPoint();
			}
			super.mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			currentButton = MouseEvent.NOBUTTON;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (currentButton == MouseEvent.BUTTON1) {
				Point current = e.getPoint();
				Point location = getLocation();
				location.translate(current.x - start.x, current.y - start.y);
				setLocation(location);
			}
			super.mouseDragged(e);
		}
	};
}
