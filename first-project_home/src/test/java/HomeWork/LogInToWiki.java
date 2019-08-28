package HomeWork;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogInToWiki extends TestBase {
    @Test
    public void logIn(){
        driver.get("https://ru.wikipedia.org");

        driver.findElement(By.id("pt-login")).click();

        driver.findElement(By.id("wpName1")).click();
        driver.findElement(By.id("wpName1")).clear();
        driver.findElement(By.id("wpName1")).sendKeys("Ivan Ivanov");

        driver.findElement(By.id("wpPassword1")).click();
        driver.findElement(By.id("wpPassword1")).clear();
        driver.findElement(By.id("wpPassword1")).sendKeys("123456789");

        driver.findElement(By.id("wpLoginAttempt")).click();



    }
}
