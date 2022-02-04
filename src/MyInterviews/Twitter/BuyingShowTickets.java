package MyInterviews.Twitter;

import java.util.*;

public class BuyingShowTickets {

    public static long waitingTimeFaster(List<Integer> tickets, int p){
        long time = tickets.get(p);
        for(int i = 0; i < tickets.size(); i++){
            if(i < p){
                time += Math.min(tickets.get(i), tickets.get(p));
            }else if(i > p){
                time += Math.min(tickets.get(i), tickets.get(p) - 1);
            }
        }
        return time;
    }
    public static int waitingTime(List<Integer> tickets, int p){
        int alex = p;
        int time = 0;
        int purchase = tickets.get(p);
        Queue<Integer> line = new LinkedList<>(tickets);
        while (!line.isEmpty()){
            int f = line.poll();
            f--;
            alex--;
            if(f != 0) line.add(f);
            time++;
            if(alex == -1){
                if(purchase == 1) break;
                else {
                    alex = line.size() - 1;
                    purchase--;
                }
            }
        }
        return time;
    }
    public static void main(String[] args){
        List<Integer> tickets = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        int p = 0;
        System.out.println("Time to purchase " + waitingTimeFaster(tickets, p));
    }
}
