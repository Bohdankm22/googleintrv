package leetcode;

/**
 * Got the problem from leetcode https://leetcode.com/problems/implement-strstr/description/
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;
            if (haystack.length() == 0) return -1;
            char[] c1 = haystack.toCharArray();
            char[] c2 = needle.toCharArray();
            for (int i = 0; i <= c1.length - c2.length; i++) {
                if(c1[i] == c2[0]) {
                    for (int j = 0; j < c2.length; j++) {
                        if(c1[i + j] != c2[j]) break;
                        if (j == c2.length - 1) return i;
                    }
                }
            }
            return -1;
        }
    }
}
