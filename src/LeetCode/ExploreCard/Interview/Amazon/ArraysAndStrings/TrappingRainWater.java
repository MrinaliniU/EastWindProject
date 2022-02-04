package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

/*
    My logic :
    At each index :
    1. find a number that is the closest to current index from left and is GREATER than current number.
    2. find a number that is the closest to current index from right and is GREATER than current number.
    3. The amount of water it can hold is Math.min(left_height, right_height) - My_height;
    4. if no left_height update My_height as left_height;
    5. if no right_height update My_height as right_height;
    Note1 : My Logic can be translated into below code, you have to think that this logic is being simultaneously
    executed from left-right and right-left.

 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0;
        int left_max = 0, right_max = 0, left = 0, right = height.length - 1;
        while (left < right){ // Note1
            if(height[left] < height[right]){ // Math.min(left_height, right_height)
                if(height[left] >= left_max) left_max = height[left]; // 4
                else ans += (left_max - height[left]); // 3
                left += 1;
            }else{
                if(height[right] >= right_max) right_max = height[right]; // 5
                else ans += (right_max - height[right]); // 3
                right -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        TrappingRainWater tp = new TrappingRainWater();
        System.out.println(tp.trap(new int[] {4,2,0,3,2,5}));
    }
}
