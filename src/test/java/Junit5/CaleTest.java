package Junit5;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaleTest {

    @Test
    @Tag("xxx")
    @Link(name="allure",type = "mylink",url="https://www.baidu.com")


    void dic() {
        Allure.step("第一步");
        Cale cale = new Cale();
        Allure.step("第2步");
        Allure.addAttachment("xxxxxx","11111");
        Allure.addAttachment("demo","image/png",
                this.getClass().getResourceAsStream("/微信图片_20210318112005.jpg"),"jpg");
        assertEquals(cale.dic(2,1),2);
    }
}