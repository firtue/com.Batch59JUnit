package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

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
        // 1- amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDeperi= driver.getWindowHandle();

        // 2- nutella için aram yaptırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        /*
        CDwindow-B3AE561D62E30C74B77E18A5753C26A6
        bu kod açılan sayfanın unique hash kodudur
        Selenium sayfalar arası geçişte bu window handle değerini kullanır

        eğer sayfalar arasında driver'ımızı gezdiriyorsak ve herhangi bir sayfadan
        şuanda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("CDwindow-B3AE561D62E30C74B77E18A5753C26A6");
        bu sayfanın window handle değerini girerek bu sayfaya geçişi sağlayabiliriz
         */

        // 3- ilk ürünün resmini tıklayarak farklı bir tab olarak açın

        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandığımızda driver otomatik olarak oluşturulan new Tab'a geçer
        Yeni tab'da görevi gerçekleştirmek için adımları baştan almamız gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        ilkUrunResmi.click();

        // 4- yeni tab'da açılan ürünün fiyatını yazdırın //span[@id="productTitle"]
        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        System.out.println(urunTitleElementi.getText());
        System.out.println("ikinci tab'ın url'si: "+driver.getCurrentUrl());

        // ilk sayfaya geçip url'i yazdıralım
        driver.switchTo().window(ilkSayfaHandleDeperi);
        System.out.println("biinci tab'ın url'si: "+driver.getCurrentUrl());
    }
}
