package miniProject;

public class XMLString {
	String content,tag;
	
	XMLString(){
		content = "";
		tag = "";
	}
	
	boolean isSpecialCharacter(char c) {
		boolean b;
		if(Character.isLetter(c))
		{
			b = false;
		}
		else if(Character.isDigit(c)) {
			b = false;
		}
		else if(c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*' || c == '(' || c == ')') {
			b = true;
		}
		else {
			b = false;
		}
		return b;
	}
	
	String XMLtoString(String str) {
		int i = 0;
		char ch;
		for(i=0;i<str.length()-1;i++) {
			ch = str.charAt(i);
			if((ch == '>') && ((Character.isLetter(str.charAt(i+1))) || (Character.isDigit(str.charAt(i+1))) || (isSpecialCharacter(str.charAt(i+1))) )) {
				i++;
				ch = str.charAt(i);
				while(ch != '<') {
					content = content + ch;
					i++;
					ch = str.charAt(i);
				}
			}
		}
		return (content);
	}
	
	
	String XMLtoTag(String str) {
		int i = 0;
		char ch;
		for(i=0;i<str.length();i++) {
			ch = str.charAt(i);
			if(ch == '<') {
				i++;
				ch = str.charAt(i);
				if(ch == '/') {
					break;
				}
				while(ch != '>') {
					tag = tag + ch;
					i++;
					ch = str.charAt(i);
				}
			}
		}
		return (tag);
	}
	
}
