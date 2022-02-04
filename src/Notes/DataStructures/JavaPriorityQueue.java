package Notes.DataStructures;

import java.util.*;

public class JavaPriorityQueue {
    static class Cost implements Comparable<Cost>{
        Character node;
        Integer cost;
        Cost(Character node, int cost){
            this.node = node;
            this.cost = cost;
        }
        int getCost(){
            return this.cost;
        }

        @Override
        public int compareTo(Cost o) {
            return this.cost.compareTo(o.cost);
        }
    }

    public void demo1(){
        Comparator<Cost> costSorter = Comparator.comparing(Cost::getCost);
        PriorityQueue<Cost> queue = new PriorityQueue<>(costSorter);
        List<Cost> cost_list = new ArrayList<>();
        cost_list.add(new Cost('A', 1)); // index 0
        cost_list.add(new Cost('B', 0)); // index 1
        cost_list.add(new Cost('C', 3)); // index 2
        cost_list.add(new Cost('D', 2)); // index 3
        queue.addAll(cost_list);
        // Expected pattern is B A D C.
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
        cost_list.get(2).cost = 0; // here at index 2 for char C you are updating the priority to 0
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
        // the priority of C does get updated but D gets printed before C anyways.
        // This is because the comparator works only while inserting something to the queue.
        // So for it to work the way you are expecting you will need to remove C from the queue
        // update it's cost to 0 add it again. And then go ahead with queue polling.
    }

    public void demo2(){
        Comparator<Cost> costSorter = Comparator.comparing(Cost::getCost);
        PriorityQueue<Cost> queue = new PriorityQueue<>(costSorter);
        List<Cost> cost_list = new ArrayList<>();
        cost_list.add(new Cost('A', 1)); // index 0
        cost_list.add(new Cost('B', 0)); // index 1
        cost_list.add(new Cost('C', 3)); // index 2
        cost_list.add(new Cost('D', 2)); // index 3
        queue.addAll(cost_list);
        // Expected pattern is B A D C.
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
        // remove C from the priority queue
        queue.remove(cost_list.get(2)); // C is at index 2 of the list
        cost_list.get(2).cost = 0; // update the cost of C
        queue.add(cost_list.get(2)); // now that you have removed C updated C and added it to queue again
        System.out.print(Objects.requireNonNull(queue.poll()).node + " "); // this will print C
        System.out.print(Objects.requireNonNull(queue.poll()).node + " ");
    }
    public static void main(String[] args){
        JavaPriorityQueue jp = new JavaPriorityQueue();
        jp.demo1();
        System.out.println();
        jp.demo2();
    }
}
