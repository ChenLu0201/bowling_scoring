package bowling.module;

import static bowling.Constants.TEN_PINS;

public class FrameScore {
    private int firstRoll;
    private int secondRoll;
    private int extraRoll;
    private boolean finalRoll;

    public FrameScore() {
    }

    public FrameScore(boolean finalRoll) {
        this.finalRoll = finalRoll;
    }

    public FrameScore(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public FrameScore(int firstRoll, int secondRoll, int extraRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.extraRoll = extraRoll;
    }

    public boolean isInvalidScore() {
        return firstRoll > TEN_PINS || secondRoll > TEN_PINS || extraRoll > TEN_PINS
                || (firstRoll + secondRoll > TEN_PINS && !finalRoll);
    }

    public int basicScore() {
        return firstRoll + secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getExtraRoll() {
        return extraRoll;
    }

    public void setExtraRoll(int extraRoll) {
        this.extraRoll = extraRoll;
    }

    public boolean isFinalRoll() {
        return finalRoll;
    }

    public void setFinalRoll(boolean finalRoll) {
        this.finalRoll = finalRoll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrameScore that = (FrameScore) o;

        if (firstRoll != that.firstRoll) return false;
        if (secondRoll != that.secondRoll) return false;
        if (extraRoll != that.extraRoll) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstRoll;
        result = 31 * result + secondRoll;
        return result;
    }

    @Override
    public String toString() {
        return "FrameScore{" +
                "firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
                ", extraRoll=" + extraRoll +
                ", finalRoll=" + finalRoll +
                '}';
    }
}
