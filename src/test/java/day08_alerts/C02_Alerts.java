package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
 /*
    ● Bir class olusturun: Alerts

    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    ● Bir metod olusturun: acceptAlert
            ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
            “You successfully clicked an alert” oldugunu test edin.

    ● Bir metod olusturun: dismissAlert
            ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
            “successfuly” icermedigini test edin.

    ● Bir metod olusturun: sendKeysAlert
            ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
            tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
  */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    // Bir metod olusturun: acceptAlert
    @Test
    public void acceptAlert(){
        // 1. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();

        // result mesajının “You successfully clicked an alert” oldugunu test edin.
        WebElement alınanMesaj = driver.findElement(By.xpath("//*[.='You successfully clicked an alert']"));
        String mesaj= alınanMesaj.getText();
        String istenilenMesaj="You successfully clicked an alert";

        Assert.assertEquals(mesaj, istenilenMesaj);
    }

    // Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert(){

        // 2. butona tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();

        // result mesajının “successfuly” icermedigini test edin
        String istenmeyenKelime= "successfuly";
        WebElement alınanMesaj = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String mesaj= alınanMesaj.getText();
        Assert.assertFalse(mesaj.contains(istenmeyenKelime));
    }

    // Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert(){
        // 3.butona tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Erdem Ergin");

        // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();

        WebElement alınanMesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String mesaj= alınanMesaj.getText();

        String istenilenKelime ="Erdem Ergin";
        Assert.assertTrue(mesaj.contains(istenilenKelime));
    }
}
