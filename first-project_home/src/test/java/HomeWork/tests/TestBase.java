package HomeWork.tests;

import HomeWork.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public  void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        app.stop();
    }
}
