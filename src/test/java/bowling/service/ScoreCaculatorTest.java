package bowling.service;

import bowling.module.FrameScore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScoreCaculatorTest {
    @Test
    public void shouldGetScoreWithNoBonus() throws Exception {
        List<FrameScore> frameScores = new ArrayList<FrameScore>();
        frameScores.add(new FrameScore(1, 2));
        frameScores.add(new FrameScore(3, 4));
        assertThat(new ScoreCaculator(frameScores).getTotalScore(), is(10));
    }

}