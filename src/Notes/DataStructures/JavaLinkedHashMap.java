package Notes.DataStructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class JavaLinkedHashMap {

    public static void main(String[] args){
        /* Test Java's LinkedHashMap */
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(5, 0.75f, true);
        linkedHashMap.put("A", 0);
        linkedHashMap.put("B", 1);
        linkedHashMap.put("C", 2);
        linkedHashMap.put("D", 3);
        linkedHashMap.put("E", 4);
        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue() + " , ");
        }
        System.out.println();
        System.out.println("After get A");
        linkedHashMap.get("A");
        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue() + " , ");
        }
        System.out.println();
        System.out.println("After put F");
        linkedHashMap.put("F", 5);
        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue() + " , ");
        }
        System.out.println();
        System.out.println("Remove first element");
        linkedHashMap.remove(linkedHashMap.entrySet().iterator().next().getKey());
        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue() + " , ");
        }
        System.out.println();
        System.out.println("Size of the list - " + linkedHashMap.size());
        System.out.println("Get element not in the list X - " + linkedHashMap.get("X"));

        for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.print(entry.getKey() + " : " + entry.getValue() + " , ");
        }
        System.out.println();
    }
}