package LeetCode.Algorithms.Medium;

import java.util.*;
public class SortCharactersByFrequency {
    /*
    Runtime: 5 ms, faster than 96.18%
    Memory Usage: 40.8 MB, less than 7.41%
 */
    static class Letter{
        char character;
        int freq;
        public Letter(char character){
            this.character = character;
            this.freq = 0;
        }
    }
    public String frequencySort5(String s){
        Letter[] letters = new Letter['z' - ' ' + 1];
        PriorityQueue<Letter> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(char c : s.toCharArray()){
            if(letters['z' - c] == null) letters['z' - c] = new Letter(c);
            letters['z' - c].freq++;
        }
        Arrays.stream(letters).forEach(a -> {
            if(a != null) pq.offer(a);
        });
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()){
            Letter l = pq.poll();
            while(l.freq --> 0) sb.append(l.character);
        }
        return sb.toString();
    }
    /*
    Runtime: 15 ms, faster than 43.36%
    Memory Usage: 42.2 MB, less than 7.41%
 */
    public String frequencySort(String s){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            max = Math.max(max, count);
        }
        List<List<Character>> bucket = new ArrayList<>();
        for(int i = 0; i <= max; i++) bucket.add(new ArrayList<>());
        for(Character c : map.keySet()){
            int freq = map.get(c);
            bucket.get(freq).add(c);
        }
        for(int i = bucket.size() - 1; i >= 0; i--){
            for(Character c : bucket.get(i)){
                int j = i;
                while(j --> 0) sb.append(c);
            }

        }
        return sb.toString();
    }
    /*
    Runtime: 156 ms, faster than 11.06%
    Memory Usage: 41.8 MB, less than 7.41%
     */
    public String frequencySort2(String s){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(b) - map.get(a));
        for(char c : s.toCharArray()) queue.add(c);
        while (!queue.isEmpty()) sb.append(queue.poll());
        return sb.toString();
    }
    /*
        Runtime: 53 ms, faster than 13.55%
        Memory Usage: 40.9 MB, less than 7.41%
     */
    public String frequencySort3(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> arr = new ArrayList<>();

        for(char c : s.toCharArray()) {
            arr.add(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        arr.sort((a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(b) - map.get(a));
        for(Character c : arr) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args){
        SortCharactersByFrequency sf = new SortCharactersByFrequency();
        String a = "Aabb"; // bbaA
        String b = "tree"; // eetr
        String c = "cccaaa"; // cccaaa
        String d = "loveleetcode"; // "eeeeoollvtdc"
        System.out.println(sf.frequencySort(a));
        System.out.println(sf.frequencySort(b));
        System.out.println(sf.frequencySort(c));
        System.out.println(sf.frequencySort(d));
    }
}
