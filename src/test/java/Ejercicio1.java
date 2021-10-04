import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio1 extends Base{
    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void exercise1() {
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Aldrich");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Huarco");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("abc@prueba.com");

        WebElement gender = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        gender.click();

        WebElement numberInput = driver.findElement(By.id("userNumber"));
        numberInput.sendKeys("9999999999");

        WebElement birthdateInput = driver.findElement(By.id("dateOfBirthInput"));
        birthdateInput.click();

        WebElement monthInput = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
        monthInput.sendKeys("February");

        WebElement yearInput = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        yearInput.sendKeys("1994");

        WebElement dayInput = driver.findElement(By.cssSelector("div[aria-label='Choose Wednesday, February 9th, 1994']"));
        dayInput.click();

        WebElement subjectInput = driver.findElement(By.xpath("//*[@id=\"subjectsInput\"]"));
        subjectInput.sendKeys("Computer Science");
        subjectInput.sendKeys(Keys.ENTER);

        List<WebElement> hobbies = driver.findElements(By.xpath("//*[@type='checkbox']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", hobbies.get(2));

        WebElement addressInput = driver.findElement(By.id("currentAddress"));
        addressInput.sendKeys("Lima - Peru");

        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys("Haryana");
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys("Panipat");
        cityInput.sendKeys(Keys.ENTER);

        WebElement submitBtn = driver.findElement(By.id("submit"));
        WebDriverWait wait = new WebDriverWait(driver,10 );
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        String successfulMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertEquals(successfulMessage,"Thanks for submitting the form");

    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
