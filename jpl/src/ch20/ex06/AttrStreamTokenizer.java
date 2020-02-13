package jpl.ch20.ex06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

// わからない...

public class AttrStreamTokenizer {
	public static Attributed readAttrs(Reader source) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		AttributedImpl attrs = new AttributedImpl();
		Attr attr = null;
		in.commentChar('#'); //'#'は行の最後まで無視されるコメント
		in.ordinaryChar('/'); //コメント文字でなくす。
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				if (attr != null) {
					attr.setValue(in.sval);
					attr = null; //使い終った
				} else {
					attr = new Attr(in.sval); // name 追加
					attrs.add(attr); // attrsTable に追加
				}
			} else if (in.ttype == '=') {
				if (attr == null)
					throw new IOException("misplaced '=' or '+' or '-' ");
			} else {
				if (attr == null)//単語が期待される
					throw new IOException("Bad Attr name");
				attr.setValue(new Double(in.nval));
				attr = null;
			}
		}
		return attrs;
	}
}
