package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.RemoteException;
import java.time.Duration;

public class ContactPage extends BassPage{
    By addMenber = By.linkText("添加成员");
    By userName = By.name("username");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }


    public ContactPage addMember(String username, String acctid, String mobile) {
        //todo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(addMenber);


        //driver.findElement(addMenber).click();
        driver.findElement(userName).sendKeys(username);
        driver.findElement(By.name("acctid")).sendKeys(acctid);
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        click(By.cssSelector(".js_btn_save"));
        //driver.findElement(By.cssSelector(".js_btn_save")).click();
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
        click(By.linkText("删除"));
        //driver.findElement(By.linkText("删除")).click();
        click(By.linkText("确认"));
        //driver.findElement(By.linkText("确认")).click();
        //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("clearMemberSearchInput")));
        click(By.id("clearMemberSearchInput"));
        //driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
