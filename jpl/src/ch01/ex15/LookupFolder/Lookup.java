package practice01.LookupFolder;

interface Lookup {
	/* name と関連付けされた値を返す。
	 * そのような値がなければnullを返す
	 */
	Object find(String name);
}
