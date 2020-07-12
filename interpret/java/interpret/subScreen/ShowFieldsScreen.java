package interpret.subScreen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import interpret.InstancedObject;
import interpret.InterpretFrameWork;
import interpret.JFrameUtils;

public class ShowFieldsScreen extends JFrameUtils implements ActionListener{

	private static final String OK = "OK";

	private List<List<String>> fieldsDataTable = new ArrayList<>();
	private String[] columnNames = {"FieldType", "FieldName", "FieldValue"};

	public ShowFieldsScreen(String className, int insArrayIndex) {
		setTitle("show fields");
		setSize(600, 200);

		try {
			for (Field field : InterpretFrameWork.getFields(className)) {
				String fieldType = field.getType().getTypeName();
				String fieldName = field.getName();
				String fieldValue;
				try {
					fieldValue = InterpretFrameWork.getFieldValue(field, InstancedObject.get(insArrayIndex)).toString();
				} catch (Exception e) {
					fieldValue = "";
				}
				fieldsDataTable.add(Arrays.asList(fieldType, fieldName, fieldValue));
			}
		} catch (ClassNotFoundException | IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		String[][] array = fieldsDataTable.stream().map(r -> r.stream().toArray(String[]::new)).toArray(String[][]::new);
		JTable table = new JTable(array, columnNames);
		JScrollPane sp = new JScrollPane(table);
		sp.setSize(500, 150);

	    JPanel p = new JPanel();
	    p.add(sp);

	    getContentPane().add(p, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton button = new JButton(OK);
		southPanel.add(button);
		button.addActionListener(this);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(OK)) {
			setVisible(false);
		}
	}

}
