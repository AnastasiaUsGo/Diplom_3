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

public class LoginPageTest {

    private BaseUrls baseUrls;
    private RegistrationPage registration;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;
    private HomePage homePage;
    private UserGenerator user;
    private String email;
    private String password;
    private String name;

    private WebDriver driver;

    @Before
    public void beginning() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // для яндекса
        System.setProperty("webdriver.chrome.driver", "/path/to/webdriver/bin/chromedriver.exe"); // для хрома
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        registration = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        loginPage = new LoginPage(driver);
        baseUrls = new BaseUrls(driver);
        user = new UserGenerator();
        name = user.createFirstName();
        email = user.createEmail();
        password = user.createValidPassword();
        baseUrls.openPage(baseUrls.getRegistrationUrl());
        registration.registerUser(name, email,password);
    }

    @Test
    @DisplayName("Проверка входа через личный кабинет")
    public void checkLoginPersonalAccountPage() {
        baseUrls.openPage(baseUrls.getHomeUrl());
        homePage.clickPersonalAccount();
        loginPage.enterUser(email, password);
        homePage.checkingAccountLogin();
    }

    @Test
    @DisplayName("Проверка входа через главную страницу")
    public void checkLoginButtonHomePage() {
        baseUrls.openPage(baseUrls.getHomeUrl());
        homePage.clickButtonSignAccount();
        loginPage.enterUser(email, password);
        homePage.checkingAccountLogin();
    }

    @Test
    @DisplayName("Проверка входа через форму регистрации")
    public void checkLoginRegistrationPage() {
        baseUrls.openPage(baseUrls.getRegistrationUrl());
        registration.clickButtonEnter();
        loginPage.enterUser(email, password);
        homePage.checkingAccountLogin();
    }

    @Test
    @DisplayName("Проверка входа через форму восстановления пароля")
    public void checkLoginForgotPasswordPage() {
        baseUrls.openPage(baseUrls.getForgotPasswordUrl());
        forgotPasswordPage.clickButtonEnter();
        loginPage.enterUser(email, password);
        homePage.checkingAccountLogin();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}