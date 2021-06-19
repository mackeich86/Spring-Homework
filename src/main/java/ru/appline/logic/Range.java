package ru.appline.logic;

public class Range {
    private int minValue, maxValue;

    public Range(int minValue, int maxValue) {
        if (!isCorrect(minValue) || !isCorrect(maxValue))
            throw new IndexOutOfBoundsException();
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public boolean contains(int num) {
        if (!isCorrect(num))
            throw new IndexOutOfBoundsException();
        if (minValue < maxValue)
            return (minValue <= num && num <= maxValue);
        return (minValue <= num || num <= maxValue);
    }

    private boolean isCorrect(int num) {
        return (num >= 0 && num <= 359);
    }
}
