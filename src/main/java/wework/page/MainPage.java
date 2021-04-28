package wework.page;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BassPage {

    public MainPage() {
        super();
        String url = "https://work.weixin.qq.com/wework_admin/frame";

        driver.get(url);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> cookies = null;
        try {
            cookies = objectMapper.readValue(new File("cookie.yaml"), typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cookies.forEach(cookie -> {
            driver.manage().addCookie(new Cookie(cookie.get("name").toString(), cookie.get("value").toString()));
        });

        driver.navigate().refresh();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public ContactPage toContact() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'通讯录')]")));
        //driver.findElement(By.cssSelector(".frame_nav_item_title")).click();
        //driver.findElement(By.xpath("//span[contains(.,'通讯录')]")).click();
        click(By.xpath("//span[contains(.,'通讯录')]"));
        return new ContactPage(driver);
    }

}
