package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SimpleClass {


    @Test
    public void invalidLogin(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/test/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//*[contains(@href,'/login')]")).click();
        driver.findElement(By.id("username")).sendKeys("alex");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String messageDisplayed =  driver.findElement(By.id("flash")).getText().split("!")[0];
        assertTrue(messageDisplayed.equals("Your username is invalid"));
        driver.quit();
    }

    @Test
    public void correctLogin(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/test/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//*[contains(@href,'/login')]")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String messageDisplayed =  driver.findElement(By.id("flash")).getText().split("!")[0];
        assertTrue(messageDisplayed.equals("You logged into a secure area"));
        driver.quit();
    }

}
