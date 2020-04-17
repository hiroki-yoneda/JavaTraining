package interpret.subScreen;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interpret.InstancedObject;
import interpret.InterpretFrameWork;
import interpret.InterpretScreen;
import interpret.JFrameUtils;
import interpret.ParseTextField;

public class FieldScreen extends JFrameUtils implements ActionListener {

	private static final String UPDATE = "update";
	private Field field;
	private int insArrayIndex;
	private JTextField updateTextField;
	Class<?> fieldType;

	public FieldScreen(Field field, int insArrayIndex) {
		this.field = field;
		this.insArrayIndex = insArrayIndex;
		setTitle("UpdateValue");
		setSize(600, 200);

		GridBagLayout gbl = new GridBagLayout();
		JPanel jPanel = new JPanel();
		jPanel.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		fieldType = field.getType();
		createJLabel(fieldType.getTypeName(), 0, 0, jPanel, gbl, gbc);
		String str = "";
		try {
			str = InterpretFrameWork.getFieldValue(field, InstancedObject.get(insArrayIndex)).toString();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		createJTextField(str, 1, 0, jPanel, gbl, gbc);
		createJLabel("Update Value", 0, 1, jPanel, gbl, gbc);
		updateTextField = createJTextField("", 1, 1, jPanel, gbl, gbc);
		getContentPane().add(jPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton button = new JButton(UPDATE);
		southPanel.add(button);
		button.addActionListener(this);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(UPDATE)) {
			Object instancedClass = InstancedObject.get(insArrayIndex);
			try {
				InterpretFrameWork.updateField(field, instancedClass, ParseTextField.parseText(updateTextField.getText(), fieldType));
			} catch (Exception e1) {
				InterpretScreen.printError(e1);
			}
			setVisible(false);
		}
	}

}
