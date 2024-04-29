package com.example;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class log4jmoneycontrolcw1{
    static Logger log = Logger.getLogger(log4jmoneycontrolcw1.class);

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        PropertyConfigurator.configure(("src/main/resources/log4j.properties"));
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        String path1 = "https://www.moneycontrol.com/";
        driver.get(path1);
        log.info("Opened Money Control");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id='search_str']")).sendKeys("Reliance Industries.", Keys.ENTER);
        log.info("Entered Reliance Industries");
        Thread.sleep(2000);
        WebElement e3 = driver
                .findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a"));
        String name = e3.getText();
        if (name.equals("Reliance Industries Ltd"))
            log.info("Name Found");
        else
            log.error("Name not found");
        driver.findElement(By.linkText("Reliance Industries Ltd")).click();
        log.info("Selected Reliance Industries Ltd");

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.linkText("Mutual Funds"));
        log.info("Selected Mutual Funds");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("SIP Return")).click();
        log.info("Selected SIP Return");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        WebElement dp1 = driver.findElement(By.xpath("//*[@id='ff_id']"));
        Select dropdown1 = new Select(dp1);
        dropdown1.selectByVisibleText("Axis Mutual Fund");
        Thread.sleep(2000);
        WebElement dp2 = driver.findElement(By.xpath("//*[@id='im_id']"));
        Select dropdown2 = new Select(dp2);
        dropdown2.selectByIndex(3);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='invamt']")).sendKeys("100000");
        Thread.sleep(2000);
        driver.findElement(By.id("stdt")).sendKeys("2021-08-02");
        Thread.sleep(2000);
        driver.findElement(By.id("endt")).sendKeys("2023-08-17");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input"))
                .click();
        log.info("Clicked Calculate Button");
        Thread.sleep(2000);
        WebElement e = driver.findElement(
                By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[2]"));
        String period = e.getText();
        WebElement e1 = driver.findElement(
                By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[3]/td[2]"));
        String amount = e1.getText();
        System.out.println(period);
        System.out.println(amount);

        driver.quit();

    }
}
