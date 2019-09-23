package HomeWork.fw;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    ArticleHelper article;
    SessionHelper session;

    public void init() {
        driver = new ChromeDriver();
        //add default wait for WebElement
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //open site
        session = new SessionHelper(driver);
        driver.get("https://en.wikipedia.org");
        article = new ArticleHelper(driver);
    }

    public void stop() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    public ArticleHelper getArticle() {
        return article;
    }

    public SessionHelper getSession() {
        return session;
    }
}
