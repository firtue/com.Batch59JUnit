package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropSownOptions {
    /*
    Amazon anasayfaya gidip
    dropdown menuden books'u secelim
    sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplam sayisinin
    28 oldugunu test edin
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
        WebElement ddm= driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown'][1]"));

        Select select= new Select(ddm);
        select.selectByVisibleText("Books");

        // bir dropdown ile çalışıyorken, son seçilen option'a ulaşmak isterseniz
        // select.getFirstSelectedOption().getText() method'unu kullanmalısınız
        // bu method bize WebElement döndürür,
        // üzerindeki yazıyı yazdırmak için getText() unutulmamalıdır
        System.out.println(select.getFirstSelectedOption().getText());


        //dropdown'daki opsiyonlarin toplam sayisinin 28 oldugunu test edin
        List<WebElement> optionList = select.getOptions();

        int actualOptionSayisi = optionList.size();
        int expectedOptionSayisi = 28;

        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);

    }
}
