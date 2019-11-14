package jpl.ch04.ex03;

public class LinkedList extends ListData implements LinkedListInterface {
    private ListData first;
    private ListData datas;

    @Override
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
}
