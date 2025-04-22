package pages;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By ACCEPT_COOKIES_BUTTON = By.xpath("//div[contains(text(),'Tümünü kabul et')]");
    public static final By CLOSE_DEFAULT_OPTIONS = By.className("c_neb-item-close");

    public static final By DEPARTURE_FIELD = By.xpath("//input[@aria-label='Uçuşun kalkış noktası']");
    public static final By DOHA_OPTION = By.xpath("//span[contains(text(),'Doha')]");

    public static final By DESTINATION_FIELD = By.xpath("//input[@aria-label='Uçuşun varış noktası']");
    public static final By NARITA_OPTION = By.xpath("//span[contains(text(),'Narita')]");

    public static final By DEPARTURE_DATE = By.xpath("//div[contains(@aria-label, '28 Nisan')]");
    public static final By RETURN_DATE = By.xpath("//div[contains(@aria-label, '5 Mayıs')]");

    public static final By INCREASE_ADULTS = By.xpath("//span[text()='Yetişkin']/parent::div//button[@aria-label='Artan']");
    public static final By INCREASE_STUDENTS = By.xpath("//span[text()='Öğrenci']/parent::div//button[@aria-label='Artan']");
    public static final By INCREASE_CHILDREN = By.xpath("//span[text()='Çocuk']/parent::div//button[@aria-label='Artan']");

    public static final By SEARCH_BUTTON = By.xpath("//button[@aria-label='Ara']");
}
