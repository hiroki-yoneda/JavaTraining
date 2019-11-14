package dc.dc1_2;

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
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends Frame implements Runnable, ActionListener {
	private static final long serialVersionUID = 1L;

	private SimpleDateFormat simpleDataFormat = new SimpleDateFormat("HH:mm:ss");
	private String stringTime = "";

	private Thread th;
	private PropertyDialog dialog;
	private Menu menuMenu;
	private MenuItem menuProperty;
	private Image imageBuffer;
	private Graphics graphicBuffer;

	private String fontType = FontType.MS_PGOTHIC.toString();
	private Integer fontSize = 48;
	private Color fontColor = Color.blue;
	private Color backgroundColor = Color.white;

	private int windowSizeX = 220;
	private int windowSizeY = 150;

	private MenuBar menuBar;

	// フォントのデフォルトの設定
	private Font fontSetting = new Font("TimesRoman", Font.PLAIN, 48);

	public DigitalClock(String title) {
		// タイトルバーにタイトルを登録する
		super(title);

		// ウィンドウを閉じられるようにする
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

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
	}

	public void paint(Graphics g) {
		// 時刻用文字列の生成
		Date nowDate = new Date();
		stringTime = simpleDataFormat.format(nowDate);

		if (null != graphicBuffer) {
			// ウィンドウサイズの計算
			windowSizeX = graphicBuffer.getFontMetrics().stringWidth(stringTime);

			windowSizeX += getInsets().left;
			windowSizeX += getInsets().right;

			windowSizeY = graphicBuffer.getFontMetrics().getAscent();
			windowSizeY += graphicBuffer.getFontMetrics().getDescent();
			windowSizeY += graphicBuffer.getFontMetrics().getLeading();
			windowSizeY += getInsets().top;
		} else {
			windowSizeX = 220;
			windowSizeY = 150;
		}

		setSize(windowSizeX, windowSizeY);

		// https://www.javadrive.jp/applet/thread/index8.html ちらつき
		imageBuffer = createImage(windowSizeX, windowSizeY);
		graphicBuffer = imageBuffer.getGraphics();

		// 背景を色つきで塗りつぶす
		graphicBuffer.setColor(backgroundColor);
		graphicBuffer.fillRect(0, 0, windowSizeX, windowSizeY);

		// 時刻の描画
		fontSetting = new Font(fontType, Font.PLAIN, fontSize);
		graphicBuffer.setFont(fontSetting); // フォントの設定
		graphicBuffer.setColor(fontColor); // 文字色の設定
		graphicBuffer.drawString(stringTime, 0, graphicBuffer.getFontMetrics()
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
			dialog.setVisible(true);
		}
	}

}