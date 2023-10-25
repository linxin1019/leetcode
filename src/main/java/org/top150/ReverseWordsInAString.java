package org.top150;

import java.util.ArrayList;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWordsInAString {
    // not gonna use split though i do not think it's worthy
    public String reverseWords(String s) {
        ArrayList<String> arrayList = new ArrayList();
        char[] chars = s.toCharArray();
        String s1 = "";
        for (int i = 0; i < chars.length; i++) {
            // get a space, means we should make a split
            if (chars[i] == ' ') {
                // exclude the continuous spaces situation
                if(!"".equals(s1)) arrayList.add(s1);
                // reset
                s1 = "";
            } else {
                // append the char at the current s1 string when it is not a space
                s1+=chars[i];
                // get to the very end of the string s and has no space left to determine a split
                if (i == chars.length-1) {
                    arrayList.add(s1);
                    s1 = "";
                }
            }
        }

        String result = "";
        // traverse from the end
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            result += arrayList.get(i) + " ";
        }
        return result.trim();
    }
}
