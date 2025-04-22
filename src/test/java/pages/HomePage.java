package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import static pages.HomePageLocators.*;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public HomePage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userNavigatesToTheKayakWebsite() {
        driver.get("https://www.kayak.com.tr/?ispredir=true");
        WebElement lastButton = wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BUTTON));
        lastButton.click();
    }

    public void userSelectsFlightFromDohaToNarita() {
        wait.until(ExpectedConditions.elementToBeClickable(CLOSE_DEFAULT_OPTIONS)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DEPARTURE_FIELD)).sendKeys("Doha (DOH)");
        wait.until(ExpectedConditions.elementToBeClickable(DOHA_OPTION)).click();

        wait.until(ExpectedConditions.elementToBeClickable(DESTINATION_FIELD)).sendKeys("Narita (NRT)");
        wait.until(ExpectedConditions.elementToBeClickable(NARITA_OPTION)).click();

        wait.until(ExpectedConditions.elementToBeClickable(DEPARTURE_DATE)).click();
        wait.until(ExpectedConditions.elementToBeClickable(RETURN_DATE)).click();
    }

    public void userSelectsAdultsStudentAndChild(int adults, int student, int children) {
        WebElement increaseAdults = driver.findElement(INCREASE_ADULTS);
        for (int i = 1; i < adults; i++) {
            increaseAdults.click();
        }

        WebElement increaseStudents = driver.findElement(INCREASE_STUDENTS);
        for (int i = 0; i < student; i++) {
            increaseStudents.click();
        }

        WebElement increaseChildren = driver.findElement(INCREASE_CHILDREN);
        for (int i = 0; i < children; i++) {
            increaseChildren.click();
        }
    }

    public void userClicksSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON)).click();
    }
}
