import java.util.*;
/*Implement program to find all distinct subsets of a given set
using Bit Masking Approach.
Statement Given an array of integers arr[], The task is to find all
its subsets. The subset cannot contain duplicate elements, so any
repeated subset should be considered only once in the output.
Input: S = {1, 2, 2} Output: {}, {1}, {2}, {1, 2}, {2, 2}, {1, 2,2}
Input: S = {1, 2} Output: {}, {1}, {2}, {1, 2}
 */
public class BitMask_Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2};                      //INPUT
        
        List<String> subsets = findSubsets(arr);
        for (String subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<String> findSubsets(int[] nums) {
        Arrays.sort(nums);                      // Sort to handle duplicates
        Set<String> result = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder subset = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.append(nums[j]).append(",");
                }
            }
            result.add("{" + (subset.length() > 0 ? subset.substring(0, subset.length() - 1) : "") + "}");
        }
        return new ArrayList<>(result);
    }
}

//Time Complexity :  O(n * 2^n)
//Space Compleity :  O(2^n)


//TC & SC Explannation By ChatGPT
/*
Outer Loop
The outer loop runs from 0 to (1 << n) - 1, which is 2^n iterations. This is because there are 2^n possible subsets of a set with n elements.

Inner Loop
The inner loop runs n times for each iteration of the outer loop. In the worst case, it checks each bit of the integer i to determine if the corresponding element should be included in the current subset.

String Operations
The operations inside the inner loop involve appending elements to a StringBuilder and then converting it to a string. These operations are linear in the number of elements being appended.


Set Operations
Adding a string to the Set and converting the Set to a List at the end are both linear in the number of subsets, which is 2^n.

Overall Time Complexity
Combining these factors, the overall time complexity is:

Outer Loop: O(2^n)
Inner Loop: O(n)
String Operations: O(n) for each subset
Set Operations: O(2^n)
Thus, the overall time complexity is O(n * 2^n).

Space Complexity
The space complexity is determined by:

The space required to store all subsets in the Set, which is O(2^n) in the worst case.
The space required for the StringBuilder and the final List, which is also O(2^n).
Thus, the overall space complexity is O(2^n).
*/
