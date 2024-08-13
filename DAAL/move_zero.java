/*Implement a problem of move all zeroes to end of array.
Statement: Given an array of random numbers, Push all the zero’s
of a given array to the end of the array. For example, if the given
arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1,
9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be
same.
Input : arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};
*/

import java.util.*;
public class move_zero {
    public static int[] movezeros(int[] nums){
        int len=nums.length;
        //int[] answer = new int[len];   causing increase in space complexity O(n) now it is O(1)
        int index=0;
        int count=0;
        for(int i=0;i<len;i++){
            if (nums[i]==0){
                count++;
            }
            else{
                nums[index] = nums[i];
                index++;
            }
        }
        while(count>0){
            nums[index]=0;
            index++;
            count--;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums={1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        System.out.println(Arrays.toString(movezeros(nums)));
        int[] nums1={1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println(Arrays.toString(movezeros(nums1)));
    }
}