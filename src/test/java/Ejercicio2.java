import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ejercicio2 extends Base{
    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void exercise2(){
        Actions act = new Actions(driver);

        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(doubleClick).perform();
        String successfulDouble  = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals(successfulDouble,"You have done a double click");

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightClick).perform();
        String successfulRight = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals(successfulRight,"You have done a right click");

        WebElement clickMe = driver.findElement(By.xpath("//*[text()='Click Me']"));
        clickMe.click();
        String successfulClick = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals(successfulClick,"You have done a dynamic click");

    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
