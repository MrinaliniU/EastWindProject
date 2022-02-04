package LeetCode.Algorithms.Medium;

import java.util.*;

public class InsertDeleteGetRandom {
    static class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> map;
        int nextIndex;
        Random random;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            nextIndex = 0;
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, nextIndex);
            list.add(val);
            nextIndex++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            delete(val);
            return true;
        }

        private void delete(int val) {
            int indexOfVal = map.get(val);
            // swap
            int itemAtLastIndex = list.get(nextIndex - 1);
            list.set(indexOfVal, itemAtLastIndex);
            map.put(itemAtLastIndex, indexOfVal);
            // remove
            map.remove(val);
            list.remove(nextIndex - 1);
            nextIndex--;
        }

        public int getRandom() {
            int pick = random.nextInt(nextIndex);
            return list.get(pick);
        }
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        List<Boolean> ans = new ArrayList<>();
        ans.add(rs.remove(0));
        ans.add(rs.remove(0));
        ans.add(rs.insert(0));
        int random1 = rs.getRandom();
        ans.add(rs.remove(0));
        ans.add(rs.insert(0));
    }
}
