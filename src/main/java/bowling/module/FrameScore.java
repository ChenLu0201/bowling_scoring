package bowling.module;

import java.util.List;

import static bowling.Constants.TEN_PINS;

public class FrameScore {
    private int firstRoll;
    private int secondRoll;
    private int extraRoll;
    private boolean finalFrame;

    public FrameScore() {
    }

    public FrameScore(boolean finalFrame) {
        this.finalFrame = finalFrame;
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

    public FrameScore(int firstRoll, int secondRoll, int extraRoll, boolean finalFrame) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.extraRoll = extraRoll;
        this.finalFrame = finalFrame;
    }

    public boolean isInvalidScore() {
        return firstRoll > TEN_PINS || secondRoll > TEN_PINS || extraRoll > TEN_PINS
                || (firstRoll + secondRoll > TEN_PINS && !finalFrame);
    }

    public boolean isStrike() {
        return firstRoll == TEN_PINS;
    }

    public boolean isSpare() {
        return !isStrike() && basicScore() == TEN_PINS;
    }

    public int basicScore() {
        return firstRoll + secondRoll + extraRoll;
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

    public boolean isFinalFrame() {
        return finalFrame;
    }

    public void setFinalFrame(boolean finalFrame) {
        this.finalFrame = finalFrame;
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
                ", finalFrame=" + finalFrame +
                '}';
    }

    public int getTotalScore(List<FrameScore> frameScores, int currentIndex) {
        int result = basicScore();
        if (isFinalFrame()) {
            return result;
        }
        currentIndex += 1;
        FrameScore nextFrameScore = nextFrameScore(frameScores, currentIndex);
        result += addBonus(frameScores, currentIndex, nextFrameScore);
        return result;
    }

    private int addBonus(List<FrameScore> frameScores, int currentIndex, FrameScore nextFrameScore) {
        int bonus = 0;
        if (isStrike()) {
            if (null != nextFrameScore) {
                bonus += nextFrameScore.getFirstRoll();
                if (nextFrameScore.isFinalFrame() || !nextFrameScore.isStrike()) {
                    bonus += nextFrameScore.getSecondRoll();
                } else {
                    nextFrameScore = nextFrameScore(frameScores, currentIndex + 1);
                    if (null != nextFrameScore) {
                        bonus += nextFrameScore.getFirstRoll();
                    }
                }
            }
        } else if (isSpare()) {
            if (null != nextFrameScore) {
                bonus += nextFrameScore.getFirstRoll();
            }
        }
        return bonus;
    }

    private FrameScore nextFrameScore(List<FrameScore> frameScores, int nextIndex) {
        if (frameScores.size() > nextIndex) {
            return frameScores.get(nextIndex);
        }
        return null;
    }
}
