import java.util.*;
public class HashMapAndTree {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Sharan", 180000);
        map.put("Likith", 120000);
        map.put("Kou", 160000);
        map.put("Naveena", 200000); 
        

        // Print the HashMap
        System.out.println("HashMap: " + map);

        System.out.println("HashMap Size: " + map.size());
        System.out.println("HashMap is Empty: " + map.isEmpty());
        System.out.println("HashMap Contains Key 'Sharan': " + map.containsKey("Sharan"));
        System.out.println("Iterated using for-each loop:using entrySet()");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Iterated using for-each loop:using keySet()");
        for (String name : map.keySet()) {
            System.out.println(name + ": " + map.get(name));
        }
        System.out.println("Iterated using for-each loop:using values()");
        for (Integer salary : map.values()) {
            System.out.println(salary);
        }

        // Create a TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Sharan", 180000);
        treeMap.put("Kou", 160000);
        treeMap.put("Likith", 120000);
        treeMap.put("Naveena", 200000); 

        // Print the TreeMap
        System.out.println("TreeMap: " + treeMap);
    }
    

}
