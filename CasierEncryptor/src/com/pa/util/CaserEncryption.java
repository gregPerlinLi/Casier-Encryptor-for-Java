package com.pa.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.pa.util.In;
import com.pa.util.Encryption;
import com.pa.util.Simp;

public class CaserEncryption implements Encryption {
	char ciphertext[]; // 密文
	//int key;
	char plaintext[]; // 明文
	StringBuffer plaintextStr = new StringBuffer("");
	StringBuffer ciphertextStr = new StringBuffer("");
	final int max = 500; // 最大字符
	Simp special = new Simp();
	
	@Override
	public StringBuffer encryption(char[] setPlaintext, int key) {
		//System.out.println(setPlaintext);
		ciphertext = new char[max];
		for (int j = 0; j < max; j++) {
			ciphertext[j] = '*'; // 设置临时变量将数组填充，因明文中可存在' '空，所以需要填充判断
		}
		//System.out.println(ciphertext);

		int temp = 0;
		
		for (int i = 0; i < setPlaintext.length; i++) {
			if (setPlaintext[i] != '*') {
				temp = setPlaintext[i] + key;
				//if (setPlaintext[i] == ' ' || setPlaintext[i] == ',' || setPlaintext[i] == '.' || setPlaintext[i] == '!') {
				//if (setPlaintext[i]>=' '&&setPlaintext[i]<='/'||setPlaintext[i]>=':'&&setPlaintext[i]<='@'||setPlaintext[i]>='['&&setPlaintext[i]<='`'||setPlaintext[i]>='{'&&setPlaintext[i]<='~') {
				if (special.isSpecial(setPlaintext[i]) == true) {
					ciphertext[i] = (char) (setPlaintext[i]);
					//System.out.println(1);
				}
				// ASCII码 A=65,Z=90; a=97 z=122; 0=48 9=57
				//System.out.println(temp);
				if (setPlaintext[i] >= 'a' && setPlaintext[i] <= 'z') {
					if (temp > 122)
						ciphertext[i] = (char) (97 + temp - 123);
					else {
						ciphertext[i] = (char) temp;
					}
					//System.out.println(2);
				}
				if (setPlaintext[i] >= 'A' && setPlaintext[i] <= 'Z') {
					if ((setPlaintext[i] + key) > 90)
						ciphertext[i] = (char) (65 + temp - 91);
					else {
						ciphertext[i] = (char) temp;
					}
				}
				if (setPlaintext[i] >= '0' && setPlaintext[i] <= '9') {
					if ((setPlaintext[i] + key) > 57)
						ciphertext[i] = (char) (48 + temp - 58);
					else {
						ciphertext[i] = (char) temp;
					}
				}
				ciphertextStr.append(ciphertext[i]);
				//System.out.println(ciphertext);
			} else {
				break;
			}
		}
		return ciphertextStr;
	}
	
	@Override
	public StringBuffer deciphering(char[] setCiphrttext, int key) {// 解密
		char c = ' ';
		int temp = 0;
		for (int i = 0; i < setCiphrttext.length; i++) {
			temp = setCiphrttext[i] - key;
			if (setCiphrttext[i] != '*') {
				//if (setCiphrttext[i]>=' '&&setCiphrttext[i]<='/'||setCiphrttext[i]>=':'&&setCiphrttext[i]<='@'||setCiphrttext[i]>='['&&setCiphrttext[i]<='`'||setCiphrttext[i]>='{'&&setCiphrttext[i]<='~') {
				if (special.isSpecial(setCiphrttext[i]) == true) {
					c = (char) (setCiphrttext[i]);
				}
				if (setCiphrttext[i] >= 97 && setCiphrttext[i] <= 122) {
					c = (char) (temp);
					if (temp < 97) {
						c = (char) (26 + temp);
					}
				}
				if (setCiphrttext[i] >= 65 && setCiphrttext[i] <= 90) {
					c = (char) (temp);
					if (temp < 65) {
						c = (char) (26 + temp);
					}
				}
				if (setCiphrttext[i] >= 48 && setCiphrttext[i] <= 57) {
					c = (char) (temp);
					if (temp < 48) {
						c = (char) (10 + temp);
					}
				}
				plaintextStr.append(c);
			} else {
				break;
			}
		}
		return plaintextStr;
	}
}

