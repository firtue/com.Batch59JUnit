package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {

    @Test
    public void JSExecutor() throws InterruptedException {

        // amazon'a gidin
        driver.get("https://www.amazon.com");

        // asagidaki sign in butonu goruununceye kadar js (javascript) ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(1000);

        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

        // sign in butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",signInButonu);

        Thread.sleep(1000);
    }
}
