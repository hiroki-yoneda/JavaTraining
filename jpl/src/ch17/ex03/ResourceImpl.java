package jpl.ch17.ex03;

import java.util.Map;
import java.util.WeakHashMap;

public final class ResourceImpl implements Resource {
	// Resourceオブジェクトがキーへの弱い参照を保持するようにする
	// 強い参照になり、キーが到達不可能にならないことを防ぐため
	// WeakHashMap は、オブジェクトに関連づけられた情報が不要だと想定して削除をする
	Map<Object, Object> map = new WeakHashMap<Object, Object>();
	boolean needsRelease = false;

	ResourceImpl(Object key) {
		//	ハッシュコードを使用する代わりに、キーを管理することで参照オブジェクトを使用する
		map.put(key, new Object());

		//　外部リソースの設定

		needsRelease = true;
	}

	public void use(Object key, Object... args) {
		if (map.get(key) == null) {
			throw new IllegalArgumentException("wrong key");
		}

		// リソースの使用
	}

	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;

			// リソース解放
		}
	}
}
