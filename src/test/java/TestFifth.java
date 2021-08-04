import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestFifth extends setup {

    @BeforeMethod
    public void lunchUrlAndLogin() throws InterruptedException {
        driver.get("http://testphp.vulnweb.com/login.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='uname']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='login']")).click();
        Thread.sleep(5000);
    }

    @Test
    public void cart(){
        driver.findElement(By.xpath("//div[@id='globalNav']//a[contains(@href,'cart')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String pageTitle = driver.getTitle();
        String productId = driver.findElement(By.xpath("//div[@class='story']//tr/td[1]")).getText();
        String title = driver.findElement(By.xpath("//div[@class='story']//tr/td[2]")).getText();
        String artist = driver.findElement(By.xpath("//div[@class='story']//tr/td[3]")).getText();
        String category = driver.findElement(By.xpath("//div[@class='story']//tr/td[4]")).getText();
        String price = driver.findElement(By.xpath("//div[@class='story']//tr/td[5]")).getText();

        Assert.assertEquals("you cart",pageTitle);
        Assert.assertEquals("Product id",productId);
        Assert.assertEquals("Title",title);
        Assert.assertEquals("Artist",artist);
        Assert.assertEquals("Category",category);
        Assert.assertEquals("Price",price);
    }

}
