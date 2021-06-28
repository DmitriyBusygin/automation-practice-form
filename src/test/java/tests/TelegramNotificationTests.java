package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("telegram")
public class TelegramNotificationTests {

    @Test
    @Disabled
    void someTest() {
        assertTrue(true);
    }

    @Test
    void someTest2() {
        assertTrue(true);
    }

    @Test
    void someTest3() {
        assertTrue(true);
    }

    @Test
    void someTest4() {
        assertTrue(false);
    }
}
