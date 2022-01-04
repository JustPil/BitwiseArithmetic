# BitwiseArithmetic
Summary

Binary and Hexadecimal arithmetic implemented with digit by digit conversion rather than built-in binary library classes

Design

Binary Arithmetic

Supported arithmetic includes conversion of decimal number to binary, conversion of binary number to decimal, subtracting binary numbers, and adding any two numbers in base 2 through 10. These are done by way of implemented arithmetic rather than using the prebuilt libraries for binary conversion. Special considerations include maintaining a carry value with respect to the base, two's complement for subtraction, and padding numbers of unequal length.

Formulas Used

As Java has no base 2 calculator, the following formula is used to convert from base 10 to base 2: log2 (N) = log10 (N) / log10 (2)

To find the number of digits needed when converting a decimal number to binary, the following formula is used: size = log(2) N + 1

Hexadecimal Arithmetic

Hexadecimal arithmetic includes conversions from hexadecimal to decimal, decimal to hexadecimal, hexadecimal multiplication, and hexadecimal addition. HashMaps are used for efficient lookup times for hexadecimal characters and the values they represent.
