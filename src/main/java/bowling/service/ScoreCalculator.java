package bowling.service;

import bowling.module.FrameScore;

import java.util.List;

public class ScoreCalculator {

    private List<FrameScore> frameScores;

    private int totalScore = 0;

    public ScoreCalculator(List<FrameScore> frameScores) {
        this.frameScores = frameScores;
    }

    public int getTotalScore() {
        for (int i = 0; i < frameScores.size(); i++) {
            totalScore += frameScores.get(i).getTotalScore(frameScores, i);
        }
        return totalScore;
    }
}
