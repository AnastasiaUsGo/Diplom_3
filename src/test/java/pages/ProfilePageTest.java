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

public class ProfilePageTest {

        private WebDriver driver;
        private BaseUrls baseUrls;
        private RegistrationPage registration;
        private LoginPage loginPage;
        private HomePage homePage;
        private ProfilePage profilePage;
        private UserGenerator user;
        private String email;
        private String password;
        private String name;

        @Before
        public void beginning() {
            //System.setProperty("webdriver.chrome.driver", "/path/to/webdriver/bin/yandexdriver.exe"); // для яндекса
            System.setProperty("webdriver.chrome.driver", "/path/to/webdriver/bin/chromedriver.exe"); // для хрома
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
            registration = new RegistrationPage(driver);
            loginPage = new LoginPage(driver);
            profilePage = new ProfilePage(driver);
            baseUrls = new BaseUrls(driver);
            user = new UserGenerator();
            name = user.createFirstName();
            email = user.createEmail();
            password = user.createValidPassword();
            baseUrls.openPage(baseUrls.getRegistrationUrl());
            registration.registerUser(name, email,password);
            loginPage.waitButtonLogin();
            loginPage.enterUser(email, password);
        }

        @Test
        @DisplayName("Проверка перехода в личный кабинет")
        public void transitionPersonalAccount() {
            homePage.clickPersonalAccount();
            profilePage.checkingButtonProfile();
        }

        @Test
        @DisplayName("Проверка перехода в конструктор через кнопку конструктор")
        public void checkConstructorButton() {
            homePage.clickPersonalAccount();
            profilePage.clickButtonConstructor();
            homePage.checkingAccountLogin();
        }

        @Test
        @DisplayName("Проверка перехода в конструктор через логотип")
        public void checkStellarBurgersLogo() {
            homePage.clickPersonalAccount();
            profilePage.clickButtonStellarBurgers();
            homePage.checkingAccountLogin();
        }

        @Test
        @DisplayName("Проверка выхода из аккаунта")
        public void exitingAccount() {
            homePage.clickPersonalAccount();
            profilePage.clickButtonExit();
            baseUrls.openPage(baseUrls.getHomeUrl());
            homePage.checkingExitingAccount();
        }

        @After
        public void closeBrowser() {
            driver.quit();
        }
}