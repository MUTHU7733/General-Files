package javalearnings;

import java.util.HashMap;
import java.util.Map.Entry;

public class Map {

	public static void main(String[] args) {
		

		HashMap<String, Integer> map = new HashMap<>();

		// step 1(Add ten values)
		map.put("Namakkal", 637013);
		map.put("Chengalpatu", 637012);
		map.put("Trichy", 637011);
		map.put("Covai", 637010);
		map.put("madurai", 637009);
		map.put("Tmalai", 637008);
		map.put("Kkumari", 637007);
		map.put("Chennai", 637006);
		map.put("Salem", 637005);
		map.put("Kancheepuram", 637004);

		System.out.println("printing all the valuues:");
		// step 2(print the values)
		map.entrySet().forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));

		// Step 3(Mpdify the single key)
		System.out.println("after modifying the key:");
		HashMap<String, Integer> hashMap = map;
		hashMap.put("Thambaram", hashMap.remove("madurai"));
		System.out.println(hashMap);

		// Step 4(modify the single value)
		System.out.println("after modify the value:");
		map.replace("Namakkal", 637014);
		System.out.println(map);

		// Step 5(print a single value based on the key)
		for (Entry<String, Integer> entry : map.entrySet()) {
			int value = 637014;
			;
			if (entry.getValue() == value) {
				System.out.println("The key for value " + value + " is " + entry.getKey());
				break;
			}

		}

		// Step 6(find if a pincode is availble in the map)
		System.out.println("is the value is present?" + map.containsValue(637012));
		

		// Step 7(find if a town or city is available in map if yes print the pincode)
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getKey().equals("Chengalpatu")) {
				System.out.println("the pincode of the state is:" + entry.getValue());
			}

		}

	}
}
