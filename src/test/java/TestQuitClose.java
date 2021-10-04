import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestQuitClose extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void tesDriverQuitClose() throws InterruptedException {
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));

        for(int i=0; i<4;i++){
            clickHere.click();
        }

        Set<String> handlessSet = driver.getWindowHandles();
        List<String> handlessList = new ArrayList<String>(handlessSet);
        Thread.sleep(3000);
        driver.switchTo().window(handlessList.get(0));
        Thread.sleep(6000);
        driver.close();

        Thread.sleep(6000);

        driver.quit();
    }
}
