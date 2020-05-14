package dc.dc2_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class DigitalClock extends JFrame implements ActionListener  {
	private PropertyDialog propDialog;
	private JMenuItem menuProperty;
	private Rectangle2D clockStrSize;
	Property prop;

	public DigitalClock(){
		prop = new Property();
		// DigitalClock
		DCJPanel panel = new DCJPanel(prop);
		add(panel);

		// MenuBar
		JMenuBar menuBar = new JMenuBar();
		JMenu menu       = new JMenu("Menu");
		menuProperty = new JMenuItem("Property");
		menuProperty.addActionListener(this);
		menu.add(menuProperty);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		// Property Dialog
		propDialog = new PropertyDialog(prop);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuProperty) {
			propDialog.setVisible(true);
		}
		repaint();
		clockStrSize = getGraphics().getFontMetrics(prop.getFontSetting()).getStringBounds("00:00:00", getGraphics());
		setSize((int) clockStrSize.getWidth(), (int) clockStrSize.getHeight() + 50);
	}

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		new Timer(1000, dc).start();
		dc.setVisible(true);
		dc.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
