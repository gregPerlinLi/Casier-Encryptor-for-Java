package com.pa.util;

public class Simp {
	public boolean isSpecial(char ch) {
		if (ch>=' '&&ch<='/'||ch>=':'&&ch<='@'||ch>='['&&ch<='`'||ch>='{'&&ch<='~') {
			return true;
		} else {
			return false;
		}
	}
}
