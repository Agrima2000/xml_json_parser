package miniProject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class JSONParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileReader fin = null;
		FileWriter fout = null;
		JSONString x;
		Scanner f;
		String fname, fpath, tpath, wd = "", name, value, values[],check;
		int ch, k = 0;
		char c;
		System.out.println("Enter the File Name (without .json)");
		fname = sc.next();
		fpath = "D:\\JAVA\\Java Projects\\Semester 4\\src\\miniProject\\" + fname + ".json";
		System.out.println(fpath);
		tpath = "D:\\JAVA\\Java Projects\\Semester 4\\src\\miniProject\\" + fname + ".txt";
		System.out.println(tpath);
		try {
			fin = new FileReader(fpath);
			fout = new FileWriter(tpath);
			f = new Scanner(fin);
			f.useDelimiter("\n");
			while(f.hasNext()) {
				wd = f.next();
				
				x = new JSONString();
				name = x.JSONtoName(wd);
				for(int i=0; i<wd.length(); i++) {
					if(wd.charAt(i) == ':') {
						check = wd.substring(i+1);
						check = check.trim();
						if(check.charAt(0) == '{') {
							k = 0;
							break;
						}
						else {
							k = 1;
							break;
						}
					}
				}
				
				if(name != "") {
					if(k == 1) {
						System.out.print(name + " : ");
						fout.write(name + " : ");
					}
					else {
						System.out.print(name);
						fout.write(name);	
					}
				}
				if(x.isArray(wd)) {
					values = new String[x.arrayLength(wd)];
					values = x.ArrayinJSON(wd);
					for(int j=0;j<values.length;j++) {
						System.out.print(values[j]);
						fout.write(values[j]);
						if(j<values.length-1) {
							System.out.print(", ");
							fout.write(", ");
						}
					}
					System.out.println();
				}
				else {
					value = x.JSONtoValue(wd);
					System.out.println(value);
					fout.write(value);
				}
				//Can use either for getting a newline
				//fout.write("\r\n");
				fout.write(System.lineSeparator());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(fname + ".json File Not Found");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fin != null) {
					System.out.println("JSON FILE PARSED SUCCESSFULLY !");
					fin.close();
				}
					
				if(fout !=null) {
					System.out.println(fname + ".txt FILE CREATED SUCCESSFULLY");
					fout.close();	
				}
			}
			catch(IOException e) {
				System.out.println("Unable to Close File" + e);
			}
		}
		
		
	}

}
