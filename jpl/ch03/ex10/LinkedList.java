package jpl.ch03.ex10;

class ListData {
    Object data;
    ListData next;
}

public class LinkedList implements Cloneable{
    private ListData first;
    private ListData datas;

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

    public LinkedList clone() {
    	try {
    		return (LinkedList) super.clone();
    	} catch (CloneNotSupportedException e) {
    		throw new InternalError(e.toString());
    	}
    }
}

