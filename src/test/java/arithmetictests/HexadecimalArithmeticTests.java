package arithmetictests;

import arithmetics.HexadecimalArithmetic;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class HexadecimalArithmeticTests {
    private final HexadecimalArithmetic ha = new HexadecimalArithmetic();

    @Test
    public void convertHexadecimalToDecimal() {
        var result = ha.hexToDecimal("F5C");
        Assertions.assertEquals(3932, result);
    }

    @Test
    public void convertInvalidHexadecimalToDecimal() {
        var result = ha.hexToDecimal("***");
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void convertDecimalToHexadecimal() {
        var result = ha.decimalToHex(3932);
        Assertions.assertEquals("F5C", result);
    }

    @Test
    public void addHexadecimalsEvenLength() {
        var result = ha.addHexStrings("F2B", "8E3");
        Assertions.assertEquals("180E", result);
    }

    @Test
    public void addHexadecimalsUnevenLength() {
        var result = ha.addHexStrings("F2BC4", "8E3");
        Assertions.assertEquals("F34A7", result);
    }

    @Test
    public void addInvalidHexadecimals() {
        var result = ha.addHexStrings("***", "***");
        Assertions.assertEquals("invalid", result);
    }

    @Test
    public void multiplyHexadecimals() {
        var result = ha.multiplyHex('F', "8E3");
        Assertions.assertEquals("854D", result);
    }

    @Test
    public void multiplyInvalidHexadecimals() {
        var result = ha.multiplyHex('*', "***");
        Assertions.assertEquals("invalid", result);
    }
}
