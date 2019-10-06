package HomeWork.fw;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    ArticleHelper article;
    SessionHelper session;
     String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if(browser.equals(BrowserType.CHROME)){
            driver=new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        }

        //add default wait for WebElement
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //open site
        session = new SessionHelper(driver);
        driver.get("https://en.wikipedia.org");
        article = new ArticleHelper(driver);
    }

    public void stop() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    public ArticleHelper getArticle() {
        return article;
    }

    public SessionHelper getSession() {
        return session;
    }
}
