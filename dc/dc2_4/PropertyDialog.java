package dc.dc2_4;

import static dc.dc2_2.ConstantClass.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PropertyDialog extends JFrame implements ActionListener{
	private static JComboBox<String> fontComboBox, fontSizeComboBox, clockColorComboBox, backColorComboBox;
	private static JLabel backColorLabel, clockColorLabel;

	private static final String CANCEL = "cancel";
	private static final String OK = "ok";

	private Property prop;

	public PropertyDialog(Property prop) {
		this.prop = prop;

		setTitle("Property");
		setSize(550, 200);

		GridBagLayout gbl = new GridBagLayout();
		JPanel panel = new JPanel();
		panel.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		// Font
		createJLabel("Font", 0, 0, panel, gbl, gbc);
		fontComboBox = createJComboBox(2, 0, panel, gbl, gbc, FONTS);
		// Font Size
		createJLabel("Font Size", 0, 1, panel, gbl, gbc);
		fontSizeComboBox = createJComboBox(2, 1, panel, gbl, gbc, FONT_SIZE);
		// Clock Color
		createJLabel("Clock Color", 0, 2, panel, gbl, gbc);
		clockColorComboBox = createJComboBox(2, 2, panel, gbl, gbc, STRING_COLOR);
		clockColorComboBox.addActionListener(this);
		clockColorLabel = createJLabel("■", 1, 2, panel, gbl, gbc);
		// Back Color
		createJLabel("Back Color", 0, 3, panel, gbl, gbc);
		backColorComboBox = createJComboBox(2, 3, panel, gbl, gbc, STRING_COLOR);
		backColorComboBox.addActionListener(this);
		backColorLabel = createJLabel("■", 1, 3, panel, gbl, gbc);
		// cancel button
		createJButton(CANCEL, 3, 4, panel, gbl, gbc).addActionListener(this);
		// ok button
		createJButton(OK, 4, 4, panel, gbl, gbc).addActionListener(this);

		getContentPane().add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals(OK)) {
			prop.setFont((String) fontComboBox.getSelectedItem());
			prop.setFontSize(Integer.valueOf((String) fontSizeComboBox.getSelectedItem()));
			prop.setClockColor((String) clockColorComboBox.getSelectedItem());
			prop.setBackColor((String) backColorComboBox.getSelectedItem());
			this.setVisible(false);
		}
		if (e.getActionCommand().equals("comboBoxChanged")) {
			// https://gist.github.com/yusuke/797866
			System.out.println(e.getSource());
			clockColorLabel.setForeground(COLER_COLER[clockColorComboBox.getSelectedIndex()]);
			clockColorLabel.setText("■");
			backColorLabel.setForeground(COLER_COLER[backColorComboBox.getSelectedIndex()]);
			backColorLabel.setText("■");
		}
		if (e.getActionCommand().equals(CANCEL)) {
			this.setVisible(false);
		}
	}

	public static <T> JComboBox<String> createJComboBox(int gx, int gy, JPanel jPanel, GridBagLayout gbl,
			GridBagConstraints gbc, T[] items) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JComboBox<String> comboBox = new JComboBox<String>();
		Arrays.stream(items).forEach(item -> comboBox.addItem(item.toString()));
		gbl.setConstraints(comboBox, gbc);
		jPanel.add(comboBox);
		return comboBox;
	}

	public static JLabel createJLabel(String str, int gx, int gy, JPanel jPanel, GridBagLayout gbl,
			GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JLabel label = new JLabel(str);
		gbl.setConstraints(label, gbc);
		jPanel.add(label);
		return label;
	}

	public static JButton createJButton(String str, int gx, int gy, JPanel jPanel, GridBagLayout gbl,
			GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JButton button = new JButton(str);
		gbl.setConstraints(button, gbc);
		jPanel.add(button);
		return button;
	}
}
