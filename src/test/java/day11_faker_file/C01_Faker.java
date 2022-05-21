package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String fakeMail = faker.internet().emailAddress();

        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(fakeMail).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
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
