package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class DataProviderTest {

    @DataProvider(name="dataProvider")
    public static Object[][] credentials() {
        return new Object[][] { { "testuser_1", "Test@123" },{"testuser_2" , "Test@111"}, { "tomsmith", "SuperSecretPassword!" }};
    }

    @Test(dataProvider = "dataProvider")
    public void dataProviderTest(String username,String password){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/test/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//*[contains(@href,'/login')]")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String messageDisplayed =  driver.findElement(By.id("flash")).getText().split("!")[0];
        if(username.equals("tomsmith")){
            assertTrue(messageDisplayed.equals("You logged into a secure area"));
        } else {
            assertTrue(messageDisplayed.equals("Your username is invalid"));
        }
        driver.quit();
    }
}
