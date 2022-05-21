package day12_senkronizasyon;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01__ExplicitlyWait extends TestBase {
    @Test
    public void implicitlyWaitTest(){
        //1. Bir class olusturun : WaitTest

        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //     Iki metod icin de asagidaki adimlari test edin.

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.


        //6. Add buttonuna basin


        //7. It’s back mesajinin gorundugunu test edin

    }
}
