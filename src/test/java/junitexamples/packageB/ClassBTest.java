package junitexamples.packageB;

import org.junit.jupiter.api.*;

public class ClassBTest {

    @Tag("development")
    @Tag("production")
    @Test
    @DisplayName("testCaseB inside ClassBTest inside packageB")
    public void testCaseB() {
        System.out.println("testCaseB inside ClassBTest inside packageB");

    }

}
