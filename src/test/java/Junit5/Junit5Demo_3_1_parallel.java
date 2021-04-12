package Junit5;
/*
并发场景测试
 */

import org.junit.jupiter.api.RepeatedTest;
import util.Calculator;

public class Junit5Demo_3_1_parallel {
    @RepeatedTest(100)
    //没有加安全锁
    void countTest(){
        int result= Calculator.count(1);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程号"+threadId+"当前报名人数"+result);
    }
    @RepeatedTest(100)
    //加了安全锁
    public void synCountTest() throws InterruptedException {
        int result = Calculator.synCount(1);
        long threadId = Thread.currentThread().getId();
        System.out.println("线程号+"+threadId+"为您计算当前报名人数为：" +result);
    }

}
