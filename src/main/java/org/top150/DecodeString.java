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
        int multiplier = 0;
        Stack<String> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            // indicates the block should come to an end
            if ("]".equals(String.valueOf(s.charAt(i)))) {
                StringBuilder temp = new StringBuilder();
                while (!"[".equals(stack.peek())) {
                    temp.insert(0, stack.pop());
                }
                // pop the '['
                stack.pop();
                // pop the multiplier
                multiplier = Integer.valueOf(stack.pop());
                // generate the decoded string
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < multiplier; j++) {
                    stringBuilder.append(temp);
                }
                stack.push(stringBuilder.toString());
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }
}
