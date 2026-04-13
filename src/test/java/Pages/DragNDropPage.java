package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragNDropPage {

    WebDriverWait wait;
    WebDriver driver;
    Actions actions;

    public DragNDropPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By boxA = By.id("column-a");
    By boxB = By.id("column-b");

    //-----------------

    public void scrollHard(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "const rect = arguments[0].getBoundingClientRect();" +
                        "window.scrollTo({" +
                        "top: window.pageYOffset + rect.top - (window.innerHeight / 2)," +
                        "behavior: 'instant'" +
                        "});",
                element
        );
    }

    public void dragToTarget(String item) {

        WebElement source;
        WebElement target;

        if (item.equalsIgnoreCase("a")) {
            source = driver.findElement(By.id("column-a"));
            target = driver.findElement(By.id("column-b"));
        } else {
            source = driver.findElement(By.id("column-b"));
            target = driver.findElement(By.id("column-a"));
        }

        wait.until(ExpectedConditions.visibilityOf(source));
        wait.until(ExpectedConditions.visibilityOf(target));

        // 🔥 HARD SCROLL (force center positioning)
        scrollHard(source);
        scrollHard(target);

        // small stabilization pause
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // drag action
        actions.moveToElement(source)
                .pause(Duration.ofMillis(200))
                .clickAndHold()
                .pause(Duration.ofMillis(300))
                .moveToElement(target)
                .pause(Duration.ofMillis(300))
                .release()
                .build()
                .perform();
    }

    public boolean isDroppedSuccessfully(String item) {

        if (item.equalsIgnoreCase("a")) {
            return getBoxBText().contains("A");
        } else {
            return getBoxAText().contains("B");
        }
    }

    public String getBoxAText() {
        return driver.findElement(boxA).getText();
    }

    public String getBoxBText() {
        return driver.findElement(boxB).getText();
    }
}
