package dc.dc1_4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.Preferences;

public class DigitalClock extends Frame implements Runnable, ActionListener {
	private Integer hourInteger; // 時
	private Integer minuteInteger; // 分
	private Integer secondInteger; // 秒

	private String hourString;
	private String minuteString;
	private String secondString;

	private Thread th;
	private PropertyDialog dialog;
	private Menu menuMenu;
	private MenuItem menuProperty;
	private Image imageBuffer;
	private Graphics graphicBuffer;

	private String fontType = "American Typewriter";
	private Integer fontSize = 48;
	private Color fontColor = PropertyDialog.colorColor[1];
	private Color backgroundColor = PropertyDialog.colorColor[0];

	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	private int windowSizeX = prefs.getInt("window_x", 48 * 8 + 50);
	private int windowSizeY = prefs.getInt("window_y", 48 * 50);

	private String timeString;

	private MenuBar menuBar;

	// フォントのデフォルトの設定
	private Font fontSetting = new Font("American Typewriter", Font.PLAIN, 48);

	public DigitalClock(String title) {
		// タイトルバーにタイトルを登録する
		super(title);

		// ウィンドウを閉じられるようにする
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// windowを閉じるときにパラメータを保存する
				prefs.putInt("window_x", (int) getBounds().getX());
				prefs.putInt("window_y", (int) getBounds().getY());
				prefs.putInt("window_width", (int) getBounds().getWidth());
				prefs.putInt("window_height", (int) getBounds().getHeight());

				prefs.put("font_type", fontType);
				prefs.putInt("font_size", fontSize);
				prefs.put("font_color", PropertyDialog.changeColorToString(fontColor));
				prefs.put("bg_color", PropertyDialog.changeColorToString(backgroundColor));

				System.exit(0);
			}
		});

		// prefsからパラメータを読み込む
		setBounds(prefs.getInt("window_x", 500), prefs.getInt("window_y", 100),
				prefs.getInt("window_width", 500), prefs.getInt("window_height", 200));
		fontType = prefs.get("font_type", "American Typewriter");
		fontSize = prefs.getInt("font_size", 48);
		fontColor = PropertyDialog.changeStringToColor(prefs.get("font_color", PropertyDialog.stringColor[1]));
		backgroundColor = PropertyDialog
				.changeStringToColor(prefs.get("bg_color", PropertyDialog.stringColor[0]));

		// メニューバーを作成する
		menuBar = new MenuBar();
		setMenuBar(menuBar);

		// [Menu]
		menuMenu = new Menu("Menu");
		menuMenu.addActionListener(this);
		menuBar.add(menuMenu);

		// [Menu] - [Property]
		menuProperty = new MenuItem("Property");
		menuMenu.add(menuProperty);

		// ダイアログを生成する
		dialog = new PropertyDialog(this);

		// 現在時刻用変数の初期化
		hourInteger = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		minuteInteger = Calendar.getInstance().get(Calendar.MINUTE);
		secondInteger = Calendar.getInstance().get(Calendar.SECOND);
	}

	public void paint(Graphics g) {
		// 時・分・秒が一桁の時、0で二桁目を埋める
		if (hourInteger < 10) {
			hourString = "0" + hourInteger;
		} else {
			hourString = hourInteger.toString();
		}

		if (minuteInteger < 10) {
			minuteString = "0" + minuteInteger;
		} else {
			minuteString = minuteInteger.toString();
		}

		if (secondInteger < 10) {
			secondString = "0" + secondInteger;
		} else {
			secondString = secondInteger.toString();
		}
		timeString = hourString + ":" + minuteString + ":" + secondString;

		// ウィンドウサイズの計算
		if (null != graphicBuffer) {
			windowSizeX = graphicBuffer.getFontMetrics().stringWidth(timeString);
			windowSizeX += getInsets().left;
			windowSizeX += getInsets().right;
		} else {
			windowSizeX = 48 * 8 + 50;
		}

		if (null != graphicBuffer) {
			windowSizeY = graphicBuffer.getFontMetrics().getAscent();
			windowSizeY += graphicBuffer.getFontMetrics().getDescent();
			windowSizeY += graphicBuffer.getFontMetrics().getLeading();
			windowSizeY += getInsets().top;
		} else {
			windowSizeY = 48 * 50;
		}

		setSize(windowSizeX, windowSizeY);

		imageBuffer = createImage(windowSizeX, windowSizeY);
		graphicBuffer = imageBuffer.getGraphics();

		// 背景を色つきで塗りつぶす
		graphicBuffer.setColor(backgroundColor);
		graphicBuffer.fillRect(0, 0, windowSizeX, windowSizeY);

		// 時刻の描画
		fontSetting = new Font(fontType, Font.PLAIN, fontSize);
		graphicBuffer.setFont(fontSetting); // フォントの設定
		graphicBuffer.setColor(fontColor); // 文字色の設定
		graphicBuffer.drawString(timeString, 0, graphicBuffer.getFontMetrics()
				.getAscent() + getInsets().top - getInsets().bottom);

		// バッファのコピー
		g.drawImage(imageBuffer, 0, 0, this);
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
			// 現在時刻の獲得
			hourInteger = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			minuteInteger = Calendar.getInstance().get(Calendar.MINUTE);
			secondInteger = Calendar.getInstance().get(Calendar.SECOND);

			// 再描画
			repaint();

			try {
				Thread.sleep(100); // スリープ1秒
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
		DigitalClock window = new DigitalClock("Digital Clock");

		window.th = new Thread(window);

		window.setSize(220, 150);
		window.setResizable(false);
		window.setVisible(true);

		window.imageBuffer = window.createImage(220, 150);
		window.graphicBuffer = window.imageBuffer.getGraphics();

		window.th.start(); // スレッドスタート

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Property") {
			// クリックしたのが「Property」だったら
			dialog.resetParameter();
			dialog.setVisible(true);
		} else {
			System.out.println("actionPerformed error");
		}
	}
}
