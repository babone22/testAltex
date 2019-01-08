package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class RobotTest {

    @Test
    public void robotTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/test/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.kevinlamping.com/webdriverio-course-content/");
        driver.findElement(By.xpath("//*[@class='fancy button large']")).click();
        Select select = new Select(driver.findElement(By.id("robotType")));
        select.selectByVisibleText("Centurion");
        driver.findElement(By.id("qty")).sendKeys("3");
        driver.findElement(By.id("buyNowButton")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callout']")));
        String messageDisplayed = driver.findElement(By.xpath("//*[@class='callout']")).getText().split("\n")[0];
        assertTrue(messageDisplayed.equals("Thank you human for your purchase of 3 Centurion robot(s)."));
        driver.quit();
    }

    @DataProvider(name="robotSelections")
    public static Object[][] credentials() {
        return new Object[][] { { "Centurion" },{"HAL"},{"Megatron"},{"T-800 Model 101"}};
    }


    @Test(dataProvider = "robotSelections")
    public void robotTestAllVariants(String selection){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/test/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.kevinlamping.com/webdriverio-course-content/");
        driver.findElement(By.xpath("//*[@class='fancy button large']")).click();
        Select select = new Select(driver.findElement(By.id("robotType")));
        select.selectByVisibleText(selection);
        driver.findElement(By.id("qty")).sendKeys("3");
        driver.findElement(By.id("buyNowButton")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='callout']")));
        String messageDisplayed = driver.findElement(By.xpath("//*[@class='callout']")).getText().split("\n")[0];
        assertTrue(messageDisplayed.equals("Thank you human for your purchase of 3 "+selection+" robot(s)."));
        driver.quit();
    }
}
