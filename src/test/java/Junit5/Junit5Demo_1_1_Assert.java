package Junit5;
/*
断言示例

直接断言  出现问题后用例将停止运行
 */

import org.junit.jupiter.api.*;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Demo_1_1_Assert {
    @Test
    void  addTest(){
        int result= Calculator.add(4,2);
        System.out.println("加法计算"+result);
        assertEquals(6,result);

        int result01= Calculator.add(3,2);
        System.out.println("加法计算"+result01);
        assertEquals(6,result01);

        int result02= Calculator.add(2,2);
        System.out.println("加法计算"+result02);
        assertEquals(6,result02);

    }

}
