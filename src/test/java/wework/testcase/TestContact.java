package wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import wework.page.MainPage;

public class TestContact {
    @Test
    void testAddMember(){
        MainPage mainPage = new MainPage();
        mainPage.toContact().addMember("4","4","18829356667");
        //断言
    }

    @AfterAll
    static  void afterall(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage.driver.quit();
    }
}
