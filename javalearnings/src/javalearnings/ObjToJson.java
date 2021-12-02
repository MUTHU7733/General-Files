package javalearnings;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ObjToJson {

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Staff staff = createStaffObject();
		String json=gson.toJson(staff);
		
		try(Writer file = new FileWriter("D:\\java learning\\javalearnings\\src\\javalearnings\\gson.json")){
		gson.toJson(staff, file);
		}catch (IOException e) {
            e.printStackTrace();
        }
	}

	private static Staff createStaffObject() {
		Staff staff = new Staff();
		staff.setAge(80);
		staff.setName("muthu");
	    staff.setNum(123);
	    
		return staff;
		
	}

}
