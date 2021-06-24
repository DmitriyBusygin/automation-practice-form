package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    void readNullFromPropertyTest() {
        String value = System.getProperty("our_property");
        System.out.println(value);
        //null
    }

    @Test
    void setAndReadFromPropertyTest() {
        System.setProperty("our_property", "communism");
        String value = System.getProperty("our_property");
        System.out.println(value);
        //communism
    }

    @Test
    void readDefaultFromPropertyTest() {
        String value = System.getProperty("our_property", "default value");
        System.out.println(value);
        //default value
    }

    @Test
    void readWithGradleFromPropertyTest() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }

    @Test
    void readWithGradleFromPropertyTest2() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }

    @Test
    @Tag("terminal")
    void readWithTerminalFromPropertyTest() {
        String value = System.getProperty("version", "1");
        System.out.println(value);
    }
}
