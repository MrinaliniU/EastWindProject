package Notes.Arrays;

public class FindRightPlaceToAddASchedule {

    /*
        Given an array of tuples that represents a scheduled time
        for an event [(3, 4) (7, 8) (9, 10)] find the right place to insert a new schedule (1, 6) such that the array
        properties are maintained.
        Array Properties :
        * All schedules are valid i.e start time is less than end time where start and end is represented as a tuple
        (start, end.
        * All schedules in the array is sorted in ascending start times, hence end times.
        In case the new schedule (1, 6) overlaps a tuple (3, 4). You can merge these two to form a new tuple (1, 6).
        Final Array will hence look like [(1, 6) (7, 8) (9, 10)]
        ?? What if the array looked like this [(3, 4) (5, 8) (9, 10)] and new schedule was (1, 6) here the tuple
        overlaps two time schedules. How to handle this case?
     */

    public static void main(String[] args){

    }
}
