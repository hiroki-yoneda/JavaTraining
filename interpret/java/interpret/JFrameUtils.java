package interpret;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameUtils extends JFrame {
	public static JComboBox<String> createJComboBox(int gx, int gy, JPanel jPanel, GridBagLayout gbl,
			GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("");
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

	public static JTextField createJTextField(String str, int gx, int gy, JPanel jPanel, GridBagLayout gbl,
			GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JTextField text = new JTextField(str, 30);
		gbl.setConstraints(text, gbc);
		jPanel.add(text);
		return text;
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

	public static JComboBox<String> createEditableJComboBox(int gx, int gy, JPanel jPanel, GridBagLayout gbl,
			GridBagConstraints gbc, int tabNum){
		gbc.gridx = gx;
		gbc.gridy = gy;
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.addItem("");
		java.util.stream.IntStream.range(0, tabNum - 1).forEach(n -> comboBox.addItem(String.valueOf(n)));
		comboBox.setPreferredSize(new Dimension(240, 20));
		gbl.setConstraints(comboBox, gbc);
		jPanel.add(comboBox);
		return comboBox;
	}
}
