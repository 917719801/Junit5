package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WechatTest {
    static WebDriver webDriver;
    @BeforeAll
    public  static  void init(){
        webDriver = new SafariDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterAll
    public static  void tearDown(){
        webDriver.quit();
    }

    @Test
    void saveCookie(){
        try {
            webDriver.get("https://work.weixin.qq.com/wework_admin/frame");
            Thread.sleep(1000);
            Set<Cookie> cookies = webDriver.manage().getCookies();
            webDriver.navigate().refresh();
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            objectMapper.writeValue(new File("cookie.yaml"),cookies);
            cookies.forEach(cookie -> System.out.println(cookie.getName()+":"+cookie.getValue()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
