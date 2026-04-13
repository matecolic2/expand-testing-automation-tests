package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {

    WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "red")
    WebElement redRadio;

    @FindBy(id = "blue")
    WebElement blueRadio;

    @FindBy(id = "green")
    WebElement greenRadio;

    @FindBy(id = "yellow")
    WebElement yellowRadio;

    @FindBy(id = "black")
    WebElement blackRadio;

    @FindBy(id = "basketball")
    WebElement basketballRadio;

    @FindBy(id = "football")
    WebElement footballRadio;

    @FindBy(id = "tennis")
    WebElement tennisRadio;

    // ---------- ACTIONS ----------

    public void selectRed() {
        redRadio.click();
    }

    public void selectBlue() {
        blueRadio.click();
    }

    public void selectGreen() {
        greenRadio.click();
    }

    public void selectYellow() {
        yellowRadio.click();
    }

    public void selectBlack() {
        blackRadio.click();
    }

    public void selectBasketball() {
        basketballRadio.click();
    }

    // ---------- VALIDATIONS ----------

    public boolean isRedSelected() {
        return redRadio.isSelected();
    }

    public boolean isBlueSelected() {
        return blueRadio.isSelected();
    }

    public boolean isGreenSelected() {
        return greenRadio.isSelected();
    }

    public boolean isYellowSelected() {
        return yellowRadio.isSelected();
    }

    public boolean isBlackSelected() {
        return blackRadio.isSelected();
    }

    public boolean isBasketballSelected() {
        return basketballRadio.isSelected();
    }

    public boolean isFootballSelected() {
        return footballRadio.isSelected();
    }

    public boolean isTennisSelected() {
        return tennisRadio.isSelected();
    }
}
