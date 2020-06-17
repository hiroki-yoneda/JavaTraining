package dc.dc2_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PropertyPopupMenu extends JPopupMenu{
	private JMenuItem propertyMenu;
	private JMenuItem exitMenu;

	private JMenu font;
	private JMenu fontSize;
	private JMenu clockColor;
	private JMenu backColor;

	// ConstantClass add after implement
	private static final String MENU = "Menu";
	private static final String EXIT = "Exit";
	private static final String FONT = "Font";
	private static final String FONT_SIZE = "Font Size";
	private static final String CLOCK_COLOR = "Clock Color";
	private static final String BACK_COLOR = "Back Color";

	public PropertyPopupMenu(Property prop) {
		propertyMenu = new JMenu(MENU);
		exitMenu = new JMenuItem(EXIT);
		exitMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		font = new JMenu(FONT);
		Arrays.stream(ConstantClass.FONTS).forEach(i -> {
			JMenuItem item = new JMenuItem(i.toString());
			font.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					prop.setFont(e.getActionCommand());
				}
			});
		});

		fontSize = new JMenu(FONT_SIZE);
		Arrays.stream(ConstantClass.FONT_SIZE).forEach(i -> {
			JMenuItem item = new JMenuItem(i.toString());
			fontSize.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					prop.setFontSize(Integer.valueOf(e.getActionCommand()));
				}
			});
		});

		clockColor = new JMenu(CLOCK_COLOR);
		Arrays.stream(ConstantClass.STRING_COLOR).forEach(i -> {
			JMenuItem item = new JMenuItem(i.toString());
			clockColor.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					prop.setClockColor(e.getActionCommand());
				}
			});
		});

		backColor = new JMenu(BACK_COLOR);
		Arrays.stream(ConstantClass.STRING_COLOR).forEach(i -> {
			JMenuItem item = new JMenuItem(i.toString());
			backColor.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					prop.setBackColor(e.getActionCommand());
				}
			});
		});

		propertyMenu.add(font);
		propertyMenu.add(fontSize);
		propertyMenu.add(clockColor);
		propertyMenu.add(backColor);

		add(propertyMenu);
		add(exitMenu);
	}
}
