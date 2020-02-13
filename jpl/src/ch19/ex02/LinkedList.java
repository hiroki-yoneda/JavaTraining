package jpl.ch19.ex02;

class ListData {
    Object data;
    ListData next;
}

public class LinkedList {
	/** リストの最初 */
    private ListData first;
    /** 一つ前のリスト */
    private ListData datas;

    /**
     * リストを生成して、前のリストに連結する
     * @param data
     */
    public void addFirst(Object data) {
    	ListData listData = new ListData();
        listData.data = data;
        if (datas != null) {
        	datas.next = listData;
        	if (first == null) {
            	first = datas;
        	} else {
        		first.next = datas;
        	}
        }
        datas = listData;
    }

    /**
     * リストに格納されているデータの文字列表現を返す
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        // リストの先頭から順番に処理
        ListData current = first;
        // 要素がある間中繰り返し
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            // 次の要素に移動
            current = current.next;
        }
        return sb.toString();
    }

    /**
     * リストの要素数を返す
     */
    public int countNum() {
    	int i = 0;
    	StringBuilder sb = new StringBuilder();
    	// リストの先頭から順番に処理
        ListData current = first;
        // 要素がある間中繰り返し
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            // 次の要素に移動
            current = current.next;
            i++;
        }
    	return i;
    }
}

