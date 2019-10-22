package HomeWork.fw;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver driver;
    ArticleHelper article;
    SessionHelper session;
     String browser;

     public static class MyListener extends AbstractWebDriverEventListener {
         private WebDriver wd;
        HelperBase hb = new HelperBase(wd);
         Logger logger = LoggerFactory.getLogger(MyListener.class);
         @Override
         public void beforeFindBy(By by, WebElement element, WebDriver driver) {
             logger.info("Start search element " + by);
         }

         @Override
         public void afterFindBy(By by, WebElement element, WebDriver driver) {
             logger.info(by + "found");
         }

         @Override
         public void onException(Throwable throwable, WebDriver driver) {
             File tmp =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             File screen = new File("src/test/resources/screenshots/screen"+System.currentTimeMillis()+".png");

             try {
                 Files.copy(tmp, screen);
             } catch (IOException e) {
                 e.printStackTrace();
             }
             logger.error("!!!!!!!!!!!!!ERROR!!!!!!!!!!!!",throwable);
             logger.error("screenshot " +screen);
             //hb.takescreenshot();

         }
     }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if(browser.equals(BrowserType.CHROME)){
            driver=new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver (new FirefoxDriver());
        }

        driver.register(new MyListener());

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
