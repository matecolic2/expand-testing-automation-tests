package Context;

import Pages.DragNDropPage;
import Pages.LoginPage;
import Pages.RadioButtonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {

    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage loginPage;
    public RadioButtonPage radioButtonPage;
    public DragNDropPage dragNDropPage;

    public TestContext() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        dragNDropPage = new DragNDropPage(driver);
    }
}