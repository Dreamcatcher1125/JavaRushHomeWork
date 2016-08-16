package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number1 = new Number(NumerationSystemType._10, "6");
        Number result1 = convertNumberToOtherNumerationSystem(number1, NumerationSystemType._2);
        System.out.println("число " + number1.getDigit() + " в " + number1.getNumerationSystem().getNumerationSystemIntValue() + "ричной системе = " + result1);
        Number number2 = new Number(NumerationSystemType._8, "0123125467");
        Number result2 = convertNumberToOtherNumerationSystem(number2, NumerationSystemType._10);
        System.out.println("число " + number2.getDigit() + " в "  + number2.getNumerationSystem().getNumerationSystemIntValue() + "ричной системе = " + result2);
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String str = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, str);
    }
}
