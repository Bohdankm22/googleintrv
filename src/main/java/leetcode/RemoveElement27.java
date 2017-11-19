package leetcode;

/**
 * Got the problem from https://leetcode.com/problems/remove-element/description/
 *
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int end = nums.length - 1;
            for (int i = 0; i <= end; i++) {
                if (nums[i] == val) {
                    while(end >= i) {
                        if (nums[end--] != val) {
                            nums[i] = nums[end + 1];
                            break;
                        }
                    }
                }
            }
            return end + 1;
        }
    }
}

