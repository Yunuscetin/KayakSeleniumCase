package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ResultPage;
import utils.DriverFactory;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private ResultPage resultPage;

    public StepDefinitions() {
        this.driver = DriverFactory.getDriver();
        this.homePage = new HomePage(driver);
        this.resultPage = new ResultPage(driver);
    }

    @Given("User navigates to the Kayak website")
    public void userNavigatesToTheKayakWebsite() {
        homePage.userNavigatesToTheKayakWebsite();
    }

    @When("User selects flight from Doha to Narita")
    public void userSelectsFlightFromDohaToNarita() {
        homePage.userSelectsFlightFromDohaToNarita();
    }

    @And("User selects {int} adults, {int} student and {int} child")
    public void userSelectsAdultsStudentAndChild(int adults, int student, int child) {
        homePage.userSelectsAdultsStudentAndChild(adults,student,child);
    }

    @And("User clicks Search")
    public void userClicksSearch() {
        homePage.userClicksSearch();
    }

    @And("User filters results by Book on KAYAK")
    public void userFiltersResultsByBookOnKAYAK() {
        resultPage.userFiltersResultsByBookOnKAYAK();
    }

    @And("User clicks Quickest")
    public void userClicksQuickest() {
        resultPage.userClicksQuickest();
    }

    @And("User loads {int} or more flight results by clicking Show more results")
    public void userLoadsOrMoreFlightResultsByClickingShowMoreResults(int count) {
        resultPage.userLoadsOrMoreFlightResultsByClickingShowMoreResults(count);
    }

    @Then("User finds the cheapest flight with one stop and departure after twelve in both directions")
    public void userFindsTheCheapestFlightWithStopAndDepartureAfterTwelveInBothDirections() {
        resultPage.userFindsTheCheapestFlightWithStopAndDepartureAfterTwelveInBothDirections();
    }

    @And("User verifies the dates, passenger count and stop count")
    public void userVerifiesTheDatesPassengerCountAndStopCount() {
        resultPage.userVerifiesTheDatesPassengerCountAndStopCount();
    }

    @And("User verifies the list price matches with the View Deal page")
    public void userVerifiesTheListPriceMatchesWithTheViewDealPage() {
        resultPage.userVerifiesTheListPriceMatchesWithTheViewDealPage();
    }
}
