package junitexamples.packageC;

import org.junit.jupiter.api.*;


@Tag("development")
public class ClassCTest {
    @Test
    @DisplayName("testCaseC inside ClassCTest inside packageC")
    public void testCaseC() {
        System.out.println("testCaseC inside ClassCTest inside packageC");
    }


}
