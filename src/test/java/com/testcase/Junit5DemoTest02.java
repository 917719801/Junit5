package com.testcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5DemoTest02 {
    @Test
    void assertion(){
        assertAll("demo",
                ()-> assertEquals(1,2),
                ()-> assertEquals(1,1),
                ()-> assertEquals(1,4,"与实际结果不符"),
                ()-> assertEquals(1,5)
        );

    }
}
