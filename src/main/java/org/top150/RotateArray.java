package org.top150;

/**
 * Given an integer array nums
 * , rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        // important to speed up and avoid indexOutOfBound
        k = k%length;

        int[] dummy = new int[length];

        for (int i=0 ;i < length; i++) {
            if ((i - k) < 0) {
                dummy[i] = nums[i + length - k];
            } else {
                dummy[i] = nums[i - k];
            }
        }

        for (int i = 0; i < length; i++) {
            nums[i] = dummy[i];
        }
    }
}
