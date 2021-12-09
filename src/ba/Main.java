package ba;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String choice = "";
        Scanner scn = new Scanner(System.in);
        BinaryArithmetic ba = new BinaryArithmetic();
        HexArithmetic ha = new HexArithmetic();
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nBinary and Hexadecimal Arithmetic\n1 - BINARY TO DECIMAL - Translate a binary number " +
                    "to decimal\n2 - DECIMAL TO BINARY - Translate a decimal number to binary\n3 - ADD DECIMALS IN" +
                    " BASE B - Perform addition on two decimals in base b where 2 <= b <= 10\n4 - SUBTRACT UNSIGNED" +
                    " BINARY NUMBERS - Perform subtraction on two unsigned binary numbers\n5 - HEXADECIMAL TO " +
                    "DECIMAL - Translate a hexadecimal number to decimal\n6 - DECIMAL TO HEXADECIMAL - Translate a" +
                    " decimal number to hexadecimal\n7 - ADD HEXADECIMALS - Perform addition on two hexadecimal " +
                    "numbers\n8 - MULTIPLY HEXADECIMALS - Perform multiplication on a first hexadecimal digit by a " +
                    "second hexadecimal number of multiple digits\nX - Terminate\n\nEnter choice: ");
            choice = scn.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter a binary sequence of bits: ");
                String input = scn.nextLine();
                boolean inputCheck = binaryInputCheck(input);
                while(!inputCheck)
                {
                    System.out.print("The binary sequence must contain only 1's and 0's. Re-enter: ");
                    input = scn.nextLine();
                    inputCheck = binaryInputCheck(input);
                }
                System.out.println("Binary: " + input + " Decimal: " + ba.binaryStringToDecimal(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter a decimal number: ");
                int input = scn.nextInt();
                System.out.println("Decimal: " + input + " Binary: " + ba.decimalToBinaryString(input));
                scn.nextLine();
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter the first decimal: ");
                String input1 = scn.nextLine();
                boolean inputCheck = decInputCheck(input1);
                while(!inputCheck)
                {
                    System.out.print("The input decimal must contain only numbers. Re-enter: ");
                    input1 = scn.nextLine();
                    inputCheck = decInputCheck(input1);
                }
                System.out.print("Enter the second decimal: ");
                String input2 = scn.nextLine();
                inputCheck = decInputCheck(input2);
                while(!inputCheck)
                {
                    System.out.print("The input decimal must contain only numbers. Re-enter: ");
                    input2 = scn.nextLine();
                    inputCheck = decInputCheck(input2);
                }
                System.out.print("Enter the base of the decimals: ");
                int base = scn.nextInt();
                System.out.println(input1 + " + " + input2 + " in base " + base + " = " +
                        ba.addDecimalStrings(input1, input2, base));
                scn.nextLine();
            }
            else if(choice.equals("4"))
            {
                System.out.print("Enter the first binary sequence of bits: ");
                String input1 = scn.nextLine();
                boolean inputCheck = binaryInputCheck(input1);
                while(!inputCheck)
                {
                    System.out.print("The binary sequence must contain only 1's and 0's. Re-enter: ");
                    input1 = scn.nextLine();
                    inputCheck = binaryInputCheck(input1);
                }
                System.out.print("Enter the second binary sequence of bits: ");
                String input2 = scn.nextLine();
                inputCheck = binaryInputCheck(input2);
                while(!inputCheck)
                {
                    System.out.print("The binary sequence must contain only 1's and 0's. Re-enter: ");
                    input2 = scn.nextLine();
                    inputCheck = binaryInputCheck(input2);
                }
                System.out.println(input1 + " - " + input2 + " = " + ba.subtractUnsignedBinaryInts(input1, input2));
            }
            else if(choice.equals("5"))
            {
                System.out.print("Enter a hexadecimal number: ");
                String input = scn.nextLine();
                boolean inputCheck = hexInputCheck(input);
                while(!inputCheck)
                {
                    System.out.print("The hexadecimal number must contain only digits 1 - 9 and A - F. Re-enter: ");
                    input = scn.nextLine();
                    inputCheck = hexInputCheck(input);
                }
                System.out.println("Hexadecimal: " + input + " Decimal: " + ha.hexToDecimal(input.toUpperCase()));
            }
            else if(choice.equals("6"))
            {
                System.out.print("Enter a decimal number: ");
                int input = scn.nextInt();
                System.out.println("Decimal: " + input + " Hexadecimal: " + ha.decimalToHex(input));
                scn.nextLine();
            }
            else if(choice.equals("7"))
            {
                System.out.print("Enter the first hexadecimal number: ");
                String input1 = scn.nextLine();
                boolean inputCheck = hexInputCheck(input1);
                while(!inputCheck)
                {
                    System.out.print("The hexadecimal number must contain only digits 1 - 9 and A - F. Re-enter: ");
                    input1 = scn.nextLine();
                    inputCheck = hexInputCheck(input1);
                }
                System.out.print("Enter the second hexadecimal number: ");
                String input2 = scn.nextLine();
                inputCheck = hexInputCheck(input2);
                while(!inputCheck)
                {
                    System.out.print("The hexadecimal number must contain only digits 1 - 9 and A - F. Re-enter: ");
                    input2 = scn.nextLine();
                    inputCheck = hexInputCheck(input2);
                }
                System.out.println(input1 + " + " + input2 + " = " +
                        ha.addHexStrings(input1.toUpperCase(), input2.toUpperCase()));
            }
            else if(choice.equals("8"))
            {
                System.out.print("Enter a single hexadecimal digit: ");
                String input1 = scn.nextLine();
                char digit = input1.charAt(0);
                boolean inputCheck = hexInputCheck(digit);
                while(!inputCheck)
                {
                    System.out.print("The hexadecimal number must contain only digits 1 - 9 or A - F. Re-enter: ");
                    input1 = scn.nextLine();
                    digit = input1.charAt(0);
                    inputCheck = hexInputCheck(digit);
                }
                System.out.print("Enter the second hexadecimal number: ");
                String input2 = scn.nextLine();
                inputCheck = hexInputCheck(input2);
                while(!inputCheck)
                {
                    System.out.print("The hexadecimal number must contain only digits 1 - 9 and A - F. Re-enter: ");
                    input2 = scn.nextLine();
                    inputCheck = hexInputCheck(input2);
                }
                System.out.println(input1.charAt(0) + " * " + input2 + " = " +
                        ha.multiplyHex(input1.toUpperCase().charAt(0), input2.toUpperCase()));
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * binaryInputCheck Checks if the input parameter contains only binary characters.
     * @param s The input string.
     * @return True if the string contains only binary characters, false otherwise.
     */
    public static boolean binaryInputCheck(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != '0' && s.charAt(i) != '1')
            {
                return false;
            }
        }
        return true;
    }

    /**
     * hexInputCheck Checks if the input parameter contains only hexadecimal characters.
     * @param s The input string.
     * @return True if the string contains only hexadecimal characters, false otherwise.
     */
    public static boolean hexInputCheck(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57) || (s.charAt(i) >= 65 && s.charAt(i) <= 70) ||
                    (s.charAt(i) >= 97 && s.charAt(i) <= 102))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    /**
     * hexInputCheck Overloaded method to check if a single character parameter is a valid hexadecimal character.
     * @param c The input character.
     * @return True if the character is a valid hexadecimal character, false otherwise.
     */
    public static boolean hexInputCheck(char c)
    {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 70) || (c >= 97 && c <= 102);
    }

    /**
     * decInputCheck Checks if the input parameter contains only decimal characters.
     * @param s The input string.
     * @return True if the string contains only decimal characters, false otherwise.
     */
    public static boolean decInputCheck(String s)
    {
        try
        {
            int num = Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}
