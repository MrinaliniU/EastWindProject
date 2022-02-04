package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

public class ContainerWithMostWater {
    /*
        Runtime: 2 ms
        Memory Usage: 39.5 MB
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return maxArea;
    }
    public static void main(String[] args){
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 8, 6, 12, 50, 4, 50, 3, 7};
        System.out.println("Max container " + cw.maxArea(height));
        System.out.println("Max container " + cw.maxArea(height2));
    }
}
