package wework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wework.page.ContactPage;
import wework.page.MainPage;

public class TestContact {
    static MainPage mainPage;
    static ContactPage contactPage;
    @BeforeAll
    static void beforeall(){
        mainPage = new MainPage();
        contactPage=mainPage.toContact();

    }
    @Test
    @Order(1)
    void testAddMember(){
        contactPage.addMember("4","4","18829356667");
        //断言
    }

    @Test
    @Order(2)
    void searchTest(){
        contactPage.search("4").delete();
    }

    @AfterAll
    static  void afterall(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.quit();
    }
}
