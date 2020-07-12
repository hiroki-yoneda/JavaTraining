package dc.dc2_4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class DigitalClock extends JFrame implements ActionListener  {
	private final Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	private PropertyDialog propDialog;
	private JMenuItem menuProperty, menuExit;
	private Rectangle2D clockStrSize;
	Property prop;

	public DigitalClock(){
		prop = new Property();
		loadPrefs(prop);

		// DigitalClock
		DCJPanel panel = new DCJPanel(prop);
		add(panel);

		// MenuBar
		JMenuBar menuBar = new JMenuBar();
		JMenu menu       = new JMenu("Menu");
		menuProperty = new JMenuItem("Property");
		menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				savePrefs();
				System.exit(0);
			}
		});
		menuProperty.addActionListener(this);
		menu.add(menuProperty);
		menu.add(menuExit);
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

	public void loadPrefs(Property prop) {
		String font = prefs.get("font", prop.getStringFont());
		int font_size = prefs.getInt("font_size", prop.getFontSize());
		String clock_color = prefs.get("clock_color", prop.getClockStringColor());
		String back_color = prefs.get("back_color", prop.getClockStringBackColor());

		prop.setFont(font);
		prop.setFontSize(font_size);
		prop.setClockColor(clock_color);
		prop.setBackColor(back_color);

		int window_top = prefs.getInt("window_top", 0);
		int window_left = prefs.getInt("window_left", 0);
		setLocation(window_top, window_left);
	}

	public void savePrefs() {
		prefs.put("font", prop.getStringFont());
		prefs.putInt("font_size", prop.getFontSize());
		prefs.put("clock_color", prop.getClockStringColor());
		prefs.put("back_color", prop.getClockStringBackColor());
		prefs.putInt("window_top", (int) getBounds().getX());
		prefs.putInt("window_left", (int) getBounds().getY());
		System.out.println(prop.getClockStringColor());
		System.out.println(prop.getClockStringBackColor());
	}
}
