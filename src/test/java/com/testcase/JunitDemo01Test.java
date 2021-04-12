package com.testcase;



import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Junit5Demo冒烟")
public class JunitDemo01Test {
    @BeforeAll
    public static void before() {
        System.out.println("before");
    }

    @BeforeEach
    public void beforeeach() {
        System.out.println("beforeeach");
    }

    @AfterEach
    public void aftereach() {
        System.out.println("aftereach");
    }

    @Test
    @DisplayName("case1")
    @RepeatedTest(5)
    void fun1() {
        System.out.println("fun1");
    }

    @Test
    @Disabled
    void fun2() {
        System.out.println("fun2");
    }
    @Test
    void demo(){
        assertEquals(1,2);
    }

    @AfterAll
    public static void after() {
        System.out.println("after");
    }
}
