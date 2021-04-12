package Junit5;
/*
并发场景测试
 */

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Demo_3_2_mixparallel {
    @RepeatedTest(10)
    void add(){
        int a = Calculator.add(3,2);
        System.out.println("计算结果："+a);
        assertEquals(5,a);
    }
    @RepeatedTest(10)
    void subtract(){
        int i=Calculator.subtract(5,2);
        System.out.println("计算结果："+i);
        assertEquals(3,i);
    }
}
