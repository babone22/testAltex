package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleClass {


    @Test
    public void simpleTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/test/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://altex.ro");
        driver.manage().window().maximize();
        driver.quit();
    }
}
