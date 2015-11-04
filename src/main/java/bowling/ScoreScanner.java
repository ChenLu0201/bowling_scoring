package bowling;

import bowling.Exception.ScoreFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luchen on 11/4/15.
 */
public class ScoreScanner {
    private final String SCORE_SPLITTER = " ";
    private final int STRIKE_SCORE = 10;

    public List<FrameScore> scan(String scoreStr) throws ScoreFormatException {
        List<FrameScore> result = new ArrayList<FrameScore>();
        LinkedList<String> scores = new LinkedList<String>(Arrays.asList(scoreStr.split(SCORE_SPLITTER)));
        try {
            initFrameScore(result, scores);
        } catch (NumberFormatException e) {
            throw new ScoreFormatException("score string should like '1 2 3 4 10 1'", e);
        }
        return result;
    }

    private void initFrameScore(List<FrameScore> result, LinkedList<String> scores) {
        if (scores.isEmpty()) {
            return;
        }
        FrameScore score = new FrameScore();
        int scoreOnFirstRound = Integer.valueOf(scores.poll());
        score.setFirstRoll(scoreOnFirstRound);
        if (scoreOnFirstRound != STRIKE_SCORE) {
            score.setSecondRoll(Integer.valueOf(scores.poll()));
        }
        result.add(score);
        initFrameScore(result, scores);
    }
}
