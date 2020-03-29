import com.es2.singleton.End;
import com.es2.singleton.Registry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;


public class TestSingleton {

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @Test
    public void CheckPath_ValidValue() {

        Registry.getInstance().setPath("testePath");
        assertEquals("testePath", Registry.getInstance().getPath());
    }

    @Test
    public void CheckConnectionString_ValidValue() {

        Registry.getInstance().setConnectionString("testePath");
        assertEquals("testePath", Registry.getInstance().getConnectionString());
    }

    @Test
    public void CheckPath_NullValue() {

        Registry.getInstance().setPath(null);
        assertNull(Registry.getInstance().getPath());
    }

    @Test
    public void CheckConnectionString_NullValue() {

        Registry.getInstance().setConnectionString(null);
        assertNull(Registry.getInstance().getConnectionString());
    }

    @Test
    public void CheckIfSingletonPrivate() throws NoSuchMethodException, SecurityException {

        assertTrue(Modifier.isPrivate(Registry.class.getDeclaredConstructor().getModifiers()));
    }


}