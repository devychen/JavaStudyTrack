import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HandshakeTest {

    @Test
    public void testHandshake() {
        assertEquals(0, Handshake.handshake(0));
        assertEquals(0, Handshake.handshake(1));
        assertEquals(1, Handshake.handshake(2));
        assertEquals(3, Handshake.handshake(3));
        assertEquals(6, Handshake.handshake(4));
        assertEquals(10, Handshake.handshake(5));
    }

    @Test
    public void testHandshakeWithNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Handshake.handshake(-1);
        });
        assertEquals("Number of people cannot be negative", exception.getMessage());
    }
}
