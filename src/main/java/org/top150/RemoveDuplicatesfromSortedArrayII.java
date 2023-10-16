package org.top150;

/**
 * Given an integer array nums sorted in non-decreasing order
 * , remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int lastElement = nums[0];
        int index = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != lastElement) {
                lastElement = nums[i];
                nums[index] = lastElement;
                index++;
                count = 1;
            } else if (++count <= 2) {
                nums[index] = lastElement;
                index++;
            }
        }
        return index;
    }
}
