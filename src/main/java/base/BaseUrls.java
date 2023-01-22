package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BaseUrls {

    //Страница регистрации
    private final String registrationUrl = "https://stellarburgers.nomoreparties.site/register";
    // Домашняя страница
    private final String homeUrl = "https://stellarburgers.nomoreparties.site";
    private final String forgotPasswordUrl = "https://stellarburgers.nomoreparties.site/forgot-password";

    private final WebDriver driver;

    public BaseUrls(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы")
    public void openPage(String url) {
        driver.get(url);
    }

    @Step("Получение URL домашней страницы")
    public String getHomeUrl() {
        return homeUrl;
    }

    @Step("Получение URL страницы регистрации")
    public String getRegistrationUrl() {
        return registrationUrl;
    }

    @Step("Получение URL страницы восстановления пароля")
    public String getForgotPasswordUrl() {
        return forgotPasswordUrl;
    }
}
