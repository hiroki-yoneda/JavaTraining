package interpret.subScreen;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interpret.InstancedObject;
import interpret.InterpretFrameWork;
import interpret.InterpretScreen;
import interpret.JFrameUtils;
import interpret.ParseTextField;

public class ConstructorScreen extends JFrameUtils implements ActionListener {

	private static final String GENERATE = "generate";
	private int argFieldNum = 0;
	private List<JTextField> textFieldList = new ArrayList<>();
	private Constructor<?> cons;
	private List<Class<?>> clazzList = new ArrayList<>();
	private int index;

	public ConstructorScreen(Constructor<?> cons, int index) {
		this.cons = cons;
		this.index = index;
		setTitle("SetValue");
		setSize(600, 200);

	    GridBagLayout gbl = new GridBagLayout();
	    JPanel jPanel = new JPanel();
	    jPanel.setLayout(gbl);
	    GridBagConstraints gbc = new GridBagConstraints();

	    Class<?>[] clazzes = InterpretFrameWork.getConstructorParams(cons);
	    for(Class<?> clazz : clazzes) {
	    	createJLabel(clazz.getTypeName(), 0, argFieldNum, jPanel, gbl, gbc);
	    	textFieldList.add(createJTextField("", 1, argFieldNum, jPanel, gbl, gbc));
	    	clazzList.add(clazz);
	    	argFieldNum++;
	    }
	    getContentPane().add(jPanel, BorderLayout.CENTER);

	    JPanel southPanel = new JPanel();
	    JButton button = new JButton(GENERATE);
	    southPanel.add(button);
	    button.addActionListener(this);
	    getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(GENERATE)) {
			final List<Object> args = new ArrayList<>();
			for (int i = 0; i < argFieldNum; i++) {
				args.add(ParseTextField.parseText(textFieldList.get(i).getText(), clazzList.get(i)));
			}
			try {
				final Object instancedObj = InterpretFrameWork.generateObject(cons, args.toArray());
				InstancedObject.add(index, instancedObj);
			} catch (Exception e1) {
			    InterpretScreen.printError(e1);
			}
			setVisible(false);
		}
	}
}
