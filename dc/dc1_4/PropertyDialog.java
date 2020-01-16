package dc.dc1_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyDialog extends Dialog implements ActionListener,
		ItemListener {
	private Choice choiceFontType = new Choice();
	private Choice choiceFontSize = new Choice();
	private Choice choiceFontColor = new Choice();
	private Choice choiceBackgroundColor = new Choice();

	private Label labelFontType = new Label("Font Type: ");
	private Label labelFontSize = new Label("Font Size: ");
	private Label labelFontColor = new Label("Font Color: ");
	private Label labelBackgroundColor = new Label("Background Color: ");

	private String defaultFontColor;
	private String defaultBackgroundColor;

	private String fonts[] = GraphicsEnvironment
			.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

	private String newFontType = "American Typewriter";
	private int newFontSize = 10;
	private Color newFontColor = Color.white;
	private Color newBackgroundColor = Color.black;

	private Button OKButton = new Button("OK");
	private Button cancelButton = new Button("Cancel");

	private GridBagConstraints gbc = new GridBagConstraints();

	private GridBagLayout gbl = new GridBagLayout();

	private DigitalClock digitalClock;

	static final public String stringColor[] = { "Black", "White", "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow",
			"Orange" };
	static final public Color colorColor[] = { Color.black, Color.white, Color.red, Color.green, Color.blue, Color.cyan,
			Color.magenta, Color.yellow, Color.orange };

	public PropertyDialog(Frame owner) {

		super(owner);

		digitalClock = (DigitalClock) owner;

		// 現在の時計の設定を取得する
		newFontType = digitalClock.getFontType();
		newFontSize = digitalClock.getFontSize();
		newFontColor = digitalClock.getFontColor();
		newBackgroundColor = digitalClock.getBackgroundColor();

		this.setLayout(gbl);
		this.setTitle("Property");
		this.setSize(300, 180);
		this.setResizable(false);

		// リスナー登録
		choiceFontType.addItemListener(this);
		choiceFontSize.addItemListener(this);
		choiceFontColor.addItemListener(this);
		choiceBackgroundColor.addItemListener(this);
		OKButton.addActionListener(this);
		cancelButton.addActionListener(this);

		// フォントタイプ
		// ラベル
		setGrid(0, 0, 1, 1, "east", labelFontType, null);
		// choice
		for (int i = 0; i < fonts.length; i++) {
			choiceFontType.add(fonts[i]);
		}
		choiceFontType.select(digitalClock.getFontType());
		setGrid(1, 0, 2, 1, "west", null, choiceFontType);

		// フォントサイズ
		// label
		setGrid(0, 1, 1, 1, "east", labelFontSize, null);
		// choice
		for (Integer i = 20; i < 100; i = i + 20) {
			choiceFontSize.add(i.toString());
		}
		setGrid(1, 1, 2, 1, "west", null, choiceFontSize);

		// フォントカラー
		// フォントカラーの初期選択値をStringで取得する
		defaultFontColor = changeColorToString(digitalClock.getFontColor());
		// label
		setGrid(0, 2, 1, 1, "east", labelFontColor, null);
		// choice
		for (String color : stringColor) {
			choiceFontColor.add(color);
		}
		setGrid(1, 2, 2, 1, "west", null, choiceFontColor);

		// 背景色
		// 背景色の初期選択値をStringで取得する
		defaultBackgroundColor = changeColorToString(digitalClock.getBackgroundColor());
		// label
		setGrid(0, 3, 1, 1, "east", labelBackgroundColor, null);
		// choice
		for (String color : stringColor) {
			choiceBackgroundColor.add(color);
		}
		setGrid(1, 3, 2, 1, "west", null, choiceBackgroundColor);

		// OKボタン
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbl.setConstraints(OKButton, gbc);

		// Cancelボタン
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbl.setConstraints(cancelButton, gbc);

		// ダイアログボックスを閉じるとき
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

		this.add(labelFontType);
		this.add(labelFontSize);
		this.add(labelFontColor);
		this.add(labelBackgroundColor);
		this.add(choiceFontType);
		this.add(choiceFontSize);
		this.add(choiceFontColor);
		this.add(choiceBackgroundColor);
		this.add(OKButton);
		this.add(cancelButton);
	}

	private void setGrid(int x, int y, int w, int h, String coordinate, Label label, Choice choice) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		if (coordinate == "east") {
			gbc.anchor = GridBagConstraints.EAST;
		}

		if (coordinate == "west") {
			gbc.anchor = GridBagConstraints.WEST;
		}

		if (label == null) { // choice が存在する
			gbl.setConstraints(choice, gbc);
		}
		if (choice == null) { // label が存在する
			gbl.setConstraints(label, gbc);
		}
	}

	public void resetParameter() {
		// 現在の時計の設定を取得する
		newFontType = digitalClock.getFontType();
		newFontSize = digitalClock.getFontSize();
		newFontColor = digitalClock.getFontColor();
		newBackgroundColor = digitalClock.getBackgroundColor();

		choiceFontType.select(digitalClock.getFontType());
		choiceFontSize.select(digitalClock.getFontSize().toString());
		// フォントカラーの初期選択値をStringで取得する
		defaultFontColor = changeColorToString(digitalClock.getFontColor());
		choiceFontColor.select(defaultFontColor);
		// 背景色の初期選択値をStringで取得する
		defaultBackgroundColor = changeColorToString(digitalClock.getBackgroundColor());
		choiceBackgroundColor.select(defaultBackgroundColor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("OK" == e.getActionCommand()) {
			digitalClock.setFontType(newFontType);
			digitalClock.setFontSize(newFontSize);
			digitalClock.setFontColor(newFontColor);
			digitalClock.setBackgroundColor(newBackgroundColor);
			setVisible(false);
		}

		if ("Cancel" == e.getActionCommand()) {
			setVisible(false);
		}
	}

	static public Color changeStringToColor(String colorString) {
		for (int i = 0; i < stringColor.length; i++) {
			if (colorString.equals(stringColor[i])) {
				return colorColor[i];
			}
		}
		return Color.black;
	}

	static public String changeColorToString(Color targetColor) {
		for (int i = 0; i < colorColor.length; i++) {
			if (targetColor.equals(colorColor[i])) {
				return stringColor[i];
			}
		}
		return stringColor[0];
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// フォントタイプが選択された場合
		if (choiceFontType == e.getSource()) {
			newFontType = e.getItem().toString();
		} else if (choiceFontSize == e.getSource()) {
			newFontSize = Integer.parseInt(e.getItem().toString());
		} else if (choiceFontColor == e.getSource()) {
			newFontColor = changeStringToColor((String) e.getItem());
		} else if (choiceBackgroundColor == e.getSource()) {
			newBackgroundColor = changeStringToColor((String) e.getItem());
		} else {
			System.out.println("Error occurs at select property!");
			System.out.println(e);
		}

	}
}