package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Configurator {
    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }
}
