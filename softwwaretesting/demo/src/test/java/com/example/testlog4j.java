package com.example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class testlog4j {
    static Logger logger=Logger.getLogger(testlog4j.class);
    @Test(dataProvider="data")
    public void answertrue(String email,String password) throws Exception{
        PropertyConfigurator.configure("");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skcet530.examly.io/login");
        logger.info("Opened skcet login page");
        driver.findElement(By.xpath("//*[@id='formFieldsID']/div[3]/div/div/div[1]/app-button/button")).click(); 
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='formFieldsID']/div[3]/div/div/div/app-button/button")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='formFieldsID']/div[3]/div/div/div/app-button/button")).click();;
        logger.info("logged into skcet page");
    }
    @DataProvider(name="data")
    public Object[][] fetch()
    {
        Object [][] data= new Object[1][2];
        data[0][0]="727722euit214@skcet.ac.in";
        data[0][1]="gr@5002";
        return data;
    }

}
