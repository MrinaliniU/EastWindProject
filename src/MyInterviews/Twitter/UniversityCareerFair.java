package MyInterviews.Twitter;

import java.util.*;

public class UniversityCareerFair {
    /* Interval Scheduling Algorithm. Fastest finishing first
    * The next one to be scheduled will be the one that STARTS after the scheduled
    * event is over. */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration){
        int schedule = 0;
        List<Integer> finishTime = new ArrayList<>();
        for(int i = 0; i < arrival.size(); i++){
            finishTime.add(arrival.get(i) + duration.get(i));
        }
        TreeMap<Integer, Integer> finish_Arrival = new TreeMap<>();
        for(int i = 0; i < finishTime.size(); i++){
            finish_Arrival.put(finishTime.get(i), arrival.get(i));
        }
        // start scheduling fastest finish time
        int stageFreeAt = 0;
        for(Map.Entry<Integer, Integer> finish_Arrival_entry : finish_Arrival.entrySet()){
            if(finish_Arrival_entry.getValue() >= stageFreeAt){
                schedule++;
                stageFreeAt = finish_Arrival_entry.getKey();
            }
        }

        return schedule;
    }

    public static void main(String[] args){
        List<Integer> arrival = new ArrayList<>(Arrays.asList(1, 3, 3, 4, 7));
        List<Integer> duration = new ArrayList<>(Arrays.asList(2, 2, 1, 2, 1));
        System.out.println(maxEvents(arrival, duration));
    }
}
