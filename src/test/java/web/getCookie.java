package web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getCookie {
     static WebDriver driver;
    @Test
    void getCookies(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","localhost:9222");
        driver = new ChromeDriver(options);
        System.out.println(driver.manage().getCookies());
    }
}
