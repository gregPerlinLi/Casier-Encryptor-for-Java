# **凯撒加密器（Java版） CasierEncryptor for Java**

## **将输入的文字通过凯撒加密法进行加密**

## By: -gregPerlinLi-

### **主要功能**

1. 可以选择加密模式还是解密模式
2. 可以自行输入偏移位数
3. 可对英文以及数字进行加密和解密处理，特殊字符（如空格等）将会保持原样，暂时无法输入汉字
4. 通过控制台（或终端）进行输入和输出

### **目标**

- [x] 将加密方法写到独立的`class`中
- [x] 定义`interface`接口类，并提供了加密和解密两种方法
- [x] 让`CaesarEncryption`实现`Encryption`接口，并在加解密是调用相应的方法
- [ ] 编写`MD5`的`class`，用于进行`MD5`的加密（`MD5`无法解密）
- [ ] 在尝试用MD5进行解密时立刻`throw`异常`UnsupportedOperationException`，并附带“`MD5`无法解密”的信息，并对其进行正确的处理
- [ ] 对程序进行细致的分包
- [ ] 使用`MySQL`并将加密后的结果保存到`MySQL`中
- [ ] 开发图形化界面

### **程序核心部分**

加密：

```java
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
```



解密：

```java
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
```

