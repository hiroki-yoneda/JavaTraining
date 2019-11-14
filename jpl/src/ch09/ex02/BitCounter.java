package jpl.ch09.ex02;

public class BitCounter {
	public int CheckBitCount(Integer n) {
		int Counter=0;
		for(int j = 0; j < Integer.SIZE; j++){
			Counter += (n & 1);
			n = n >>> 1;
		}
		return Counter;
	}
}
