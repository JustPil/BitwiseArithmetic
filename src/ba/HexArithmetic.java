package ba;

import java.util.ArrayList;
import java.util.HashMap;

public class HexArithmetic
{
    private final int HEXADECIMAL_BASE = 16;
    private HashMap<Character, Integer> mapGetInt = new HashMap<>();
    private HashMap<Integer, Character> mapGetChar = new HashMap<>();

    /**
     * Constructor calls the populateMap method to populate the class's Map variables.
     */
    public HexArithmetic()
    {
        populateMap();
    }

    /**
     * hexToDecimal Accepts a string representing a hexadecimal number and returns its decimal conversion.
     * @param s The string representing a hexadecimal number.
     * @return The decimal conversion of the hexadecimal number.
     */
    public int hexToDecimal(String s)
    {
        int result = 0, counter = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            result += mapGetInt.get(s.charAt(i)) * Math.pow(HEXADECIMAL_BASE, counter++);
        }
        return result;
    }

    /**
     * decimalToHex Accepts a decimal number and returns its hexadecimal representation as a string.
     * @param dec The decimal number to convert.
     * @return A string containing the decimal number's hexadecimal conversion.
     */
    public String decimalToHex(int dec)
    {
        double d = Math.log(dec) / Math.log(HEXADECIMAL_BASE);
        final int SIZE = (int)d + 1;
        StringBuilder sb = new StringBuilder(SIZE);
        for(int i = 0; i < SIZE; i++)
        {
            sb.append(mapGetChar.get(dec % HEXADECIMAL_BASE));
        }
        return sb.reverse().toString();
    }

    /**
     * addHexStrings Accepts two strings representing hexadecimal numbers, returning a string containing their sum in
     * hexadecimal.
     * @param s1 The first string representing a hexadecimal number.
     * @param s2 The second string representing a hexadecimal number.
     * @return A string containing the sum of the first and second hexadecimal numbers.
     */
    public String addHexStrings(String s1, String s2)
    {
        if(s1.length() > s2.length())
        {
            s2 = padString(s2, s1.length());
        }
        if(s1.length() < s2.length())
        {
            s1 = padString(s1, s2.length());
        }
        int[] result = new int[s1.length()];
        int carry = 0;
        int digit;
        for(int i = s1.length() - 1; i >= 0; i--)
        {
            int first = mapGetInt.get(s1.charAt(i));
            int second = mapGetInt.get(s2.charAt(i));
            digit = first + second + carry;
            carry = digit / HEXADECIMAL_BASE;
            result[i] = digit % HEXADECIMAL_BASE;
        }
        StringBuilder sb = new StringBuilder(result.length);
        for(int val : result)
        {
            sb.append(mapGetChar.get(val));
        }
        if(carry > 0)
        {
            sb.reverse();
            sb.append(mapGetChar.get(carry));
        }
        return sb.reverse().toString();
    }

    /**
     * multiplyHex Accepts a hexadecimal number of a single character and a string representing a hexadecimal number of
     * any size up to 1000. The hexadecimal product of these numbers is calculated and returned as a string.
     * @param c A character representing a hexadecimal number of size 1.
     * @param s A string representing a hexadecimal number of any size up to 1000.
     * @return A string representing a hexadecimal product of the two input parameters.
     */
    public String multiplyHex(char c, String s)
    {
        int carry = 0;
        StringBuilder product = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = s.length() - 1; i >= 0; i--)
        {
            list.add((mapGetInt.get(s.charAt(i)) * mapGetInt.get(c) + carry) % HEXADECIMAL_BASE);
            carry = (mapGetInt.get(s.charAt(i)) * mapGetInt.get(c) + carry) / HEXADECIMAL_BASE;
        }
        list.add(carry);
        for (Integer integer : list)
        {
            product.append(mapGetChar.get(integer));
        }
        return product.reverse().toString();
    }

    /**
     * padString adds the character zero to an input string len times.
     * @param s The input string.
     * @param len The length that the string needs to reach.
     * @return The string with padded zero characters.
     */
    private String padString(String s, int len)
    {
        return String.format("%1$" + len + "s", s).replace(' ', '0');
    }

    /**
     * populateMap Populates the class's Map variables with hexadecimal characters and their decimal equivalents.
     */
    private void populateMap()
    {
        mapGetInt.put('0', 0); mapGetInt.put('1', 1); mapGetInt.put('2', 2); mapGetInt.put('3', 3);
        mapGetInt.put('4', 4); mapGetInt.put('5', 5); mapGetInt.put('6', 6); mapGetInt.put('7', 7);
        mapGetInt.put('8', 8); mapGetInt.put('9', 9); mapGetInt.put('A', 10); mapGetInt.put('B', 11);
        mapGetInt.put('C', 12); mapGetInt.put('D', 13); mapGetInt.put('E', 14); mapGetInt.put('F', 15);
        mapGetChar.put(0, '0'); mapGetChar.put(1, '1'); mapGetChar.put(2, '2'); mapGetChar.put(3, '3');
        mapGetChar.put(4, '4'); mapGetChar.put(5, '5'); mapGetChar.put(6, '6'); mapGetChar.put(7, '7');
        mapGetChar.put(8, '8'); mapGetChar.put(9, '9'); mapGetChar.put(10, 'A'); mapGetChar.put(11, 'B');
        mapGetChar.put(12, 'C'); mapGetChar.put(13, 'D'); mapGetChar.put(14, 'E'); mapGetChar.put(15, 'F');
    }
}
