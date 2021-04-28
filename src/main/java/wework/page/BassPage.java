package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BassPage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public BassPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public BassPage() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, 10);

    }

    public void quit() {
        driver.quit();
    }

    public void click(By by) {
        //wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

}
