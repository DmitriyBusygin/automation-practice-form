package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static configuration.Credentials.*;

public class OwnerTest {

    @Test
    @Tag("owner")
    void readFromPropertiesTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login);
        System.out.println(password);

    }
}
