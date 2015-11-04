package bowling;

public class FrameScore {
    private int firstRoll;
    private int secondRoll;
    private int extraRollOne;
    private int getExtraRollTwo;

    public FrameScore() {
    }

    public FrameScore(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
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

    public int getExtraRollOne() {
        return extraRollOne;
    }

    public void setExtraRollOne(int extraRollOne) {
        this.extraRollOne = extraRollOne;
    }

    public int getGetExtraRollTwo() {
        return getExtraRollTwo;
    }

    public void setGetExtraRollTwo(int getExtraRollTwo) {
        this.getExtraRollTwo = getExtraRollTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrameScore that = (FrameScore) o;

        if (firstRoll != that.firstRoll) return false;
        if (secondRoll != that.secondRoll) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstRoll;
        result = 31 * result + secondRoll;
        return result;
    }
}
