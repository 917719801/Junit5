package Junit5;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import util.Calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 基础脚本、分别执行了加、减、乘、除、计数方法，并对结果进行了打印
 * 1、进行了优化，添加自动断言，无需人工对结果进行判断。
 * 2、进行了优化：使用Junit5提供的Java 8 lambdas的assertAll断言方法，增加了脚本的容错性。
 * 3、通过assertThat引用三方Matcher库，大大增加了断言的灵活性。
 * 4、进行了优化，使用类的@TestMethodOrder和方法的@Order注解对方法执行顺序进行顺序设置。
 * 5、进行了优化，通过@BeforeEach在每个方法前进行结果清零操作
 * 6、通过suit注解可以在不改变原脚本的基础上，灵活的选取被执行测试方法。
 * 7、通过Junit提供的并发功能，测试被测逻辑在多线程下的线程安全问题
 **/

@Epic("计算器项目")
@Feature("冒烟测试yongl")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Demo_4_1_Allure {
    @Description("Description加法测试-assertAll应用")
    @Story("Story加法测试")
    @DisplayName("DisplayName加法测试")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("123")
    @TmsLink("test-1")
    @Test
    @Order(1)
    void addTest(){
        int result = Calculator.add(4, 2);
        System.out.println("加法计算结果： "+result);
        int result01 = Calculator.add(-1, 1);
        System.out.println("加法计算结果： "+result01);
        int result02 = Calculator.add(0, 2);
        System.out.println("加法计算结果： "+result02);

        assertAll("计算结果校验！",
                () -> assertEquals(6, result),
                () -> assertEquals(1, result01),
                () -> assertEquals(2,result02)
        );

    }



}
