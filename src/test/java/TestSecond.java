import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSecond extends setup {
    String expectedLogoutMessage = "You have been logged out. See you back soon.";

    @BeforeMethod
    public void lunchUrlAndLogin(){
        driver.get("http://testphp.vulnweb.com/login.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='uname']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void logout(){
        driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String logoutMessage = driver.findElement(By.xpath("//h1[@id='pageName']")).getText();
        String title = driver.getTitle();
        Assert.assertEquals("logout",title);
        Assert.assertEquals(expectedLogoutMessage,logoutMessage);
    }
}
