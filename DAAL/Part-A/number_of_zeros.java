/*
 * Implement a problem of number of zeroes.
Statement: Given an array of 1s and 0s which has all 1s first
followed by all 0s? Find the number of 0s. Count the number of
zeroes in the given array.
Input: arr[] = {1, 1, 1, 1, 0, 0} Output: 2
Input: arr[] = {1, 0, 0, 0, 0} Output: 4
 */
import java.util.*;
public class number_of_zeros {
    public static int binarysearch(int[] nums){
        int start=0,end=nums.length-1;
        int key=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==key){
                if(mid==0 || nums[mid-1]==1){
                    return mid;
                }
                end= mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void count_zero(int loc,int[] nums){
        //by linear serach TC is O(n) by binary it is O(log n)
        int len=nums.length;
        if(loc==-1){
            System.out.println("NO ZEROS IN THE ARRAY");
        }
        else{
            System.out.println("ZEROS are :"+(len-loc));}
    }
    public static void main(String[] args){
        int[] nums = {1, 1, 1, 1, 0, 0};
        int loc=binarysearch(nums);
        count_zero(loc, nums);

    }
}
