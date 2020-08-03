package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    private int numberOfEven;
    private int numberOfPositive;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
        for (int number : numbers) {
            if (number % 2 == 0) {
                numberOfEven += 1;
            }
            if (number >= 0) {
                numberOfPositive += 1;
            }
        }
    }

    public int countEven() {
        return numberOfEven;
    }

    public int countOdd() {
        return numbers.length - numberOfEven;
    }

    public int countPositive() {
        return numberOfPositive;
    }

    public int countNegative() {
        return numbers.length - numberOfPositive;
    }
}
