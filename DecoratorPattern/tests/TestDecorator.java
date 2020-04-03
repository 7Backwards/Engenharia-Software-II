import com.es2.decorator.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDecorator {

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @Test
    public void AuthValidUsernameAndPassword() {

        AuthInterface auth = new Auth();
        assertDoesNotThrow(() -> auth.auth("admin", "admin"));
    }

    @Test
    public void AuthValidUsernameAndWrongPassword() {

        AuthInterface auth = new Auth();
        AuthException authException = assertThrows(AuthException.class, () -> auth.auth("admin", "wrongpassword"));
    }


    @Test
    public void AuthWrongUsernameAndValidPassword() {

        AuthInterface auth = new Auth();
        assertThrows(AuthException.class, () -> auth.auth("wrongusername", "admin"));
    }

    @Test
    public void AuthWrongUsernameAndWrongPassword() {

        AuthInterface auth = new Auth();
        assertThrows(AuthException.class, () -> auth.auth("falso", "falso"));
    }

    @Test
    public void AuthValidCommonWord() {

        AuthInterface auth = new CommonWordsValidator(new Auth());
        assertDoesNotThrow(() -> auth.auth("admin", "admin"));
    }

    @Test
    public void AuthInvalidCommonWord() {

        AuthInterface auth = new CommonWordsValidator(new Auth());
        assertThrows(AuthException.class, () -> auth.auth("admin", "adminwrongpassword"));
    }
}