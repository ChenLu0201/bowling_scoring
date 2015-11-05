package bowling;

import bowling.exception.ScoreFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BowlingScorerTest {

    private BowlingScorer bowlingScorer = new BowlingScorer();

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenIllegalNumberInputted() throws Exception {
        thrown.expect(ScoreFormatException.class);
        bowlingScorer.getScore("1 2 3 4 a 4 6");
    }

    @Test
    public void shouldThrowExceptionWhenIllegalFrameScoreInputted() throws Exception {
        thrown.expect(ScoreFormatException.class);
        bowlingScorer.getScore("1 2 3 4 10 4 7 10");
    }

    @Test
    public void shouldGetScoreWithNoBonus() throws Exception {
        assertThat(bowlingScorer.getScore("1 2 3 4"), is(10));
    }

    @Test
    public void shouldGetScoreWithSpareBonus() throws Exception {
        assertThat(bowlingScorer.getScore("9 1 9 1"), is(29));
    }

    @Test
    public void shouldGetScoreWithStrikeBonus() throws Exception {
        assertThat(bowlingScorer.getScore("1 1 1 1 10 1 1"), is(18));
    }

    @Test
    public void shouldGetFullScore() throws Exception {
        assertThat(bowlingScorer.getScore("10 10 10 10 10 10 10 10 10 10 10 10"), is(300));
    }
}