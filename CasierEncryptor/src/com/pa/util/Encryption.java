package com.pa.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import com.pa.util.Mainer;

public interface Encryption {
	
	//int setKey();
	//void getPlaintext();
	StringBuffer encryption(char[] setPlaintext, int key);
	StringBuffer deciphering(char[] setCiphertext, int key);
	
}
