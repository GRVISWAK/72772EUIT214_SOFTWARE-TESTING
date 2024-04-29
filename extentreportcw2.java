package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentreportcw2 {
        WebDriver driver;
        ExtentReports reports;
        ExtentTest test;

        @BeforeTest
        public void openBrowser() throws InterruptedException {
                driver = new ChromeDriver();
                WebDriverManager.chromedriver().setup();
                ExtentSparkReporter ereport = new ExtentSparkReporter(
                                "C:\\Users\\ASUS\\OneDrive\\Desktop\\demo\\ExtentReports\\ixigoreport.html");
                reports = new ExtentReports();
                reports.attachReporter(ereport);
        }

        @BeforeMethod
        public void open() {
                driver.manage().window().maximize();
                driver.get("http://www.ixigo.com");

        }

        @Test
        public void Test1() throws InterruptedException, IOException {
                test = reports.createTest("Test 1 Started");
                WebElement from = driver
                                .findElement(By.xpath(
                                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div"));
                from.click();
                FileInputStream fs = new FileInputStream("C:\\Users\\OrangeHRM.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(fs);
                XSSFSheet sheet1 = workbook.getSheet("LOGIN");
                XSSFRow row = sheet1.getRow(4);
                String fromplace = row.getCell(0).getStringCellValue();

                WebElement fromBox = driver.findElement(
                                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input"));
                fromBox.sendKeys(fromplace);
                fromBox.sendKeys(Keys.ENTER);
                Thread.sleep(6000);
                WebElement idpOption = driver.findElement(
                                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/li"));
                idpOption.click();
                XSSFRow row2 = sheet1.getRow(5);
                String to = row2.getCell(0).getStringCellValue();
                System.out.println(to);

                WebElement toElement = driver
                                .findElement(By.xpath(
                                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div"));
                toElement.click();
                WebElement toBox = driver.findElement(
                                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input"));
                toBox.sendKeys(to);
                toBox.sendKeys(Keys.ENTER);
                Thread.sleep(3000);
                WebElement delOption = driver.findElement(
                                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/li"));
                delOption.click();
                Thread.sleep(5000);
                WebElement departureDate_DatePicker = driver
                                .findElement(By.xpath(
                                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div"));
                departureDate_DatePicker.click();
                Thread.sleep(4000);
                while (true) {
                        WebElement currentMonthYearElement = driver.findElement(By.xpath(
                                        "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[2]/span[1]"));
                        String currentMonthYear = currentMonthYearElement.getText();
                        String[] parts = currentMonthYear.split(" ");
                        String month = parts[0];
                        String year = parts[1];

                        if (month.equals("November") && year.equals("2024")) {
                                test.log(Status.PASS, "To Month found");
                                break;
                        }
                        WebElement nextButton = driver.findElement(
                                        By.cssSelector(".react-calendar_navigationarrow.react-calendarnavigation_next-button"));
                        nextButton.click();
                }
                WebElement targetDateElement = driver.findElement(By.xpath(
                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[11]/abbr"));
                targetDateElement.click();
                Thread.sleep(2000);
                WebElement ReturnDate_DatePicker = driver
                                .findElement(By.xpath(
                                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]"));
                ReturnDate_DatePicker.click();
                Thread.sleep(3000);
                while (true) {
                        WebElement currentMonthYearElement = driver.findElement(By.xpath(
                                        "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[2]/span[1]"));
                        String currentMonthYear = currentMonthYearElement.getText();
                        String[] parts = currentMonthYear.split(" ");
                        String month = parts[0];
                        String year = parts[1];

                        if (month.equals("November") && year.equals("2024")) {
                                test.log(Status.PASS, "From Month found");
                                break;
                        }
                        WebElement nextButton = driver.findElement(
                                        By.cssSelector(".react-calendar_navigationarrow.react-calendarnavigation_next-button"));
                        nextButton.click();
                }
                WebElement targetDateElement1 = driver.findElement(By.xpath(
                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[13]/abbr"));
                targetDateElement1.click();
                Thread.sleep(2000);
                WebElement travellersAndClass = driver
                                .findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div"));
                travellersAndClass.click();
                WebElement adultsInput = driver.findElement(By.xpath(
                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[1+2]"));
                adultsInput.click();
                Thread.sleep(2000);
                WebElement childInput = driver.findElement(By.xpath(
                                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[1+2]"));
                childInput.click();
                Thread.sleep(2000);
                WebElement businessOption = driver.findElement(
                                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]/p"));
                businessOption.click();
                Thread.sleep(5000);
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "C:\\Users\\ASUS\\OneDrive\\Desktop\\demo\\ExtentReports\\ixigo_page.png";
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                test.log(Status.PASS, "Test Passed Screenshot",
                                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        @Test
        public void Test2() throws InterruptedException {
                test = reports.createTest("Test 2 Started");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,4000)");
                Thread.sleep(3000);
                driver.findElement(By.linkText("About Us")).click();
                Thread.sleep(5000);
                for (String handle : driver.getWindowHandles()) {
                        driver.switchTo().window(handle);
                }
                if (driver.getCurrentUrl().contains("about")) {
                        System.out.print("Name found");
                        test.log(Status.PASS, "About found");
                } else {
                        System.out.print("Name not found");
                        test.log(Status.FAIL, "About not found");
                }
        }

        @AfterTest
        public void close() {
                reports.flush();
                driver.quit();
        }
}