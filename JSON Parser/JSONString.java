package miniProject;

public class JSONString {
	String name, value;
	
	JSONString() {
		name = "";
		value = "";
	}
	
	boolean isArray(String str) {
		int i = 0;
		boolean b = false;
		for(i=0;i<str.length();i++) {
			if(str.charAt(i) == '[') {
				b = true;
			}
		}
		return b;
	}
	
	int arrayLength(String str) {
		int i=0,c=0;
		for(i=0;i<str.length();i++) {
			if(str.charAt(i) == ',') {
				c++;
			}
		}
		return (c);
	}
	
	String JSONtoName(String str) {
		int i=0;
		char ch;
		str = str.trim();
		for(i=0;i<str.length()-1;i++) {
			ch = str.charAt(i);
			if(ch == '"') {
				i++;
				ch = str.charAt(i);
				while(ch != '"') {
					name = name + ch;
					i++;
					ch = str.charAt(i);
				}
				break;
			}
			else if(ch == '}' || ch == '{'){
				name = "";
			}
		}
		return (name);
	}
	
	String JSONtoValue(String str) {
		int i=0,j=0;
		char ch;
		String arr,temp;
		for(i=0;i<str.length()-1;i++) {
			ch = str.charAt(i);
			if(ch == ':') {
				temp = str.substring(i+1);
				temp = temp.trim();
				if(temp.length() !=1 ) {
					j++;
					ch = temp.charAt(j);
					do {
						value = value + ch;
						j++;
						ch = temp.charAt(j);
					}
					while(ch != '"');
					break;
				}
				
			}
		}
		return (value);
	}
	
	String[] ArrayinJSON(String str) {
		int i = 0,j = 0;
		char ch;
		int l = arrayLength(str);
		String s[] = new String[l];
		String wd = "";
		for(i=0;i<str.length();i++) {
			ch = str.charAt(i);
			if(ch == '[') {
				do {
					i++;
					ch = str.charAt(i);
					if(ch == '"') {
						i++;
						ch = str.charAt(i);
						while(ch != '"') {
							wd = wd + ch;
							i++;
							ch = str.charAt(i);
						}
						s[j] = wd;
						j++;
					}
					else if(ch == ',') {
						wd = "";
					}
				}
				while(ch != ']');
			}
		}
		return (s);
	}

}
