package bowling;

import bowling.exception.ScoreFormatException;
import bowling.service.InputScoreScanner;
import bowling.service.ScoreCaculator;

public class BowlingScorer {

    public int getScore(String scoresStr) throws ScoreFormatException {
        return new ScoreCaculator(new InputScoreScanner().scan(scoresStr)).getTotalScore();
    }
}
