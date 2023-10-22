package org.top150;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // farthest position reachable at each index
            nums[i] = Math.max(i + nums[i], nums[i - 1]);
        }
        int currentIndex = 0;
        int steps = 0;
        while (currentIndex < nums.length - 1) {
            steps++;
            currentIndex=nums[currentIndex];
        }
        return steps;
    }
}
