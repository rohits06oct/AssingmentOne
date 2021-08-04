import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestThird extends setup {

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
    public void userInfo(){
        driver.get("http://testphp.vulnweb.com/userinfo.php");
        boolean nameInputField = driver.findElement(By.xpath("//input[@name='urname']")).isDisplayed();
        boolean creditCardNumberInputField = driver.findElement(By.xpath("//input[@name='ucc']")).isDisplayed();
        boolean emailInputField = driver.findElement(By.xpath("//input[@name='uemail']")).isDisplayed();
        boolean phoneNumberInputField = driver.findElement(By.xpath("//input[@name='uphone']")).isDisplayed();
        boolean addressInputField = driver.findElement(By.xpath("//textarea[@name='uaddress']")).isDisplayed();
        boolean updateButton = driver.findElement(By.xpath("//input[@name='update']")).isDisplayed();

        Assert.assertTrue(nameInputField);
        Assert.assertTrue(creditCardNumberInputField);
        Assert.assertTrue(emailInputField);
        Assert.assertTrue(phoneNumberInputField);
        Assert.assertTrue(addressInputField);
        Assert.assertTrue(updateButton);
    }
}
