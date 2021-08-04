import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestFourth extends setup {

    @BeforeMethod
    public void lunchUrl(){
        driver.get("http://testphp.vulnweb.com/guestbook.php");
    }

    @Test
    public void guestBookMessage(){
        driver.findElement(By.xpath("//textarea[@name='text']")).sendKeys("Rohit Singhal");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedMessage = driver.findElement(By.xpath("//div[@class='story']//tr[3]//td")).getText();
        Assert.assertEquals(expectedMessage,"  Rohit Singhal");
    }
}
