package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.ResourceBundle;

import java.sql.SQLOutput;
import java.util.List;

public class GmailLoginTest {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setupDriver (String browser,String link) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new EdgeDriver();

        }



        driver.get("https://mail.google.com/");
        driver.manage().window().maximize();
    }
    @Test

    void getTitleFromPage() throws InterruptedException {
        ResourceBundle r=ResourceBundle.getBundle("config");
        String username=r.getString("username");
        String password=r.getString("password");

        // driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
        // Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("Epamca3@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Qwer@123");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
        Thread.sleep(10000);


    }
    @AfterClass
    void closeDriver() {
        driver.close();

    }
}

