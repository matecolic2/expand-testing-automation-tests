package Steps;

import Pages.DragNDropPage;
import Pages.LoginPage;
import Pages.RadioButtonPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StepsDefinition {

    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public RadioButtonPage radioButtonPage;
    public DragNDropPage dragNDropPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        dragNDropPage = new DragNDropPage(driver);
    }

    //----------

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://practice.expandtesting.com/login");
    }

    @When("user inputs username {string}")
    public void userInputsUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        loginPage.inputUsername(username);
    }

    @And("user inputs password {string}")
    public void userInputsPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        WebElement submit = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit-login"))
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        wait.until(ExpectedConditions.urlContains("/secure"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://practice.expandtesting.com/secure");
        Assert.assertEquals(loginPage.loginMessageText(), "You logged into a secure area!");
    }

    @Then("login message should be {string}")
    public void loginResultShouldBe(String result) {

        if (result.equals("You logged into a secure area!")) {
            wait.until(ExpectedConditions.urlContains("/secure"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://practice.expandtesting.com/secure");
            Assert.assertTrue(loginPage.loginMessageText().contains("You logged into a secure area!"));
        } else {
            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
            );

            Assert.assertTrue(error.getText().contains(result));
        }
    }

    @Given("user is on radio button page")
    public void userIsOnRadioPage() {
        driver.navigate().to("https://practice.expandtesting.com/radio-buttons");

    }

    @When("user selects {string} radio button")
    public void userSelectsRadioButton(String color) {

        By locator = By.id(color.toLowerCase());

        WebElement radio = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", radio);

        if (!color.equalsIgnoreCase("green")) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", radio);
            }
        }
    }

    @Then("{string} radio button should be selected")
    public void radioButtonShouldBeSelected(String color) {
        switch (color.toLowerCase()) {
            case "red":
                Assert.assertTrue(radioButtonPage.isRedSelected());
                break;
            case "blue":
                Assert.assertTrue(radioButtonPage.isBlueSelected());
                break;
            case "green":
                Assert.assertFalse(radioButtonPage.isGreenSelected());
                break;
            case "yellow":
                Assert.assertTrue(radioButtonPage.isYellowSelected());
                break;
            case "black":
                Assert.assertTrue(radioButtonPage.isBlackSelected());
                break;
            case "basketball":
                Assert.assertTrue(radioButtonPage.isBasketballSelected());
                break;
            case "football":
                Assert.assertTrue(radioButtonPage.isFootballSelected());
                break;
            case "tennis":
                Assert.assertTrue(radioButtonPage.isTennisSelected());
                break;
        }
    }

    @Given("user is on drag and drop page")
    public void userIsOnDragAndDropPage() {
        driver.get("https://practice.expandtesting.com/drag-and-drop");
    }

    @When("user drags {string} to target")
    public void userDragsToTarget(String item) {
        dragNDropPage.dragToTarget(item);
    }

    @Then("{string} should be dropped successfully")
    public void shouldBeDroppedSuccessfully(String item) {
        Assert.assertTrue(
                dragNDropPage.isDroppedSuccessfully(item),
                item + " was not dropped correctly"
        );
    }
}
