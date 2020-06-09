import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestHashMapAndHashTable {

	public static void main(String[] args) {
		
		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("A",1);
		hashmap.put("B", "ASD");
		HashMap<String, Object> hashmap2 = new HashMap<>();
		HashMap<String, Object> hashmap3 = new HashMap<>();
		hashmap.keySet().forEach (key ->
		{
			hashmap2.put(key, hashmap.get(key));
			hashmap3.put(key, hashmap.get(key));
		});
		hashmap2.put("A", 2);
		hashmap2.put("C", 3);
		HashMap<String, Object> hashmap4 = hashmap;
		hashmap4.put("D", "new");
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("FIRST", 1);
		LinkedHashMap<String, Object> map2 = new LinkedHashMap<>();
		map2.put("FIRST", 2);
		
		System.out.println(hashmap);
		System.out.println(hashmap2);
		System.out.println(hashmap3);
		System.out.println(hashmap4);
		System.out.println(map);
		System.out.println(map2);
		
		String s = "ASDCDASFD_ASSFD";
		System.out.println(s.replaceAll("A", ""));
	}
}
