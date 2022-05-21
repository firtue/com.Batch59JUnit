package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfasına gidip
        // yeni kayıt oluştur butonuna basın
        // isim kutusunu locate edip,
        // geriye kalan alanları TAB ile dolaşarak formu doldurun
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys("E").sendKeys("r").sendKeys("d").sendKeys("e").sendKeys("m").sendKeys(Keys.TAB)
                .sendKeys("Ergin").sendKeys(Keys.TAB)
                .sendKeys("a.eeeerdemergin@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("1").sendKeys("2").sendKeys("3").sendKeys("4").sendKeys("5").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1").sendKeys(Keys.TAB)
                .sendKeys("Eki").sendKeys(Keys.TAB)
                .sendKeys("2002").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(3000);
    }
}
