import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestOne extends setup {

    @BeforeMethod
    public void lunchUrl(){
        driver.get("http://testphp.vulnweb.com/login.php");
    }

    @Test(priority = 1)
    public void loginWithValidUser() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='uname']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String title = driver.getTitle();
        Assert.assertEquals("user info",title);
    }

    @Test(enabled = false)
    public void loginWithInValidUser() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='uname']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("rohit");
        driver.findElement(By.xpath("//input[@value='login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String title = driver.getTitle();
        Assert.assertEquals("user info",title);
    }
}
