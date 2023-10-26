package org.top150;

import org.junit.Test;

/**
 * Given two strings needle and haystack,
 * return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int result = -1;
        int indexForNeedle = 0;

        char[] hayStackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        int needleLen = needle.length();
        // kind of slide window
        int startIndex = 0;
        int endIndex = needleLen - 1;

        while (endIndex < haystack.length()) {
            for (int i = startIndex; i < needleLen + startIndex; i++) {
                if (needleChars[indexForNeedle] == hayStackChars[i]) {
                    if (i == needleLen + startIndex - 1) {
                        return startIndex;
                    }
                    indexForNeedle++;
                } else {
                    indexForNeedle = 0;
                    startIndex++;
                    endIndex++;
                    break;
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
