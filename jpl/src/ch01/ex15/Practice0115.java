package jpl.ch01.ex15;

import jpl.ch01.ex15.LookupFolder.SimpleLookup;

class Practice0115 {

	/* 配列のaddとremoveの操作がわからなかった */
	public static void main(String[] args) {

		SimpleLookup simpleLookup = new SimpleLookup();
		simpleLookup.add("Test");
		simpleLookup.add("Test01");
		System.out.println(simpleLookup.find("Test01"));
		simpleLookup.remove("Test01");


	}

}
