package interpret;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterpretScreen extends JFrame implements ActionListener{

	List<Object> objList;

	private static final String DEFINE = "define";
	private static final String ISEXIST = "isExist";
	private static final String EXECUTE = "execute";
	private static final String GENERATE = "generate";
	private static final String UPDATE = "update";

	private static JLabel arraySizeLabel, arrayLabel, typeLabel, constructorLabel, methodLabel, fieldLabel, valueLabel;
	private static JTextField arrayTextField, typeTextField, valueTextField;
	private static JTextArea southTextArea;
	private static JComboBox<String> arrayComboBox, constructorComboBox, methodComboBox, fieldComboBox;

	public InterpretScreen() {
		setTitle("InterpretReflection");
		setSize(600, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // 中央に配置するUIの設定 ////////////////////////////////////////////////////////////
	    GridBagLayout gbl = new GridBagLayout();
	    JPanel centerPanel = new JPanel();
	    centerPanel.setLayout(gbl);
	    GridBagConstraints gbc = new GridBagConstraints();

	    arraySizeLabel = createJLabel("ArraySize", 0, 0, centerPanel, gbl, gbc);
	    arrayTextField = createJTextField("", 1, 0, centerPanel, gbl, gbc);
	    createJButton(DEFINE, 2, 0, centerPanel, gbl, gbc).addActionListener(this);

	    arrayLabel = createJLabel("Array", 0, 1, centerPanel, gbl, gbc);
	    arrayComboBox = createJComboBox(1, 1, centerPanel, gbl, gbc);

	    typeLabel = createJLabel("Type", 0, 2, centerPanel, gbl, gbc);
	    typeTextField = createJTextField("interpret.TestClass", 1, 2, centerPanel, gbl, gbc);
	    createJButton(ISEXIST, 2, 2, centerPanel, gbl, gbc).addActionListener(this);

	    constructorLabel = createJLabel("Constructor", 0, 3, centerPanel, gbl, gbc);
	    constructorComboBox = createJComboBox(1, 3, centerPanel, gbl, gbc);
	    createJButton(GENERATE, 2, 3, centerPanel, gbl, gbc).addActionListener(this);

	    methodLabel =  createJLabel("Method", 0, 4, centerPanel, gbl, gbc);
	    methodComboBox = createJComboBox(1, 4, centerPanel, gbl, gbc);
	    createJButton(EXECUTE, 2, 4, centerPanel, gbl, gbc).addActionListener(this);

	    fieldLabel = createJLabel("Field", 0, 5, centerPanel, gbl, gbc);
	    fieldComboBox = createJComboBox(1, 5, centerPanel, gbl, gbc);

	    valueLabel = createJLabel("Value", 0, 6, centerPanel, gbl, gbc);
	    valueTextField = createJTextField("", 1, 6, centerPanel, gbl, gbc);
	    createJButton(UPDATE, 2, 6, centerPanel, gbl, gbc).addActionListener(this);

	    getContentPane().add(centerPanel, BorderLayout.CENTER);
	    ///////////////////////////////////////////////////////////////////////////////////

	    JPanel southPanel = new JPanel();
	    JLabel southLabel = new JLabel("result");
	    southTextArea = new JTextArea(10, 30);
	    southPanel.add(southLabel);
	    southPanel.add(southTextArea);
	    getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	public static JComboBox<String> createJComboBox(int gx, int gy, JPanel jPanel, GridBagLayout gbl, GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("");
		gbl.setConstraints(comboBox, gbc);
		jPanel.add(comboBox);
		return comboBox;
	}

	public static JLabel createJLabel(String str, int gx, int gy, JPanel jPanel, GridBagLayout gbl, GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JLabel label = new JLabel(str);
		gbl.setConstraints(label, gbc);
	    jPanel.add(label);
	    return label;
	}

	public static JTextField createJTextField(String str, int gx, int gy, JPanel jPanel, GridBagLayout gbl, GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JTextField text = new JTextField(str, 20);
		gbl.setConstraints(text, gbc);
	    jPanel.add(text);
	    return text;
	}

	public static JButton createJButton(String str, int gx, int gy, JPanel jPanel, GridBagLayout gbl, GridBagConstraints gbc) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		JButton button = new JButton(str);
		gbl.setConstraints(button, gbc);
	    jPanel.add(button);
	    return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String className = typeTextField.getText();
		final String methodName = (String) methodComboBox.getSelectedItem();
		final String fieldName = (String) fieldComboBox.getSelectedItem();

		if (e.getActionCommand().equals(DEFINE)) {
			try {
				// https://hacknote.jp/archives/23841/
				objList = new ArrayList<Object>(Arrays.asList(InterpretFrameWork.generateArray(Object.class, Integer.parseInt(arrayTextField.getText()))));
				arrayComboBox.removeAllItems();
				for (int i = 0 ; i < objList.size() ; i++) {
					arrayComboBox.addItem("Obj[" + Integer.toString(i) + "]");
				}
			} catch (NumberFormatException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals(ISEXIST)) {
			// コンストラクタ一覧を取得し、表示
			constructorComboBox.removeAllItems();
			southTextArea.setText(typeTextField.getText() + " is exist.");
			try {
				for (Constructor<?> cons : InterpretFrameWork.getConstractor(className)) {
					constructorComboBox.addItem(cons.getName());
				}
			} catch (ClassNotFoundException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}

			// メソッド一覧を取得し、表示
			methodComboBox.removeAllItems();
			try {
				for (Method method : InterpretFrameWork.getMethods(className)) {
					methodComboBox.addItem(method.getName());
				}
			} catch (ClassNotFoundException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}

			// フィールド一覧を取得し、表示
			fieldComboBox.removeAllItems();
			try {
				for (Field field : InterpretFrameWork.getFields(className)) {
					fieldComboBox.addItem(field.getName());
				}
			} catch (ClassNotFoundException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals(GENERATE)) {
			try {
				objList.add(arrayComboBox.getSelectedIndex(), InterpretFrameWork.generateObject(className));
				southTextArea.setText("Generated.");
			} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException
					| ClassNotFoundException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals(EXECUTE)) {
			try {
				InterpretFrameWork.invokeMethod(className, methodName, objList.get(arrayComboBox.getSelectedIndex()));
				southTextArea.setText(methodName + " is invoked.");
			} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException
					| ClassNotFoundException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}
		}

		if (e.getActionCommand().equals(UPDATE)) {
			try {
				InterpretFrameWork.updateField(className, fieldName, valueTextField.getText(), objList.get(arrayComboBox.getSelectedIndex()));
				southTextArea.setText(fieldName + " is updated.");
			} catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException
					| ClassNotFoundException | NoSuchFieldException e1) {
				southTextArea.setText(e1.toString());
				e1.printStackTrace();
			}
		}
	}

	public static void main(String args[]){
		// https://www.javadrive.jp/tutorial/
	    InterpretScreen frame = new InterpretScreen();
	    frame.setVisible(true);
	  }
}
