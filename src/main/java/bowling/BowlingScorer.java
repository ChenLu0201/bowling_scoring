package bowling;

import bowling.exception.ScoreFormatException;
import bowling.service.InputScoreScanner;
import bowling.service.ScoreCalculator;

public class BowlingScorer {

    public int getScore(String scoresStr) throws ScoreFormatException {
        return new ScoreCalculator(new InputScoreScanner().scan(scoresStr)).getTotalScore();
    }
}
