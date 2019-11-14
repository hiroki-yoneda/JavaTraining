package jpl.ch07.ex03;

public class Pascal {
	private final int Depth;
	private int[][] array;

	public Pascal(int Depth) {
		this.Depth = Depth;
		this.array = new int[Depth][];
	}

	public void calc() {
		for (int i = 0; i < Depth; i++) {
			array[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				if ((i - 1) >= 0 && (j - 1) >= 0 && j < i) {
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
				} else {
					array[i][j] = 1;
				}
			}
		}
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf(array[i][j] + " ");
			}
			System.out.printf("%n");
		}
	}
}
