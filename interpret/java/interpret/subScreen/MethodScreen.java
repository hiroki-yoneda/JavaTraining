package interpret.subScreen;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import interpret.InstancedObject;
import interpret.InterpretFrameWork;
import interpret.InterpretScreen;
import interpret.JFrameUtils;
import interpret.ParseTextField;

public class MethodScreen extends JFrameUtils implements ActionListener {

	private static final String INVOKE = "invoke";
	private int argFieldNum = 0;
//	private List<JTextField> textFieldList = new ArrayList<>();
	private List<JComboBox<String>> comboBoxList = new ArrayList<JComboBox<String>>();
	private List<Class<?>> clazzList = new ArrayList<>();
	private Method method;
	private int insArrayIndex;

	public MethodScreen(Method method, int insArrayIndex) {
		this.method = method;
		this.insArrayIndex = insArrayIndex;
		setTitle("SetValue");
		setSize(600, 200);

		GridBagLayout gbl = new GridBagLayout();
		JPanel jPanel = new JPanel();
		jPanel.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		Class<?>[] clazzes = method.getParameterTypes();
		for (Class<?> clazz : clazzes) {
			createJLabel(clazz.getTypeName(), 0, argFieldNum, jPanel, gbl, gbc);
//			textFieldList.add(createJTextField("", 1, argFieldNum, jPanel, gbl, gbc));
			comboBoxList.add(createEditableJComboBox(1, argFieldNum, jPanel, gbl, gbc, InstancedObject.getSize()));
			clazzList.add(clazz);
			argFieldNum++;
		}
		getContentPane().add(jPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton button = new JButton(INVOKE);
		southPanel.add(button);
		button.addActionListener(this);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(INVOKE)) {
			final List<Object> args = new ArrayList<>();
			for (int i = 0; i < argFieldNum; i++) {
//				args.add(ParseTextField.parseText(textFieldList.get(i).getText(), clazzList.get(i)));
				int selectedIndex = comboBoxList.get(i).getSelectedIndex();
				System.out.println(selectedIndex);
				if (selectedIndex < 0) {
					System.out.println(comboBoxList.get(i).getEditor().getItem().toString());
					args.add(ParseTextField.parseText(comboBoxList.get(i).getEditor().getItem().toString(), clazzList.get(i)));
				} else {
					args.add(InstancedObject.get(selectedIndex));
				}
			}
			try {
				InterpretFrameWork.invokeMethod(method, InstancedObject.get(insArrayIndex), args.toArray());
			} catch (Exception e1) {
				InterpretScreen.printError(e1);
			}
			setVisible(false);
		}
	}
}
