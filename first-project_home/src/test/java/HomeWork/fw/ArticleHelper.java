package HomeWork.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class ArticleHelper extends  HelperBase {
        public ArticleHelper(WebDriver driver) {
            super(driver);
        }

        public void typeRequest(String request) {
            type(By.name("search"), request);
        }

        public void clickGoButton() {
            waitForElementAndClick(By.name("go"), 25);
        }

        public String getArticleTitle() {
            return driver.findElement(By.cssSelector("h1#firstHeading")).getText();
        }
    }

