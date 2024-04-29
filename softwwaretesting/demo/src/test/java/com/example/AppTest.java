package com.example;

import java.io.FileInputStream;
import java.util.Set;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    @BeforeTest
    public void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Test Init !");
    }
    @BeforeMethod
    public void BeforeMethod(){
        driver.get("https://skcet530.examly.io/otpverification");
        System.out.println("before method");
    }

    @Test(priority='a')
    public void Test1()
    {
        System.out.println("Hello Test 1 !");
    }
    @Test(priority='b')
    public void Test2()
    {
        System.out.println("Hello Test 2 !");
    }
    @Test(priority='c')
    public void Test3()
    {
        System.out.println("Hello Test 3 !");
    }
    @Test(priority='d')
    public void Test4()
    {
        System.out.println("Hello Test 4 !");
    }
    @AfterMethod
    public void aftermethod()
    {
        driver.get("https://meet.google.com/");
        System.out.println("after method");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("Aftertest");
        driver.quit();
    }
}