package Junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaleTest {

    @Test
    void dic() {
        Cale cale = new Cale();
        assertEquals(cale.dic(2,1),2);
    }
}