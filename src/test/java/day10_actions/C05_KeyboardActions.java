package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        // önce arama kutusuna click yapıp
        // sonra harf harf Nutella yazısını yazdıralım
        // sonra da ENTER tuşuna basalım

        Actions actions = new Actions(driver);

        actions.click(aramaKutusu)  // Her harfi de teker teker yollamamıza gerek yok hepsini birden yazabiliriz -> .sendKeys("Nutella")
                .keyDown(Keys.SHIFT)
                .sendKeys("n")      // SHIFT kullanmak zorunlu değil .sendKeys("N") şeklinde de yazabiliriz
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();
    }

}
