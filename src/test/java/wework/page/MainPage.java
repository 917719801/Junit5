package wework.page;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    public static WebDriver webDriver;

    public MainPage() {
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(url);
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
            webDriver.manage().addCookie(new Cookie(cookie.get("name").toString(), cookie.get("value").toString()));
        });

        webDriver.navigate().refresh();

    }


    public ContactPage toContact() {
        webDriver.findElement(By.cssSelector(".frame_nav_item_title")).click();
        return new ContactPage();
    }
}
