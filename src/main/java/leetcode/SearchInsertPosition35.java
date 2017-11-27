package leetcode;

public class SearchInsertPosition35 {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0 || target < nums[0]) return 0;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int med = left + (right - left) / 2;
                if (nums[med] > target) {
                    right = med - 1;
                } else if (nums[med] < target) {
                    left = med + 1;
                } else {
                    return med;
                }
            }
            return right + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition35().new Solution().searchInsert(
                new int[]{1,3,5,6}, 0));
    }
}
