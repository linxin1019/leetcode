package org.top150;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i = 0; i < stringBuilders.length; i++){
            stringBuilders[i] = new StringBuilder();
        }
        int rowIndex = 0;
        // here's the interesting part
        // the direction decides which way the next char goes to(vertically down or obliquely up)
        int direction = 1;
        // traverse the string, decide which row the current char belongs to
        for (char c : s.toCharArray()) {
            // when at the top go down, and as for the code, index increases
            if (rowIndex == 0) {
                direction = 1;
            }
            // when hit the bottom, go up
            if (rowIndex == numRows - 1) {
                direction = - 1;
            }
            stringBuilders[rowIndex].append(c);
            rowIndex+=direction;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            result.append(stringBuilders[i].toString());
        }
        return result.toString();
    }
}
