package com.sunforge.numeralcalc.computations;


import static com.sunforge.numeralcalc.computations.BaseConverter.convertFromBase10;
import static com.sunforge.numeralcalc.computations.BaseConverter.convertToBase10;

public class MainHandler {

    public static int compute(int number1, int base1, int number2, int base2, Operation requestedOperation) {
        int number1InBase10 = convertToBase10(number1, base1);
        int number1Converted = convertFromBase10(number1InBase10, base2);
        return 0;
    }
}
