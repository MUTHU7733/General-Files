package javalearnings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

public class Jsontoobj {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		try {
			Reader reader = new FileReader("D:\\java learning\\javalearnings\\src\\javalearnings\\gson.json");
			
			Staff staff = gson.fromJson(reader, Staff.class);
			System.out.println(staff);
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
