package dc.dc1_3;

import static dc.dc1_3.ConstantClass.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends Window implements Runnable, ActionListener {

	private Date currentDate;
	private SimpleDateFormat simpleDataFormat = new SimpleDateFormat("HH:mm:ss");

	private String stringCurrentTime = "--:--:--";

	private Thread th;
	private Image imageBuffer;
	private Graphics graphicBuffer;

	private String fontType = "American Typewriter";
	private int fontStyle = Font.PLAIN;
	private Integer fontSize = 60;
	private Color fontColor = Color.white;
	private Color backgroundColor = Color.black;

	private int windowSizeX = 60 * 8 + 50;
	private int windowSizeY = 60 + 50;

	public PopupMenu popup = new PopupMenu();

	private Menu property = new Menu("Setting");
	private MenuItem menuItemExit = new MenuItem("Exit");

	private Menu menuFontType = new Menu("Font Type");
	private Menu menuFontSize = new Menu("Font Size");
	private Menu menuFontColor = new Menu("Font Color");
	private Menu menuBackgroundColor = new Menu("BackgroundColor");
	private RightClickMenu mouse;

	// フォントのデフォルトの設定
	private Font fontSetting = new Font(fontType, fontStyle, fontSize);

	// コンストラクタ
	public DigitalClock() {
		super(null);

		// 時刻用変数の初期化
		currentDate = new Date();

		property.add(menuFontType);
		for (String fonts : FONTS) {
			menuFontType.add(fonts);
		}

		property.add(menuFontColor);
		for (String fontSize : FONT_SIZE) {
			menuFontSize.add(fontSize);
		}

		property.add(menuFontColor);
		for (String stringColor : STRING_COLOR) {
			menuFontColor.add(new MenuItem(stringColor));
		}

		property.add(menuBackgroundColor);
		for (String stringColer : STRING_COLOR) {
			menuBackgroundColor.add(new MenuItem(stringColer));
		}
		popup.add(property);
		popup.add(menuItemExit);

		menuFontType.addActionListener(this);
		menuFontSize.addActionListener(this);
		menuFontColor.addActionListener(this);
		menuBackgroundColor.addActionListener(this);
		menuItemExit.addActionListener(this);

		add(popup);

		mouse = new RightClickMenu(this);

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public void paint(Graphics g) {
		// 現在時刻の更新
		currentDate = new Date();

		// 時刻用文字列の生成
		stringCurrentTime = simpleDataFormat.format(currentDate);

		if (null != graphicBuffer) {
			// ウィンドウサイズの計算
			windowSizeX = graphicBuffer.getFontMetrics().stringWidth(stringCurrentTime) + getInsets().left
					+ getInsets().right;

			windowSizeY = graphicBuffer.getFontMetrics().getAscent() + graphicBuffer.getFontMetrics().getDescent()
					+ graphicBuffer.getFontMetrics().getLeading() + getInsets().top;
		}
		setSize(windowSizeX, windowSizeY);

		imageBuffer = createImage(windowSizeX, windowSizeY);
		graphicBuffer = imageBuffer.getGraphics();

		// 背景を色つきで塗りつぶす
		graphicBuffer.setColor(backgroundColor);
		graphicBuffer.fillRect(0, 0, windowSizeX, windowSizeY);

		// 時刻の描画
		fontSetting = new Font(fontType, fontStyle, fontSize);
		graphicBuffer.setFont(fontSetting); // フォントの設定
		graphicBuffer.setColor(fontColor); // 文字色の設定

		graphicBuffer.drawString(stringCurrentTime, 0, graphicBuffer
				.getFontMetrics().getAscent() + getInsets().top - getInsets().bottom);

		// バッファのコピー
		g.drawImage(imageBuffer, 0, 0, this);
	}

	public int getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}

	@Override
	public void update(Graphics g) {
		// ちらつき防止のため、updateメソッドからそのままpaintメソッドにつなぐ
		// (画面がクリアされないようにする)
		paint(g);
	}

	@Override
	public void run() {
		while (true) {
			// 再描画
			repaint();

			try {
				Thread.sleep(10); // スリープ1秒
			} catch (InterruptedException e) {
				; // 何もしない
			}
		}

	}

	public String getFontType() {
		return fontType;
	}

	public void setFontType(String fontType) {
		this.fontType = fontType;
	}

	public Integer getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Font getFontSetting() {
		return fontSetting;
	}

	public void setFontSetting(Font fontSetting) {
		this.fontSetting = fontSetting;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DigitalClock window = new DigitalClock();

		window.th = new Thread(window);

		window.setSize(220, 150);
		window.setLocation(100, 100);
		window.setVisible(true);

		window.imageBuffer = window.createImage(220, 150);
		window.graphicBuffer = window.imageBuffer.getGraphics();
		window.setAlwaysOnTop(true);

		window.th.start(); // スレッドスタート

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (menuFontType == e.getSource()) {
			setFontType(e.getActionCommand());
		} else if (menuFontSize == e.getSource()) {
			setFontSize(Integer.valueOf(e.getActionCommand()));
		} else if (menuFontColor == e.getSource()) {
			setFontColor(changeStringToColor(e.getActionCommand()));
		} else if (menuBackgroundColor == e.getSource()) {
			setBackgroundColor(changeStringToColor(e.getActionCommand()));
		} else if ("Exit" == e.getActionCommand()) {
			System.exit(0);
		} else {
			System.out.println(e.getSource());
			System.out.println("This action is not implemented!");
		}
	}

	public Color changeStringToColor(String colorString) {
		for (int i = 0; i < STRING_COLOR.length; i++) {
			if (colorString == STRING_COLOR[i]) {
				return COLER_COLER[i];
			}
		}
		return Color.black;
	}

	public void setWindowLocation(int x, int y) {
		setLocation(x, y);
	}
}
