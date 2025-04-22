package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static pages.ResultPageLocators.*;

public class ResultPage {
    private WebDriver driver;
    WebDriverWait wait;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userFiltersResultsByBookOnKAYAK() {
        WebElement byBookOnKAYAK = wait.until(ExpectedConditions.visibilityOfElementLocated(BY_BOOK_ON_KAYAK));
        byBookOnKAYAK.click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
        WebElement byBookOnKayakAccept = wait.until(ExpectedConditions.visibilityOfElementLocated(BOOK_ON_KAYAK_ACCEPT));
        byBookOnKayakAccept.click();
    }

    public void userClicksQuickest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        WebElement quickest = wait.until(ExpectedConditions.visibilityOfElementLocated(QUICKEST));
        quickest.click();

    }

    public void userLoadsOrMoreFlightResultsByClickingShowMoreResults(int count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> flightGroups = driver.findElements(By.className("Fxw9-result-item-container"));
        while (flightGroups.size() <= count) {
            try {
                WebElement showMoreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SHOW_MORE_BUTTON));
                showMoreButton.click();
                Thread.sleep(2000);
                flightGroups = driver.findElements(By.xpath("//div[@role='group']"));
            } catch (Exception e) {
                System.out.println("Show more button not found or not clickable.");
                break;
            }
        }
    }

    public double userFindsTheCheapestFlightWithStopAndDepartureAfterTwelveInBothDirections() {
        List<WebElement> timeElements = driver.findElements(TIME_ELEMENTS);
        List<WebElement> stopElements = driver.findElements(STOP_ELEMENTS);
        List<WebElement> priceElements = driver.findElements(PRICE_ELEMENTS);

        List<Integer> validIndices = new ArrayList<>();
        for (int i = 0; i < timeElements.size(); i++) {
            String timeText = timeElements.get(i).getText().trim();  // Saati al
            String stopText = stopElements.get(i).getText().trim();  // Aktarmayı al
            if (i == 0 || i == 1) {
                System.out.println("Index " + i + " reklam, atlanıyor.");
                continue;
            }

            if (timeText.contains("–")) {
                String departureTime = timeText.split("–")[0].trim(); // İlk saat (kalkış) alınır

                if (departureTime.matches("\\d{1,2}:\\d{2}")) {
                    String[] timeParts = departureTime.split(":");
                    int hour = Integer.parseInt(timeParts[0]);

                    // Saatin 12:00'dan büyük olmasını ve 1 aktarma şartını kontrol et
                    if (hour >= 12 && stopText.contains("1 aktarma")) {
                        validIndices.add(i);  // Uygun index'i listeye ekle
                        System.out.println("Uygun uçuş bulundu, index: " + i + " -> Saat: " + departureTime + ", Aktarma: " + stopText);
                    }
                }
            }
        }

        double minPrice = Double.MAX_VALUE;
        WebElement cheapestFlightElement = null;
        int cheapestPriceIndex = -1;

        for (int i : validIndices) {
            int priceIndex = i / 2;

            if (priceIndex < priceElements.size()) {
                String priceText = priceElements.get(priceIndex).getText().replaceAll("[^\\d.]", "").trim();

                if (!priceText.isEmpty()) {
                    double price = Double.parseDouble(priceText);

                    if (price < minPrice) {
                        minPrice = price;
                        cheapestPriceIndex = (i + 2) / 2;
                        cheapestFlightElement = priceElements.get(priceIndex); // Tıklanacak element
                    }
                }
            }
        }

        if (cheapestFlightElement != null) {
            System.out.println("En ucuz uçuş fiyatı: " + minPrice + ", fiyat indexi: " + cheapestPriceIndex);
            WebElement goToDetailPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class, 'Iqt3-mod-size-small')])[" + cheapestPriceIndex + "]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goToDetailPage);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", goToDetailPage);

        } else {
            System.out.println("Uygun fiyatlı uçuş bulunamadı.");
        }
        return minPrice;
    }

    public void userVerifiesTheDatesPassengerCountAndStopCount() {
        WebElement kayakStartDate = wait.until(ExpectedConditions.visibilityOfElementLocated(START_DATE));
        Assert.assertEquals("Tarihler eşleşmiyor", START_DATE_TEXT, kayakStartDate.getText());
        WebElement kayakEndDate = wait.until(ExpectedConditions.visibilityOfElementLocated(END_DATE));
        Assert.assertEquals("Tarihler eşleşmiyor", END_DATE_TEXT, kayakEndDate.getText());
        Integer passenger = 4;
        WebElement kayakPassenger = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSENGER_COUNT));
        Assert.assertTrue(
                "Yolcu sayısı eşit değil",
                kayakPassenger.getText().contains(passenger.toString())
        );
    }

    public void userVerifiesTheListPriceMatchesWithTheViewDealPage() {
        double listedPrice = userFindsTheCheapestFlightWithStopAndDepartureAfterTwelveInBothDirections();
        WebElement detailPagePrice = wait.until(ExpectedConditions.visibilityOfElementLocated(DETAIL_PAGE_PRICE));
        String lastPrice = detailPagePrice.getText();
        Assert.assertEquals("Fiyat eşleşmiyor!", "₺"+listedPrice, lastPrice);
    }
}
