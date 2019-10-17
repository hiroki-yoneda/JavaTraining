package jpl.ch03.ex07;

public class ColorAttr extends Attr{
	private ScreenColor myColor; //変換された色

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	public Object setValue(Object newValue) {
		//スーパークラスの setValue を最初に行う
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	/** 値を記述ではなく ScreenColor に設定する **/
	public ScreenColor setValue(ScreenColor newValue) {
		//スーパークラスの setValue を最初に行う
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	/** 変換された ScreenColor オブジェクトを返す **/
	public ScreenColor getColor() {
		return myColor;
	}

	/** getValue() で得られる記述から ScreenColor を設定する **/
	protected void decodeColor() {
		if (getValue() == null) {
			myColor = null;
		} else {
			myColor = new ScreenColor(getValue());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myColor == null) ? 0 : myColor.hashCode());
		System.out.println(result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorAttr other = (ColorAttr) obj;
		if (myColor == null) {
			if (other.myColor != null)
				return false;
		} else if (!myColor.equals(other.myColor))
			return false;
		return true;
	}
}
