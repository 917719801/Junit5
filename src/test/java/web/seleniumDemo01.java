package Web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumDemo01 {

    @Test
    void fun(){

       // System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
    }
}
