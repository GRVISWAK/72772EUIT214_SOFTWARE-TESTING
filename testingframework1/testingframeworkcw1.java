package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testingframeworkcw1 {
    
    WebDriver driver;
    @BeforeTest
    public void set()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
    }
    @Test(dataProvider = "data")
    public void test(String username,String password) throws Exception
    {
        /*FileInputStream fs=new FileInputStream("C:\\Users\\viswa\\Desktop\\demobankxl.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet sheet1=wb.getSheet("Sheet1");
        XSSFRow row1=sheet1.getRow(i);
        String username=row1.getCell(0).getStringCellValue();
        String password=row1.getCell(1).getStringCellValue();
        Thread.sleep(3000); */
        driver.findElement((By.id("username"))).sendKeys(username);
        driver.findElement((By.id("password"))).sendKeys(password);
        driver.findElement((By.id("submit"))).click();
        /*driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div[1]/a/img")).click();
        driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div[1]/div/a[5]")).click();*/
        driver.findElement(By.xpath("//*[@id='deposit-menu-item']")).click();
        Select select =new Select(driver.findElement(By.xpath("//*[@id='selectedAccount']")));
        select.selectByVisibleText("Individual Checking(standard checking) (Savings)");
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("5000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        WebElement ele=driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]"));
        String dep=ele.getText();
        if(dep.equals("$5000.00"))
        System.out.println("amount is deposited");
        else
        System.out.println("Amount is not deposited");
        driver.findElement(By.xpath("//*[@id='withdraw-menu-item']")).click();
        Select select2 =new Select(driver.findElement(By.xpath("//*[@id='selectedAccount']")));
        select2.selectByVisibleText("Individual Checking(standard checking) (Savings)");
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        String widamt=driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
        if(widamt.equals("$-3000.00"))
        System.out.print("amount withdrawed");
        else
        System.out.print("amount not withrawed");
    }
    @DataProvider(name="data")
        public Object[][] fetch(){
            Object[][] data=new Object[1][2];
            data[0][0]="S@gmail.com";
            data[0][1]="P@ssword12";
            return data;
        }
}
