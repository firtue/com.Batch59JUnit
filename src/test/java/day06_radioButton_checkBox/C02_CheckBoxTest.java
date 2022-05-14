package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBoxTest {
    WebDriver driver;

    //1. Bir class oluşturun : CheckBoxTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://theinternet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkBox1.isSelected()){ // seçili değil ise
            checkBox1.click();
        }

        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }

}
