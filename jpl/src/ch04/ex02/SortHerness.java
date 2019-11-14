package jpl.ch04.ex02;

abstract class SortHerness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	/* 全ソートをするために呼び出される */
	public final SortMetrics sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	/* 拡張したクラスが要素の数を知るため */
	protected final int getDataLength() {
		return values.length;
	}

	/* 拡張したクラスが要素を比較するため */
	protected final int compare(int i, int j) {
		curMetrics.countCompareCnt();
		Comparable obj1 = (Comparable) values[i];
		Comparable obj2 = (Comparable) values[j];
		if(obj1.compareTo(obj2) == 0)
			return 0;
		else
			return (obj1.compareTo(obj2) < 0 ? -1 : 1);
	}

	/* 拡張したクラスが要素を交換するため */
	protected final void swap(int i, int j) {
		curMetrics.countSwapvnt();
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	/* 拡張したクラスが実装する */
	protected abstract void doSort();
}
