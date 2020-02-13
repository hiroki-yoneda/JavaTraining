package jpl.ch20.ex07;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class AttrTest {
	@Test
	public void AttrOutTest() {
		Attr attr = new Attr("hoge", "foo");
		try(final DataOutputStream out = new DataOutputStream(new FileOutputStream("src/main/java/jpl/ch20/ex07/resource.txt"))) {
			attr.writeData(out);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
