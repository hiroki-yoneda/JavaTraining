package jpl.ch16.ex04;

import java.lang.annotation.Annotation;

public class PrintAnnotation {
	public static void main(String[] args){
		Class<?> cls;
		try {
			cls = Class.forName(args[0]);
			Annotation[] runTimeAnno = cls.getAnnotations();
			for(Annotation ann : runTimeAnno){
				System.out.println(ann);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
