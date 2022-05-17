package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

    WebDriver driver;
    @Before
    public void setUp(){
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
    public void test01(){
        /*
             herhangi bir web sitesine gidince veya bir websitesinde
             herhangi bir işlem yaptığımızda çıkan uyarışara alert diyoruz

             Eğer bir alert inspect yapılabiliyorsa, o alert otomasyon ile kullanılabilir,
             bu tür alert'lere HTML alert denir ve bunlar için ekstra bir işlem yapmaya gerek yoktur
             tüm websiteler gibi locate edip istedigimiz islemleri yapabiliriz

             Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
             js alert'ler locate edilemez
             Selenium'da JS alert'ler icin ozel bir yontem gelistirmistirAncak web uygu
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // alert'te OK tusuna basin
        driver.switchTo().alert().accept();

        // result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult = "You successfully clicked an alert";

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResultYazisi);

    }
}
