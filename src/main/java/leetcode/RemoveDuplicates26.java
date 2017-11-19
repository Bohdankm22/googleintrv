package leetcode;

/**
 * Got the Problem from https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 */
public class RemoveDuplicates26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int maxNum = nums[0];
            int count = 1;
            int position = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > maxNum) {
                    nums[++position] = nums[i];
                    maxNum = nums[i];
                    count++;
                }
            }
            return count;
        }
    }
}
