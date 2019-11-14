package jpl.ch03.ex12;

final class SortMetrics implements Cloneable{
	private long probeCnt,       //単純なデータの値調査
				compareCnt,     //２つの要素の比較
				swapCnt;        //２つの要素の交換
	public void init() {
		probeCnt = swapCnt = compareCnt = 0;
	}

	final public void countProbeCnt() {
		this.probeCnt++;
	}

	final public void countCompareCnt() {
		this.probeCnt++;
	}

	final public void countSwapvnt() {
		this.swapCnt++;
	}

	public String toString() {
		return probeCnt + " probes " + compareCnt + " compareCnt " + swapCnt + " swapCnt";
	}

	public SortMetrics clone() {
		try {
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
