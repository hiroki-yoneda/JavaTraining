package js8ri.ch05.ex02;

import java.time.LocalDate;

public class IncrementYears {
	public static void main(String[] args) {
		System.out.println(LocalDate.of(2000, 2, 29).plusYears(1));
		System.out.println(LocalDate.of(2000, 2, 29).plusYears(4));
		System.out.println(LocalDate.of(2000, 2, 29).plusYears(1).plusYears(1).plusYears(1).plusYears(1));
//      出力
//		2001-02-28
//		2004-02-29
//		2004-02-28
//      ４年を足した結果と１年を４回足した結果が異なる。
//      なんで？？？？？
	}
}
