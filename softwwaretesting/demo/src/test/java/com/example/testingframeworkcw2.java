package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testingframeworkcw2 {
    
    @Test
    public void setup() throws Exception{
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.linkText("Laptops")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/div[3]/div/div/h4/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/div[2]/div/a"))).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cartur']"))).click();;
        String str=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td[2]"))).getText();
        if(str.equals("MacBook air"))
        {
            System.out.println("product is selected");
        }
        else
        {
            System.out.println("product is not selected");
        }
    }
}
