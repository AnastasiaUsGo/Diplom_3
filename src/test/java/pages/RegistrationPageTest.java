package pages;

import base.BaseUrls;
import base.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegistrationPageTest {

    private WebDriver driver;
    private BaseUrls baseUrls;
    private RegistrationPage registration;
    private UserGenerator user;
    private String name;
    private String email;

    @Before
    public void beginning() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // для яндекса
        System.setProperty("webdriver.chrome.driver", "/path/to/webdriver/bin/chromedriver.exe"); // для хрома
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        registration = new RegistrationPage(driver);
        user = new UserGenerator();
        baseUrls = new BaseUrls(driver);
        name = user.createFirstName();
        email = user.createEmail();
        baseUrls.openPage(baseUrls.getRegistrationUrl());
    }

    @Test
    @DisplayName("Проверка регистрации с корректным паролем")
    public void checkingRegistrationWithValidPassword() {
        registration.registerUser(name, email, user.createValidPassword());
        registration.checkingSuccessfulRegistration();
    }

    @Test
    @DisplayName("Проверка регистрации с некорректным паролем")
    public void checkingRegistrationWithInvalidPassword() {
        registration.registerUser(name, email, user.createInvalidPassword());
        registration.checkingUnsuccessfulRegistration();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}