package bowling;

import java.util.*;

/**
 * Created by luchen on 11/4/15.
 */
public class ScoreScanner {
    private final String SCORE_SPLITTER = " ";
    private final int STRIKE_SCORE = 10;

    public List<FrameScore> scan(String scoreStr) {
        List<FrameScore> result = new ArrayList<FrameScore>();
        LinkedList<String> scores = new LinkedList<String>(Arrays.asList(scoreStr.split(SCORE_SPLITTER)));
        initFrameScore(result, scores);
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
