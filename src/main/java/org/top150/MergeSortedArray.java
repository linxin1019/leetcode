package org.top150;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order
 * , and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 */
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        m--;
        n--;
        // this function is more like merging nums2 into nums1,
        // so it's more reasonable and plausible to use num2's index to control the loop
        while(n>=0) {
            if (m >=0 && nums1[m] > nums2[n]) {
                nums1[lastIndex--] = nums1[m];
                m--;
            } else {
                nums1[lastIndex--] = nums2[n];
                n--;
            }
        }
    }
}