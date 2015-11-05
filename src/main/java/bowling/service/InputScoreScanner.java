package bowling.service;

import bowling.Constants;
import bowling.exception.ScoreFormatException;
import bowling.module.FrameScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InputScoreScanner {
    public List<FrameScore> scan(String scoreStr) throws ScoreFormatException {
        List<FrameScore> result = new ArrayList<FrameScore>();
        LinkedList<String> scores = new LinkedList<String>(Arrays.asList(scoreStr.split(Constants.SCORE_SPLITTER)));
        try {
            initFrameScores(result, scores);
        } catch (NumberFormatException e) {
            throw new ScoreFormatException("score string should like '1 2 3 4 10 1'", e);
        }
        return result;
    }

    private void initFrameScores(List<FrameScore> result, LinkedList<String> scores) throws ScoreFormatException {
        if (scores.isEmpty()) {
            return;
        }
        FrameScore score = initFrameScore(result, scores);
        result.add(score);
        initFrameScores(result, scores);
    }

    private FrameScore initFrameScore(List<FrameScore> result, LinkedList<String> scores) throws ScoreFormatException {
        FrameScore score = new FrameScore(result.size() + 1 == Constants.TOTAL_FRAMES);
        score.setFirstRoll(pollInteger(scores));
        if (score.isFinalFrame()) {
            score.setSecondRoll(pollInteger(scores));
            score.setExtraRoll(pollInteger(scores));

        } else {
            if (score.getFirstRoll() != Constants.TEN_PINS) {
                score.setSecondRoll(pollInteger(scores));
            }

        }
        validateFrameScore(score);
        return score;
    }

    private void validateFrameScore(FrameScore score) throws ScoreFormatException {
        if (score.isInvalidScore()) {
            throw new ScoreFormatException("The score exceeds 10 in one frame, first roll is " + score.getFirstRoll() + ", second roll is " + score.getSecondRoll(), null);
        }
    }

    private Integer pollInteger(LinkedList<String> scores) {
        if (!scores.isEmpty()) {
            return Integer.valueOf(scores.poll());
        }
        return Integer.valueOf(0);
    }

}
