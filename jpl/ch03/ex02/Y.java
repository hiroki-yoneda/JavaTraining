package jpl.ch03.ex02;

public class Y extends X{
	protected int yMask = 0xff00;

	public Y() {
		System.out.printf("xMask:%x  fullMask:%x  yMask:%x \n", xMask, fullMask, yMask);
		fullMask |= yMask;
		System.out.printf("xMask:%x  fullMask:%x  yMask:%x \n", xMask, fullMask, yMask);
	}
}
