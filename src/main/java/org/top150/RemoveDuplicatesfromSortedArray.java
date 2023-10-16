package org.top150;

/**
 * Given an integer array nums sorted in non-decreasing order
 * , remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int lastElement = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastElement) {
                lastElement = nums[i];
                nums[index] = lastElement;
                index++;
            }
        }
        return index;
    }
}
