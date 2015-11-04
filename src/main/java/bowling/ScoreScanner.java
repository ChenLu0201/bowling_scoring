package bowling;

import bowling.Exception.ScoreFormatException;
import bowling.module.FrameScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luchen on 11/4/15.
 */
public class ScoreScanner {
    public List<FrameScore> scan(String scoreStr) throws ScoreFormatException {
        List<FrameScore> result = new ArrayList<FrameScore>();
        LinkedList<String> scores = new LinkedList<String>(Arrays.asList(scoreStr.split(Constants.SCORE_SPLITTER)));
        try {
            initFrameScore(result, scores);
        } catch (NumberFormatException e) {
            throw new ScoreFormatException("score string should like '1 2 3 4 10 1'", e);
        }
        return result;
    }

    private void initFrameScore(List<FrameScore> result, LinkedList<String> scores) throws ScoreFormatException {
        if (scores.isEmpty()) {
            return;
        }
        FrameScore score = new FrameScore(result.size() + 1 == Constants.TOTAL_FRAMES);
        int scoreOnFirstRound = Integer.valueOf(scores.poll());
        score.setFirstRoll(scoreOnFirstRound);
        if (scoreOnFirstRound != Constants.TEN_PINS && !scores.isEmpty()) {
            score.setSecondRoll(Integer.valueOf(scores.poll()));
        }
        if (score.isInvalidScore()) {
            throw new ScoreFormatException("The score exceeds 10 in one frame, first roll is " + score.getFirstRoll() + ", second roll is " + score.getSecondRoll(), null);
        }
        result.add(score);
        initFrameScore(result, scores);
    }

}
