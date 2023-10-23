package org.top150;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int length = citations.length;
        // bucket sort
        // but with an extra bucket to store the paper with impossible h-index
        int[] bucket = new int[length+1];

        for (int c : citations) {
            if (c >= length) {
                bucket[length]++;
            } else {
                bucket[c]++;
            }
        }

        int count = 0;
        for (int i = length; i >= 0; i--) {
            count+=bucket[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
}
