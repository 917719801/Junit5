package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo

        /*new WebDriverWait(MainPage.webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("添加成员")));*/
        MainPage.webDriver.findElement(By.linkText("添加成员")).click();
        MainPage.webDriver.findElement(By.name("username")).sendKeys(username);
        MainPage.webDriver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.webDriver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.webDriver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }
}
