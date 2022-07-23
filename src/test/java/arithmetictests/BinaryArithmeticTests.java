package arithmetictests;

import arithmetics.BinaryArithmetic;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class BinaryArithmeticTests {
    private final BinaryArithmetic ba = new BinaryArithmetic();

    @Test
    public void convertBinaryToDecimal() {
        var result = ba.binaryStringToDecimal("1001");
        Assertions.assertEquals(9, result);
    }
    @Test
    public void convertInvalidBinaryToDecimal() {
        var result = ba.binaryStringToDecimal("$");
        Assertions.assertEquals(-1, result);
    }
    @Test
    public void convertDecimalToBinary() {
        var result = ba.decimalToBinaryString(9);
        Assertions.assertEquals("1001", result);
    }
    @Test
    public void convertDecimal0ToBinary() {
        var result = ba.decimalToBinaryString(0);
        Assertions.assertEquals("0", result);
    }
    @Test
    public void convertInvalidDecimalToBinary() {
        var result = ba.decimalToBinaryString(-1);
        Assertions.assertEquals("Invalid", result);
    }
    @Test
    public void addDecimalsInBase2() {
        var result = ba.addDecimalStrings("1001", "1111", 2);
        Assertions.assertEquals("11000", result);
    }
    @Test
    public void addDecimalsInBase3() {
        var result = ba.addDecimalStrings("1", "2", 3);
        Assertions.assertEquals("10", result);
    }
    @Test
    public void addDecimalsInBase4() {
        var result = ba.addDecimalStrings("3", "2", 4);
        Assertions.assertEquals("11", result);
    }
    @Test
    public void addDecimalsInBase5() {
        var result = ba.addDecimalStrings("44", "4", 5);
        Assertions.assertEquals("103", result);
    }
    @Test
    public void addDecimalsInBase6() {
        var result = ba.addDecimalStrings("4", "5", 6);
        Assertions.assertEquals("13", result);
    }
    @Test
    public void addDecimalsInBase7() {
        var result = ba.addDecimalStrings("42", "51", 7);
        Assertions.assertEquals("123", result);
    }
    @Test
    public void addDecimalsInBase8() {
        var result = ba.addDecimalStrings("111", "72", 8);
        Assertions.assertEquals("203", result);
    }
    @Test
    public void addDecimalsInBase9() {
        var result = ba.addDecimalStrings("1000", "100", 9);
        Assertions.assertEquals("1100", result);
    }
    @Test
    public void addDecimalsInBase10() {
        var result = ba.addDecimalStrings("10000", "445", 10);
        Assertions.assertEquals("10445", result);
    }
    @Test
    public void subtractUnsignedBinaries() {
        var result = ba.subtractUnsignedBinaryInts("1101", "00111");
        Assertions.assertEquals("100110", result);
    }
    @Test
    public void subtractInvalidUnsignedBinaries() {
        var result = ba.subtractUnsignedBinaryInts("$", "&");
        Assertions.assertEquals("Invalid", result);
    }
}
