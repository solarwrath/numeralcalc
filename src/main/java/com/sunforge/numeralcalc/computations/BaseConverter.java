package com.sunforge.numeralcalc.computations;

public class BaseConverter {
    public static int convertToBase10(int givenInteger, int givenBase) {
        int result = 0;
        int counter = 0;

        //See converting to base10
        while (givenInteger >= 1) {
            result += (int) (Math.pow(givenBase, counter) * (givenInteger % 10));
            givenInteger /= 10;
            counter++;
        }
        return result;
    }

    public static int convertFromBase10(int givenInteger, int givenBase) {
        int result = 0, currentDiv = 0;

        //Divide and get mods
        while (givenInteger >= givenBase) {
            currentDiv = Math.floorDiv(givenInteger, givenBase);
            result = result * 10 + (givenInteger - (currentDiv * givenBase));
            givenInteger = currentDiv;
        }
        //Append the latest mod
        result = result * 10 + currentDiv;
        return reverseNumber(result);
    }

    private static int reverseNumber(int givenNumber) {
        int reversed = 0;
        while (givenNumber > 0) {
            reversed = reversed * 10 + givenNumber % 10;
            givenNumber = Math.floorDiv(givenNumber, 10);
        }
        return reversed;
    }
}
