package MyInterviews.Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeirdFaculty {

    public static int exam(List<Integer> v){
        int myScore = 0;
        int k = 0;
        int index = 0;
        int myFriendScore = score(v);
        while(myScore <= myFriendScore && index < v.size()){
            k++;
            if(v.get(index) == 1){
                myScore++;
                myFriendScore--;
            }else{
                myScore--;
                myFriendScore++;
            }
            index++;
        }
        return k;
    }

    public static int score(List<Integer> v){
        int count = 0;
        for(int i : v){
            if(i == 1) count++;
            else count--;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args){
        //List<Integer> v = new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0));
        //List<Integer> v = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1));
        List<Integer> v = new ArrayList<>(Arrays.asList(0,1,1,
                0,
                0,
                0,
                0,
                0,
                0,
                1,
                1,
                1,0
                ,1
                ,0
                ,0
                ,0
                ,0
                ,0
                ,1
                ,0
                ,1
                ,0
                ,0
                ,1
                ,0
                ,1
                ,0
                ,1
                ,1
                ,0
                ,1
                ,0
                ,0
                ,1
                ,1
                ,0
                ,0
                ,0
                ,0
                ,1
                ,0
                ,1
                ,1
                ,1
                ,0
                ,1
                ,1
                ,1
                ,1
                ,0
                ,1
                ,1
                ,1
                ,1
                ,0
                ,0
                ,0
                ,1
                ,0
                ,0
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1
                ,1));
        System.out.println("Min number of questions " + exam(v));
    }
}
