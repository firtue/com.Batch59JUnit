package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DropSownOptions {
    /*
    Amazon anasayfaya gidip
    dropdown menuden books'u secelim
    sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplam sayisinin
    23 oldugunu test edin
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://www.amazon.com");

    }
}
