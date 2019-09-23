package HomeWork.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{


    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void confirmLogin() {
        click(By.name("wploginattempt"));
    }

    public void fillLoginForm(String email, String password) {
        waitForElementAndType(By.id("wpName1"), 15,  email);
        // type(By.id("wpName1"),);
        type(By.id("wpPassword1"), password);
    }

    public void initLogin() {
        waitForElementAndClick( By.id("pt-login"),20);
        click(By.id("pt-login"));
    }

    public void openSite(String url) {
        driver.get(url);
    }

}

