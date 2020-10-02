import java.util.Scanner;

import com.gregPerlinLi.util.CaserEncryption;
import com.gregPerlinLi.util.Encryption;
import com.gregPerlinLi.util.In;
import com.gregPerlinLi.util.MD5Encrypt;
import com.gregPerlinLi.util.Out;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Encryptor {
	
	
	public static void main(String[] args) {
		//System.out.println("Hello World");
		In text = new In();
		Out display = new Out();
		int key;
		
		Encryption password = new CaserEncryption();
		
		int mode = text.setMode();
		StringBuffer output = null;
		if (mode == 1) {
			key = text.setKey();
			char plaintext[] = text.getPlaintext();
			//System.out.println(plaintext);
			output = password.encryption(plaintext, key);
			//System.out.println(output);
		} else if (mode == 2) {
			key = text.setKey();
			char ciphertext[] = text.getCiphertext();
			output = password.deciphering(ciphertext, key);
		} else if (mode==3) {
			String vault;
			System.out.println("请输入要加密的文本：");
			MD5Encrypt md5 = new MD5Encrypt();
			vault = md5.stringMD5();
			System.out.println("MD5加密输出：" + vault);
		}
		display.display(output, mode);
		//m.display();
		
	}
	
}
