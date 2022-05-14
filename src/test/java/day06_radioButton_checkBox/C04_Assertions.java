package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
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
        driver.close();
    }

    @Test
    public void test01(){
        // Eğer Test method'unuzda hiçbir test yoksa, test çalıştıktan sonra hiç bir problemle
        // karşılaşılmadığını raporlamak için "tests passed" yazısı çıkar
        /*
            Eğer testleri if ile yaparsak test failed olsa bile kodlar problemsiz çalıştığı için
            kod çalışması bittiğinde ekranın sol alt kısmında test passed yazacaktır
         */

        driver.get("https://www.amazon.com");

        // url'in https://www.facebook.com olduğunu test edin
        /*
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi PASSED");
        } else{
            System.out.println("Url testi FAILED");
        }
         */

        String expectedUrl="https://www.facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farklı çıktı",expectedUrl, actualUrl);
        /*
        Assert ile yaptığımız testler assertion failed olursa Java kodların çalışmasını durdurur
        ve Assert classı'ı bizi hata konusunda bilgilendirir

                    org.junit.ComparisonFailure: Url beklenenden farklı çıktı
                    Expected :https://www.facebook.com
                    Actual   :https://www.amazon.com/
                    <Click to see difference>

        Böylece hatanın ne olduğunu araştırmamıza gerek kalmadan JUnit bize raporlamış olacak
         */
    }
}
