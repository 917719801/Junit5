package Junit5;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import entity.ResultList;
import entity.ShellResult;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Junit5Demo_2_1_DynamicTestDemo {
    @TestFactory
    Collection<DynamicTest> dynamicTestCollection() {
        return Arrays.asList(
                dynamicTest("lst dynamic test", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test", () -> assertEquals(3, 3))
        );
    }

    @Test
    void entityTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ResultList resultList = objectMapper.readValue(new File("src/main/resources/shell_test_result.yaml"), ResultList.class);
        System.out.println("debugger!");

    }

    @TestFactory
    Collection<DynamicTest> runShellResult() throws IOException {
        List<DynamicTest> dynamicTestsList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        ResultList resultList = objectMapper.readValue(new File("src/main/resources/shell_test_result.yaml"), ResultList.class);
        System.out.println("-----");
        for (ShellResult shellResult : resultList.getResultList()) {
            dynamicTestsList.add(dynamicTest(shellResult.getCaseName(), () -> {
                assertTrue(shellResult.isResult());
            }));

        }
        return dynamicTestsList;
    }


}
