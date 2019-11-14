package dc.dc1_2;

public enum FontType {
	MS_PGOTHIC("ＭＳ Ｐゴシック"),
	SERIF("Serif"),
	SAZANAMI_GOTHIC("Sazanami Gothic");

	private final String name;
	FontType(String name){ this.name = name; }
	public String toString() { return name; }
}
