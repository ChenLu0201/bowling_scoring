package bowling;

import bowling.Exception.ScoreFormatException;
import bowling.module.FrameScore;
import bowling.service.InputScoreScanner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InputScannerTest {

    private InputScoreScanner scanner = new InputScoreScanner();

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenIllegalInput() throws Exception {
        thrown.expect(ScoreFormatException.class);
        scanner.scan("1 as 3 4");
    }

    @Test
    public void shouldGetScoresWithNoBonus() throws Exception {
        List<FrameScore> scores = scanner.scan("1 2 3 4");
        assertThat(scores.size(), is(2));
        assertThat(scores.get(0), is(equalTo(new FrameScore(1, 2))));
        assertThat(scores.get(1), is(equalTo(new FrameScore(3, 4))));
    }

    @Test
    public void shouldGetScoresWithStrikes() throws Exception {
        List<FrameScore> scores = scanner.scan("1 2 3 4 10 5 5 10 8");
        assertThat(scores.size(), is(6));
        assertThat(scores.get(0), is(equalTo(new FrameScore(1, 2))));
        assertThat(scores.get(1), is(equalTo(new FrameScore(3, 4))));
        assertThat(scores.get(2), is(equalTo(new FrameScore(10, 0))));
        assertThat(scores.get(3), is(equalTo(new FrameScore(5, 5))));
        assertThat(scores.get(4), is(equalTo(new FrameScore(10, 0))));
        assertThat(scores.get(5), is(equalTo(new FrameScore(8, 0))));
    }

    @Test
    public void shouldThrowExceptionWhenScoreExceeds10() throws Exception {
        thrown.expect(ScoreFormatException.class);
        scanner.scan("1 2 3 4 10 5 6 10");
    }

    @Test
    public void shouldGetExtraRollForLastFrame() throws Exception {
        List<FrameScore> scores = scanner.scan("1 2 3 4 10 5 5 10 8 0 10 6 3 10 10 10 8");
        assertThat(scores.size(), is(10));
        assertThat(scores.get(0), is(equalTo(new FrameScore(1, 2))));
        assertThat(scores.get(1), is(equalTo(new FrameScore(3, 4))));
        assertThat(scores.get(2), is(equalTo(new FrameScore(10, 0))));
        assertThat(scores.get(3), is(equalTo(new FrameScore(5, 5))));
        assertThat(scores.get(4), is(equalTo(new FrameScore(10, 0))));
        assertThat(scores.get(5), is(equalTo(new FrameScore(8, 0))));
        assertThat(scores.get(6), is(equalTo(new FrameScore(10, 0))));
        assertThat(scores.get(7), is(equalTo(new FrameScore(6, 3))));
        assertThat(scores.get(8), is(equalTo(new FrameScore(10, 0))));
        assertThat(scores.get(9), is(equalTo(new FrameScore(10, 10, 8))));
        assertThat(scores.get(9).isFinalRoll(), is(true));
    }
}
