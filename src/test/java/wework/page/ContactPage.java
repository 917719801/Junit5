package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    By addMenber = By.linkText("添加成员");
    By userName=By.name("username");

    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo

       /* new WebDriverWait(MainPage.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("添加成员")));*/
        MainPage.driver.findElement(addMenber).click();
        MainPage.driver.findElement(userName).sendKeys(username);
        MainPage.driver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.driver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }
}
