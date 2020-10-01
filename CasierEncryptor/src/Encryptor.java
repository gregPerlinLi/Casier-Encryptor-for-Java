import com.pa.util.CaserEncryption;
import com.pa.util.Encryption;
import com.pa.util.Out;
import com.pa.util.In;
import java.util.Scanner;
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
		} 
		display.display(output, mode);
		//m.display();
		
	}
	
}
