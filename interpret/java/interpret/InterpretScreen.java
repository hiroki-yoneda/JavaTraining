package interpret;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interpret.subScreen.ConstructorScreen;
import interpret.subScreen.FieldScreen;
import interpret.subScreen.MethodScreen;

public class InterpretScreen extends JFrameUtils implements ActionListener {

	private static List<Constructor<?>> constructorList = new ArrayList<>();
	private static List<Method> methodList = new ArrayList<>();
	private static List<Field> fieldList = new ArrayList<>();

	private static final String DEFINE = "define";
	private static final String ISEXIST = "isExist";
	private static final String EXECUTE = "execute";
	private static final String SET_VALUE = "set_value";
	private static final String UPDATE = "update";

	private static JLabel arraySizeLabel, arrayLabel, typeLabel, constructorLabel, methodLabel, fieldLabel, valueLabel;
	private static JTextField arrayTextField, typeTextField, valueTextField;
	private static JTextArea southTextArea;
	private static JComboBox<String> arrayComboBox, constructorComboBox, methodComboBox, fieldComboBox;

	public InterpretScreen() {
		setTitle("InterpretReflection");
		setSize(800, 400);
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
		createJButton(SET_VALUE, 2, 3, centerPanel, gbl, gbc).addActionListener(this);

		methodLabel = createJLabel("Method", 0, 4, centerPanel, gbl, gbc);
		methodComboBox = createJComboBox(1, 4, centerPanel, gbl, gbc);
		createJButton(EXECUTE, 2, 4, centerPanel, gbl, gbc).addActionListener(this);

		fieldLabel = createJLabel("Field", 0, 5, centerPanel, gbl, gbc);
		fieldComboBox = createJComboBox(1, 5, centerPanel, gbl, gbc);
		createJButton(UPDATE, 2, 5, centerPanel, gbl, gbc).addActionListener(this);

		getContentPane().add(centerPanel, BorderLayout.CENTER);
		///////////////////////////////////////////////////////////////////////////////////

		JPanel southPanel = new JPanel();
		JLabel southLabel = new JLabel("result");
		southTextArea = new JTextArea(30, 50);
		JScrollPane scrollpane =  new JScrollPane(southTextArea);
		southPanel.add(southLabel);
		southPanel.add(scrollpane);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String className = typeTextField.getText();
		final String methodName = (String) methodComboBox.getSelectedItem();
		//final String fieldName = (String) fieldComboBox.getSelectedItem();
		int selectedArrayIndex = arrayComboBox.getSelectedIndex();

		// arraySize に入力された大きさの配列を生成
		if (e.getActionCommand().equals(DEFINE)) {
			try {
				final String arraySize = arrayTextField.getText();
				InstancedObject.setArray(InterpretFrameWork.generateArray(Object.class, Integer.parseInt(arraySize)));
				arrayComboBox.removeAllItems();
				for (int i = 0; i < Integer.parseInt(arraySize); i++) {
					arrayComboBox.addItem("Obj[" + Integer.toString(i) + "]");
				}
			} catch (Exception e1) {
				printError(e1);
			}
		}

		// クラスが存在するかを確認し、あればコンストラクタ、メソッド、フィールドを取得
		if (e.getActionCommand().equals(ISEXIST)) {
			// コンストラクタ一覧を取得し、表示
			constructorComboBox.removeAllItems();
			constructorList.clear();
			southTextArea.setText(typeTextField.getText() + " is exist.");
			try {
				for (Constructor<?> cons : InterpretFrameWork.getConstractor(className)) {
					constructorComboBox.addItem(cons.toString());
					constructorList.add(cons);
				}
			} catch (Exception e1) {
				printError(e1);
			}

			// メソッド一覧を取得し、表示
			methodComboBox.removeAllItems();
			methodList.clear();
			try {
				for (Method method : InterpretFrameWork.getMethods(className)) {
					methodComboBox.addItem(method.toString());
					methodList.add(method);
				}
			} catch (Exception e1) {
				printError(e1);
			}

			// フィールド一覧を取得し、表示
			fieldComboBox.removeAllItems();
			fieldList.clear();
			try {
				for (Field field : InterpretFrameWork.getFields(className)) {
					fieldComboBox.addItem(field.toString());
					fieldList.add(field);
				}
			} catch (Exception e1) {
				printError(e1);
			}
		}

		if (e.getActionCommand().equals(SET_VALUE)) {
			try {
				int selectedConsIndex = constructorComboBox.getSelectedIndex();
				ConstructorScreen consFrame = new ConstructorScreen(
				constructorList.get(selectedConsIndex), selectedArrayIndex);
				consFrame.setVisible(true);
			} catch (Exception e1) {
				printError(e1);
			}
			southTextArea.setText("Generated.");
		}

		if (e.getActionCommand().equals(EXECUTE)) {
			try {
				int selectedMethodIndex = methodComboBox.getSelectedIndex();
				MethodScreen methodFrame = new MethodScreen(methodList.get(selectedMethodIndex), selectedArrayIndex);
				methodFrame.setVisible(true);
				southTextArea.setText(methodName + " is invoked.");
			} catch (Exception e1) {
				printError(e1);
			}
		}

		if (e.getActionCommand().equals(UPDATE)) {
			try {
				int selectedFieldIndex = fieldComboBox.getSelectedIndex();
				FieldScreen fieldScreen = new FieldScreen(fieldList.get(selectedFieldIndex), selectedArrayIndex);
				fieldScreen.setVisible(true);
			} catch (Exception e1) {
				printError(e1);
			}
		}
	}

	public static void printError(Exception e) {
		StringWriter stackTraceWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stackTraceWriter));
		southTextArea.setText(stackTraceWriter.toString());
	}

	public static void main(String args[]) {
		// https://www.javadrive.jp/tutorial/
		InterpretScreen frame = new InterpretScreen();
		frame.setVisible(true);
	}
}
