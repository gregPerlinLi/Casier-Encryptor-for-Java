package com.gregPerlinLi.util;

public class Out {
	public void display(StringBuffer text, int mode) {
		switch (mode) {
			case 1:
				System.out.println("密文输出：" + text);
				break;
			case 2:
				System.out.println("明文输出：" + text);
				break;
		}
	}
}
