package jpl.ch17.ex04;

public final class ResourceImpl implements Resource {
	int keyHash;
	boolean needsRelease = false;

	ResourceImpl(Object key) {
		System.identityHashCode(key);

		//　外部リソースの設定

		needsRelease = true;
	}

	public void use(Object key, Object... args) {
		if (System.identityHashCode(key) != keyHash) {
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
