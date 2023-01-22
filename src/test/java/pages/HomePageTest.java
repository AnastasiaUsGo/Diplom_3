package pages;

import base.BaseUrls;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;
    private BaseUrls baseUrls;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // для яндекса
        System.setProperty("webdriver.chrome.driver", "/path/to/webdriver/bin/chromedriver.exe"); // для хрома
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        baseUrls = new BaseUrls(driver);
        baseUrls.openPage(baseUrls.getHomeUrl());
    }

    @Test
    @DisplayName("Проверка перехода в раздел Булки")
    public void checkBunsSection() {
        homePage.clickSectionFilling();
        homePage.clickSectionBun();
        homePage.checkSectionBun();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Соусы")
    public void checkSauceSection() {
        homePage.clickSectionSauce();
        homePage.checkSectionSauce();
    }

    @Test
    @DisplayName("Проверка перехода в раздел Начинки")
    public void checkFillingSection() {
        homePage.clickSectionFilling();
        homePage.checkSectionFilling();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}