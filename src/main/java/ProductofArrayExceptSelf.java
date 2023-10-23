/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = 1;
        suffix[length - 1] = 1;
        // stores the product before index i
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        // stores the product after index i
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = prefix[i]*suffix[i];
        }
        return result;
    }
}
