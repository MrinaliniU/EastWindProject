package ElementsOfProgrammingInterview.Heaps;

import java.util.*;

public class KLongestString {

    public List<String> topK(int k, Iterator<String> s) {
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        while (s.hasNext()) {
            minHeap.add(s.next());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
         return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("aaaaaaa8", "aaaa5", "a2", "aa3", "aaa4", "a", "aaaaaaaa9");
        Iterator<String> it = input.iterator();
        KLongestString kls = new KLongestString();
        List<String> result = kls.topK(3, it);
        System.out.println(result);
    }
}
