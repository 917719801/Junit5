package Junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvnTest {
    @Test
    void evnTest(){
        assertEquals(1,2,"实际值与期望值不符");
    }
    @Test
    void evn1Test(){
        assertEquals(1,1,"实际值与期望值一致");
    }
}
