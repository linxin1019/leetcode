package org.top150;

/**
 * https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        // double points at both sides of the array
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxHeightLeft = 0;
        int maxHeightRight = 0;
        int result = 0;
        while (leftIndex < rightIndex) {
            // it depends on the lower side to decide how much water to trap
            if (height[leftIndex] <= height[rightIndex]) {
                // no way to trap water between current index and next index since the height gets bigger
                if (height[leftIndex] >= maxHeightLeft) {
                    // so update the lower side
                    maxHeightLeft = height[leftIndex];
                } else {
                    // able to trap since the height goes down
                    result += maxHeightLeft - height[leftIndex];
                }
                leftIndex++;
            } else {
                if (height[rightIndex] >= maxHeightRight) {
                    maxHeightRight = height[rightIndex];
                } else {
                    result += maxHeightRight - height[rightIndex];
                }
                rightIndex--;
            }
        }
        return result;
    }
}
