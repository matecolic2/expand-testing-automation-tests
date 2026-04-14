package Steps;

import Context.TestContext;
import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



public class StepsDefinition {

    private final TestContext context;

    public StepsDefinition(TestContext context) {
        this.context = context;
    }

    // LOGIN

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        context.driver.navigate().to("https://practice.expandtesting.com/login");
    }

    @When("user inputs username {string}")
    public void userInputsUsername(String username) {
        context.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        context.loginPage.inputUsername(username);
    }

    @And("user inputs password {string}")
    public void userInputsPassword(String password) {
        context.loginPage.inputPassword(password);
    }

    @And("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        WebElement submit = context.wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit-login"))
        );

        ((JavascriptExecutor) context.driver).executeScript("arguments[0].click();", submit);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        context.wait.until(ExpectedConditions.urlContains("/secure"));
        Assert.assertEquals(context.driver.getCurrentUrl(), "https://practice.expandtesting.com/secure");
        Assert.assertEquals(context.loginPage.loginMessageText(), "You logged into a secure area!");
    }

    @Then("login message should be {string}")
    public void loginResultShouldBe(String result) {

        if (result.equals("You logged into a secure area!")) {
            context.wait.until(ExpectedConditions.urlContains("/secure"));
            Assert.assertEquals(context.driver.getCurrentUrl(), "https://practice.expandtesting.com/secure");
            Assert.assertTrue(context.loginPage.loginMessageText().contains("You logged into a secure area!"));
        } else {
            WebElement error = context.wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
            );

            Assert.assertTrue(error.getText().contains(result));
        }
    }

    @Given("user is on radio button page")
    public void userIsOnRadioPage() {
        context.driver.navigate().to("https://practice.expandtesting.com/radio-buttons");

    }

    @When("user selects {string} radio button")
    public void userSelectsRadioButton(String color) {

        By locator = By.id(color.toLowerCase());

        WebElement radio = context.wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        ((JavascriptExecutor) context.driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", radio);

        if (!color.equalsIgnoreCase("green")) {
            try {
                context.wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
            } catch (Exception e) {
                ((JavascriptExecutor) context.driver)
                        .executeScript("arguments[0].click();", radio);
            }
        }
    }

    @Then("{string} radio button should be selected")
    public void radioButtonShouldBeSelected(String color) {
        switch (color.toLowerCase()) {
            case "red":
                Assert.assertTrue(context.radioButtonPage.isRedSelected());
                break;
            case "blue":
                Assert.assertTrue(context.radioButtonPage.isBlueSelected());
                break;
            case "green":
                Assert.assertFalse(context.radioButtonPage.isGreenSelected());
                break;
            case "yellow":
                Assert.assertTrue(context.radioButtonPage.isYellowSelected());
                break;
            case "black":
                Assert.assertTrue(context.radioButtonPage.isBlackSelected());
                break;
            case "basketball":
                Assert.assertTrue(context.radioButtonPage.isBasketballSelected());
                break;
            case "football":
                Assert.assertTrue(context.radioButtonPage.isFootballSelected());
                break;
            case "tennis":
                Assert.assertTrue(context.radioButtonPage.isTennisSelected());
                break;
        }
    }

    @Given("user is on drag and drop page")
    public void userIsOnDragAndDropPage() {
        context.driver.get("https://practice.expandtesting.com/drag-and-drop");
    }

    @When("user drags {string} to target")
    public void userDragsToTarget(String item) {
        context.dragNDropPage.dragToTarget(item);
    }

    @Then("{string} should be dropped successfully")
    public void shouldBeDroppedSuccessfully(String item) {
        Assert.assertTrue(
                context.dragNDropPage.isDroppedSuccessfully(item),
                item + " was not dropped correctly"
        );
    }


}
