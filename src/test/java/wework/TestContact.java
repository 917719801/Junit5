package wework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wework.page.ContactPage;
import wework.page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String userName=contactPage.addMember("4","4","18829356667").search("4").getUserName();
        //断言
        assertEquals(userName,4 );
    }


    @Test
    @Order(2)
    void searchTest(){
        contactPage.search("4").delete();
    }

    @Test
    void  testImportFromFile(){
        contactPage.importFromFile(this.getClass().getResource("/通讯录批量导入.xlsx"));
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
