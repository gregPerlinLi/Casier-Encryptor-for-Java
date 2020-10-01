package com.pa.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class In {
	int key;
	char ciphertext[]; // 密文
	char plaintext[]; // 明文
	StringBuffer plaintextStr = new StringBuffer("");
	StringBuffer ciphertextStr = new StringBuffer("");
	final int max = 500; // 最大字符
	
	public int setMode() {
		int mode;
		System.out.println("***************** 欢迎使用凯撒加密器 *********************");
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入模式：\n1.加密\n2.解密\n");
		//mode = sc.nextInt();
		mode = scan.nextInt();
		if (mode == 1 || mode == 2) {
			return mode;
		} else {
			System.out.println("ERROR__模式错误...");
			return -1;
		}
		
	}
	
	public int setKey() {
		//System.out.println("***************** 欢迎使用凯撒加密器 *********************");
		System.out.println("请输入一个Caesar数字密钥：");
		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				key = sc.nextInt() % 26; // %26的意义是获取密钥的偏移值
				return key;
			} catch (Exception e) {
				System.out.println("ERROR__请重新输入整数密钥...");
			}
		}
	}
		
	//@Override
	public char[] getPlaintext() {
		plaintext = new char[max];
		for (int j = 0; j < max; j++) {
			plaintext[j] = '*'; // 设置临时变量将数组填充，因明文中可存在' '空，所以需要填充判断
		}
		int i = 0;
		char ch = ' ';
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入明文(最多可输入500个字符)");
		try {
			ch=(char) bf.read();//获得字符
			while(ch!='\r'&&ch!='\n'){
	    		//if(ch>='0'&&ch<='9'||ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'||ch==' '||ch==','||ch=='.'||ch=='!'){
	        	if(ch>=' ' && ch<='~') {	
					plaintext[i]=ch;
	        		i++;
	    		}
	    		else{
	    			System.out.println("输入字符不支持！！");
	    			break;
	    		}
	    		//plaintext[i]=ch;
        		//i++;
	    		try{
	    			ch=(char) bf.read();
	    		}
	    		catch(Exception e1){
	    			
	    		}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plaintext;
	}
	
	public char[] getCiphertext() {
		ciphertext = new char[max];
		for (int j = 0; j < max; j++) {
			ciphertext[j] = '*'; // 设置临时变量将数组填充，因明文中可存在' '空，所以需要填充判断
		}
		int i = 0;
		char ch = ' ';
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入密文(最多可输入500个字符");
		try {
			ch=(char) bf.read();//获得字符
			while(ch!='\r'&&ch!='\n'){
				if(ch>=' ' && ch<='~') {
	        		ciphertext[i]=ch;
	        		i++;
	        	}
	    		else{
	    			System.out.println("输入字符不支持！！");
	    			break;
	    		}
	    		try{
	    			ch=(char) bf.read();
	    		}
	    		catch(Exception e1){
	    			
	    		}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ciphertext;
	}
	
}
