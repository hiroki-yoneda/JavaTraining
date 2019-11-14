package dc.dc1_2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyDialog extends Dialog implements ActionListener, ItemListener {

	Panel topPanel = new Panel();
	Panel bottomPanel = new Panel();

	Choice choiceFontType = new Choice();
	Choice choiceFontSize = new Choice();
	Choice choiceFontColor = new Choice();
	Choice choiceBackgroundColor = new Choice();

	String defaultFontColor;
	String defaultBackgroundColor;

	String newFontType = FontType.MS_PGOTHIC.toString();
	FontType[] fontTypes = FontType.values();

	int newFontSize = 10;
	FontSize[] fontSizes = FontSize.values();

	Color newFontColor = Color.black;
	Color newBackgroundColor = Color.white;

	Button OKButton = new Button("OK");

	DigitalClock digitalClock;

	public PropertyDialog(Frame owner) {

		super(owner);

		digitalClock = (DigitalClock) owner;

		// 現在の時計の設定を取得する
		newFontType = digitalClock.getFontType();
		newFontSize = digitalClock.getFontSize();
		newFontColor = digitalClock.getFontColor();
		newBackgroundColor = digitalClock.getBackgroundColor();

		setLayout(new BorderLayout());
		setTitle("Property");
		setSize(300, 180);
		setResizable(false);

		topPanel.setLayout(new GridLayout());

		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);

		topPanel.setLayout(new GridLayout(4, 2));

		// リスナー登録
		choiceFontType.addItemListener(this);
		choiceFontSize.addItemListener(this);
		choiceFontColor.addItemListener(this);
		choiceBackgroundColor.addItemListener(this);
		OKButton.addActionListener(this);

		// フォントタイプ
		topPanel.add(new Label("Font Type: "));
		for(FontType fontType: fontTypes) {
			choiceFontType.add(fontType.toString());
		}
		choiceFontType.select(digitalClock.getFontType());
		topPanel.add(choiceFontType);

		// フォントサイズ
		topPanel.add(new Label("Font Size: "));
		for(FontSize fontSize: fontSizes) {
			choiceFontSize.add(fontSize.toString());
		}
		choiceFontSize.select(digitalClock.getFontSize().toString());
		topPanel.add(choiceFontSize);

		// フォントカラーの初期選択値をStringで取得する
		if (Color.black == digitalClock.getFontColor()) {
			defaultFontColor = "black";
		} else if (Color.red == digitalClock.getFontColor()) {
			defaultFontColor = "red";
		} else if (Color.green == digitalClock.getFontColor()) {
			defaultFontColor = "green";
		} else if (Color.blue == digitalClock.getFontColor()) {
			defaultFontColor = "blue";
		} else {
			defaultFontColor = "black";
		}

		// フォントカラー
		topPanel.add(new Label("Font Color: "));
		choiceFontColor.add("black");
		choiceFontColor.add("red");
		choiceFontColor.add("green");
		choiceFontColor.add("blue");
		choiceFontColor.select(defaultFontColor);
		topPanel.add(choiceFontColor);

		// 背景色の初期選択値をStringで取得する
		if (Color.white == digitalClock.getBackgroundColor()) {
			defaultBackgroundColor = "white";
		} else if (Color.black == digitalClock.getBackgroundColor()) {
			defaultBackgroundColor = "black";
		} else if (Color.orange == digitalClock.getBackgroundColor()) {
			defaultBackgroundColor = "orange";
		} else {
			defaultBackgroundColor = "white";
		}

		// 背景色
		topPanel.add(new Label("Background Color: "));
		choiceBackgroundColor.add("white");
		choiceBackgroundColor.add("black");
		choiceBackgroundColor.add("orange");
		choiceBackgroundColor.select(defaultBackgroundColor);
		topPanel.add(choiceBackgroundColor);

		// OKボタン
		bottomPanel.add(OKButton);

		// ダイアログボックスを閉じるとき
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	private static final long serialVersionUID = 3853419917132576660L;

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("OK" == e.getActionCommand()) {
			digitalClock.setFontType(newFontType);
			digitalClock.setFontSize(newFontSize);
			digitalClock.setFontColor(newFontColor);
			digitalClock.setBackgroundColor(newBackgroundColor);
			setVisible(false);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// フォントタイプが選択された場合
		if (choiceFontType == e.getSource()) {
			newFontType = e.getItem().toString();
		} else if (choiceFontSize == e.getSource()) {
			newFontSize = Integer.parseInt(e.getItem().toString());
		} else if (choiceFontColor == e.getSource()) {
			if ("black" == e.getItem()) {
				newFontColor = Color.black;
			} else if ("red" == e.getItem()) {
				newFontColor = Color.red;
			} else if ("green" == e.getItem()) {
				newFontColor = Color.green;
			} else if ("blue" == e.getItem()) {
				newFontColor = Color.blue;
			} else {
				newFontColor = Color.black;
			}
		} else if (choiceBackgroundColor == e.getSource()) {
			if ("white" == e.getItem()) {
				newBackgroundColor = Color.white;
			} else if ("black" == e.getItem()) {
				newBackgroundColor = Color.black;
			} else if ("orange" == e.getItem()) {
				newBackgroundColor = Color.orange;
			} else {
				newBackgroundColor = Color.white;
			}
		}

	}
}