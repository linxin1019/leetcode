package org.top150;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * */
public class DecodeString {

    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> multiplierStack = new Stack<>();

        String result =  "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count*10 + (s.charAt(i) - '0');
                    i++;
                }
                multiplierStack.push(count);
            } else if ('[' == s.charAt(i)) {
                strStack.push(result);
                result = "";
                i++;
            } else if (']' == s.charAt(i)) {
                int multiplier = multiplierStack.pop();
                StringBuilder stringBuilder = new StringBuilder(strStack.pop());
                while (multiplier > 0) {
                    stringBuilder.append(result);
                    multiplier--;
                }
                result = stringBuilder.toString();
                i++;
            } else {
                result +=s.charAt(i);
                i++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", decodeString("3[a2[c]]"));

        System.out.println(('1' - '0')*10 + 10);
    }
}
