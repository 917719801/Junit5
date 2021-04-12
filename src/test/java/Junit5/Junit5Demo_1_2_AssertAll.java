package Junit5;
/*
断言示例
软断言的好处：出现问题后用例将继续执行
 */

import org.junit.jupiter.api.Test;
import util.Calculator;


import java.util.ArrayList;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Demo_1_2_AssertAll {
    @Test
    void addTest() {
        int result = Calculator.add(4, 2);
        System.out.println("加法计算" + result);


        int result01 = Calculator.add(3, 2);
        System.out.println("加法计算" + result01);


        int result02 = Calculator.add(2, 2);
        System.out.println("加法计算" + result02);

        //统一断言  方法1
        assertAll("计算结果统一校验",
                () -> {
                    assertEquals(6, result);
                    System.out.println("执行成功");
                },
                () -> assertEquals(3, result01),
                () -> assertEquals(2, result02)
        );

    }

    @Test//统一断言  方法2
    void addTest1() {
        ArrayList<Executable> arrayList = new ArrayList<>();
        int result = Calculator.add(4, 2);
        System.out.println("加法计算" + result);
        arrayList.add(() -> assertEquals(6, result));


        int result01 = Calculator.add(3, 2);
        System.out.println("加法计算" + result01);
        arrayList.add(() -> assertEquals(3, result));

        int result02 = Calculator.add(2, 2);
        System.out.println("加法计算" + result02);
        arrayList.add(() -> assertEquals(2, result));

        assertAll("", arrayList.stream());

    }
}
