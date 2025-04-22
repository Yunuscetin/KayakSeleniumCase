package pages;

import org.openqa.selenium.By;

public class ResultPageLocators {
    public static final By BY_BOOK_ON_KAYAK = By.xpath("//div[@aria-label='KAYAK üzerinden rezerve edin' and @role='button']");
    public static final By BOOK_ON_KAYAK_ACCEPT = By.id("valueSetFilter-vertical-whisky-whisky-label");
    public static final By QUICKEST = By.xpath("//span[contains(text(),'En kısa')]");
    public static final By SHOW_MORE_BUTTON = By.xpath("//div[@class='ULvh-button show-more-button']");
    public static final By TIME_ELEMENTS = By.xpath("//div[@class='vmXl vmXl-mod-variant-large']");
    public static final By STOP_ELEMENTS = By.xpath("//span[contains(@class, 'JWEO-stops-text')]");
    public static final By PRICE_ELEMENTS = By.xpath("//div[@class='e2GB-price-text']");
    public static final By START_DATE = By.xpath("(//div[@class='c2x94-title']/span[2])[1]");
    public static final By END_DATE = By.xpath("(//div[@class='c2x94-title']/span[2])[2]");
    public static final By PASSENGER_COUNT = By.xpath("//div[@class='Z8U5-description Z8U5-mod-theme-default']");
    public static final By DETAIL_PAGE_PRICE = By.xpath("//div[@class='jnTP-display-price']");
    public static final String START_DATE_TEXT = "28 Nis, Pzt";
    public static final String END_DATE_TEXT = "5 May, Pzt";
}
