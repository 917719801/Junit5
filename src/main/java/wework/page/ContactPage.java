package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.RemoteException;
import java.time.Duration;

public class ContactPage {
    By addMenber = By.linkText("添加成员");
    By userName = By.name("username");
    RemoteWebDriver driver;

    public ContactPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("添加成员")));
        driver.findElement(addMenber).click();
        driver.findElement(userName).sendKeys(username);
        driver.findElement(By.name("acctid")).sendKeys(acctid);
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }

    public ContactPage search(String keyword) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


       driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("删除")));
        return this;
    }

    public ContactPage delete() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.linkText("确认")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("clearMemberSearchInput")));
        driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
