package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    static WebDriver webDriver;

    @BeforeMethod
    public static void precondition(){
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/login");
    }


    @Test(description = "Check Login Testing")
    public void test(){
        webDriver.findElement(By.id("username")).clear();
        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.className("radius")).click();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String result = webDriver.findElement(By.id("flash")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("You logged into a secure area!")," You logged into a secure area!");

    }
    @AfterMethod
    public void finish(){
        webDriver.close();
    }

}
