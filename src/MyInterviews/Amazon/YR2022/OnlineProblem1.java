package MyInterviews.Amazon.YR2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OnlineProblem1 {

    /*
        Determine the maximum number of teams that can be formed from the contestants given the array of skill.
        1. Each team will have exactly teamSize developers.
        2. A developer's skill level is denoted by skill[i]
        3. The difference between the maximum and minimum skill levels within a team cannot exceed a threshold maxDiff
        example skill [3, 4, 3, 1, 6, 5]
        teamSize = 3
        maxDiff = 2
        ass = 2 because [3, 3, 1] and [4, 6, 5] can be formed
     */


    public static int countMaximumTeams(List<Integer> skill, int teamSize, int maxDiff) {
        int ans = 0;
        Collections.sort(skill);
        int i = 0; int j = i + teamSize - 1;
        while (i < j && j < skill.size()) {
            if (skill.get(j) - skill.get(i) <= maxDiff) {
                ans++;
                i = j + 1;
            } else {
                i++;
            }
            j = i + teamSize - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> skill = new ArrayList<>(Arrays.asList(3, 4, 3, 1, 6, 5));
        int teamSize = 3;
        int maxDiff = 2;
        int ans = countMaximumTeams(skill, teamSize, maxDiff);
        System.out.println(ans);
    }
}
