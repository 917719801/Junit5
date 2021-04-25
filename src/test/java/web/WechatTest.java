package web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WechatTest {
    static WebDriver webDriver;
    @BeforeAll
    public  static  void init(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","localhost:9222");
       webDriver = new ChromeDriver(options);
        //webDriver = new ChromeDriver();

        //隐式等待
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterAll
    public static  void tearDown(){
       webDriver.quit();
    }

    @Test
    void saveCookie(){
        try {
            webDriver.get("https://work.weixin.qq.com/");
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
    @Test
    void loginTest(){
        try{
            webDriver.get("https://work.weixin.qq.com/");

            ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
            TypeReference<List<HashMap<String, Object>>> typeReference=new TypeReference<List<HashMap<String, Object>>>(){};
            List<HashMap<String, Object>> cookies = objectMapper.readValue(new File("cookie.yaml"), typeReference);
            cookies.forEach(cookie->{
                webDriver.manage().addCookie(new Cookie(cookie.get("name").toString(),cookie.get("value").toString()));
            });

            webDriver.navigate().refresh();
            webDriver.findElement(By.linkText("通讯录")).click();

        }catch (Exception e){
            e.printStackTrace();
        }



    }



}
