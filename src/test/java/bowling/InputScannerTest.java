package bowling;

import bowling.Exception.ScoreFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InputScannerTest {

    private ScoreScanner sanner = new ScoreScanner();

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenIllegalInput() throws Exception {
        thrown.expect(ScoreFormatException.class);
        sanner.scan("1 as 3 4");
    }

    @Test
    public void shouldGetScoresWithNoBonus() throws Exception {
        List<FrameScore> scores = sanner.scan("1 2 3 4");
        assertThat(scores.size(), is(2));
        assertThat(scores.get(0), is(equalTo(new FrameScore(1, 2))));
        assertThat(scores.get(1), is(equalTo(new FrameScore(3, 4))));
    }
}
