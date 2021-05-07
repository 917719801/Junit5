package wework.page;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

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
        sendKeys(userName,username);
        sendKeys(By.name("acctid"),acctid);
        sendKeys(By.name("mobile"),mobile);
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


        sendKeys(By.id("memberSearchInput"),keyword);
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

    @SneakyThrows
    public ContactPage importFromFile(URL path){
        String path_utf="";


        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_right"));
        click(By.linkText("文件导入"));

        //click(By.id("js_upload_file_input"));
       // driver.findElement(By.name("file")).sendKeys("/Users/liule/IdeaProjects/PracticeCode/Junit5/src/main/resources/通讯录批量导入.xlsx");
        //sendKeys(By.id("js_upload_file_input"),"C:\\fakepath\\通讯录批量导入.xlsx");

//        try {
//            Thread.sleep(1000);
//            path_utf = URLDecoder.decode(path.getFile(),"UTF-8");
//            //System.out.println(path_utf);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        upload(By.name("file"),path.getFile());
        click(By.linkText("确认导入"));
        click(By.linkText("完成"));
        return this;
    }

    public String getUserName(){
        return  driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }
}
