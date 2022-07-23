package arithmetics;

public class BinaryArithmetic {
    private final int BINARY_BASE = 2;

    /**
     * binaryStringToDecimal Accepts a string representing a binary number and calculates its decimal conversion.
     * @param s A string representing a binary number.
     * @return The decimal conversion of a binary number.
     */
    public int binaryStringToDecimal(String s) {
        int result = 0;
        int counter = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                result += Math.pow(BINARY_BASE, counter++);
            } else if(s.charAt(i) == '0') {
                counter++;
            } else {
                return -1;
            }
        }
        return result;
    }

    /**
     * decimalToBinaryString Accepts a decimal number and converts to a string of binary numbers.
     *
     * @param dec The decimal number for binary conversion.
     * @return A string containing the binary representation of the decimal.
     */
    public String decimalToBinaryString(int dec) {
        if(dec < 0) {
            return "Invalid";
        } else if(dec == 0) {
            return "0";
        }
        double d = Math.log(dec) / Math.log(BINARY_BASE);
        final int SIZE = (int) d + 1;
        int[] arr = new int[SIZE];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = dec % BINARY_BASE;
            dec = dec / BINARY_BASE;
        }
        StringBuilder sb = new StringBuilder(SIZE);
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * addDecimalStrings Accepts two strings representing decimal numbers and an integer base. The two string
     * representations of decimals are added in the specified base.
     *
     * @param s1 The first string representing a decimal number.
     * @param s2 The second string representing a decimal number.
     * @param base The base of the numbers.
     * @return A string containing the decimal representation of the addition.
     */
    public String addDecimalStrings(String s1, String s2, int base) {
        if(base < 2 || base > 10) {
            throw new IllegalArgumentException("Base must be between 2 and 10 inclusive.");
        }
        if(s1.length() > s2.length()) {
            s2 = padString(s2, s1.length());
        }
        if(s1.length() < s2.length()) {
            s1 = padString(s1, s2.length());
        }
        int[] result = new int[s1.length()];
        int carry = 0;
        for(int i = s1.length() - 1; i >= 0; i--) {
            result[i] = ((s1.charAt(i) - '0') + (s2.charAt(i) - '0') + carry) % base;
            carry = ((s1.charAt(i) - '0') + (s2.charAt(i) - '0') + carry) / base;
        }
        StringBuilder sb = new StringBuilder(result.length);
        if(carry > 0) {
            sb.append(carry);
        }
        for(int val : result) {
            sb.append(val);
        }
        return sb.toString();
    }

    /**
     * subtractUnsignedBinaryInts Accepts two strings representing binary numbers. The numbers are subtracted and its
     * binary difference is returned as a string.
     *
     * @param b1 A string representing the first binary number.
     * @param b2 A string representing the second binary number.
     * @return A string representing the difference of the first and second binary numbers.
     */
    public String subtractUnsignedBinaryInts(String b1, String b2) {
        StringBuilder inverse = new StringBuilder(b2.length());
        for(int i = 0; i < b2.length(); i++) {
            if(b2.charAt(i) == '1') {
                inverse.append('0');
            } else if(b2.charAt(i) == '0') {
                inverse.append('1');
            } else {
                return "Invalid";
            }
        }
        String twosComp = addDecimalStrings(inverse.toString(), "1", 2);
        return addDecimalStrings(b1, twosComp, 2);
    }

    /**
     * padString adds the character zero to an input string len times.
     *
     * @param s The input string.
     * @param len The length that the string needs to reach.
     * @return The string with padded zero characters.
     */
    private String padString(String s, int len) {
        return String.format("%1$" + len + "s", s).replace(' ', '0');
    }
}
