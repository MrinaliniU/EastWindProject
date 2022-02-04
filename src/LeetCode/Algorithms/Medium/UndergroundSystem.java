package LeetCode.Algorithms.Medium;

import java.util.*;
/*
    Runtime: 74 ms, faster than 50.00%
    Memory Usage: 54.8 MB, less than 100.00%
 */
public class UndergroundSystem {
    HashMap<String, HashMap<Integer, Integer>> fromStation = new HashMap<>();
    HashMap<String, HashMap<Integer, Integer>> toStation = new HashMap<>();
    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        HashMap<Integer, Integer> checkInStation = fromStation.getOrDefault(stationName, new HashMap<>());
        checkInStation.put(id, t);
        fromStation.put(stationName, checkInStation);
    }

    public void checkOut(int id, String stationName, int t) {
        HashMap<Integer, Integer> checkOutStation = toStation.getOrDefault(stationName, new HashMap<>());
        checkOutStation.put(id, t);
        toStation.put(stationName, checkOutStation);
    }

    public double getAverageTime(String startStation, String endStation) {
        double allCheckOuts = 0, allCheckIns = 0;
        int numberOfPassengers = 0;
        HashMap<Integer, Integer> checkIns = fromStation.get(startStation);
        HashMap<Integer, Integer> checkOuts = toStation.get(endStation);
        for(Map.Entry<Integer, Integer> entry : checkIns.entrySet()){
            if(checkOuts.containsKey(entry.getKey())){
                numberOfPassengers++;
                allCheckOuts += checkOuts.get(entry.getKey());
                allCheckIns += entry.getValue();
            }
        }
        return (allCheckOuts - allCheckIns) / numberOfPassengers;
    }

    public static void main(String[] args){
        System.out.println("Underground1");
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));  // return 12.0
        System.out.println("Underground2");
        UndergroundSystem undergroundSystem1 = new UndergroundSystem();
        undergroundSystem1.checkIn(2,"V",71);
        undergroundSystem1.checkIn(3,"E",86);
        undergroundSystem1.checkOut(3,"S",169);
        undergroundSystem1.checkIn(4,"U",223);
        System.out.println(undergroundSystem1.getAverageTime("E","S")); // 83
        System.out.println(undergroundSystem1.getAverageTime("E","S"));// 83
        undergroundSystem1.checkOut(4,"S",226);
        undergroundSystem1.checkOut(2,"K",255);
        undergroundSystem1.checkIn(1,"U",342);
        undergroundSystem1.checkIn(5,"1D",352);
        undergroundSystem1.checkIn(6,"0Q",374);
        undergroundSystem1.checkOut(5,"WG",412);
        undergroundSystem1.checkIn(7,"ZS",467);
        System.out.println(undergroundSystem1.getAverageTime("V","K")); // 184
        undergroundSystem1.checkOut(6,"W8",485);
        System.out.println(undergroundSystem1.getAverageTime("U","S")); // 3
        undergroundSystem1.checkOut(7,"V6",516);
        undergroundSystem1.checkIn(8,"9G",533);
    }
}
