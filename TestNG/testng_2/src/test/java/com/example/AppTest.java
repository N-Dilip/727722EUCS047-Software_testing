package com.example;

//import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @Test
    public void testing() throws Exception
    {
        //testng2
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver=new ChromeDriver();
        driver.get("https://www.moneycontrol.com/");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]")).sendKeys("Reliance Industries");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();
        js.executeScript("window.scrollBy(0,900)");
        String str=driver.findElement(By.xpath("/html/body/div[13]/div[2]/div[2]/div[2]/div[1]/div/h1")).getText();
        if(str.equals("Reliance Industries Ltd."))
        {
            System.out.println("The pages contains the specific term");
        }
        else
        System.out.println("The page doesnot contain the specific term");
      //  driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/a"));
        WebElement hoverable = driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/a"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.findElement(By.linkText("SIP Return")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[2]/form/select")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[2]/form/select/option[3]")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,9400)");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/div[4]/form/select/option[2]")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,9400)");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("100000");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[2]/input")).sendKeys("2021-08-02");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[6]/div[4]/input")).sendKeys("2023-08-17");
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
        String period=driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[1]")).getText();
        System.out.println("Investment Period");
    }
}
