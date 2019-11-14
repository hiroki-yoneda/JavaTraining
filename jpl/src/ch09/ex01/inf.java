package jpl.ch09.ex01;

public class inf {
	public static void main(String[] args) {
		Double pos_inf = Double.POSITIVE_INFINITY;
		Double neg_inf = Double.NEGATIVE_INFINITY;

		System.out.println("∞ + ∞  = " + (pos_inf + pos_inf));
		System.out.println("∞ + -∞ = " + (pos_inf + neg_inf));
		System.out.println("∞ - ∞  = " + (pos_inf - pos_inf));
		System.out.println("∞ - -∞ = " + (pos_inf - neg_inf));
		System.out.println("∞ * ∞  = " + (pos_inf * pos_inf));
		System.out.println("∞ * -∞ = " + (pos_inf * neg_inf));
		System.out.println("∞ / ∞  = " + (pos_inf / pos_inf));
		System.out.println("∞ / -∞ = " + (pos_inf / neg_inf));
	}
}