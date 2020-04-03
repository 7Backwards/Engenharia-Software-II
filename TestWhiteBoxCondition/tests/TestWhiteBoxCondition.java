import com.es2.whiteboxconditions.Rating;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWhiteBoxCondition {

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @Test
    public void evaluateScoreTemperature1() {
        Rating rating = new Rating();

        assertEquals("It's hot out, and so am I", rating.evaluateScoreTemperature(11, 36));
    }

    @Test
    public void evaluateScoreTemperature2() {
        Rating rating = new Rating();

        assertEquals("I'm in a bad mood", rating.evaluateScoreTemperature(11, 19));
    }

    @Test
    public void evaluateScoreTemperature3() {
        Rating rating = new Rating();

        assertEquals("I'm balanced", rating.evaluateScoreTemperature(9, 25));
    }

    @Test
    public void evaluateScoreTemperature4() {
        Rating rating = new Rating();

        assertEquals("I'm in a bad mood", rating.evaluateScoreTemperature(3, 25));
    }

    @Test
    public void evaluateIfCouldBeAcceptedAtDisco1() {
        Rating rating = new Rating();

        assertEquals("Not Accepted", rating.evaluateIfCouldBeAcceptedAtDisco(10, 3));
    }

    @Test
    public void evaluateIfCouldBeAcceptedAtDisco2() {
        Rating rating = new Rating();

        assertEquals("Not Accepted", rating.evaluateIfCouldBeAcceptedAtDisco(6, 3));
    }

    @Test
    public void evaluateIfCouldBeAcceptedAtDisco3() {
        Rating rating = new Rating();

        assertEquals("Accepted", rating.evaluateIfCouldBeAcceptedAtDisco(9, 6));
    }
}