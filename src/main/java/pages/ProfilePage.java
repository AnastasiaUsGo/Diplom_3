package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    //Кнопка профиль
    private final By buttonProfile = By.xpath("//a[text()='Профиль']");
    //Кнопка выхода из аккаунта
    private final By buttonExit = By.xpath("//button[text()='Выход']");
    // Кнопка конструктор
    private final By buttonConstructor = By.xpath("//p[text()='Конструктор']");
    // Логотип Stellar Burgers
    private final By buttonStellarBurgers = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что кнопка профиль отображается")
    public void checkingButtonProfile() {
        Assert.assertTrue(driver.findElement(buttonProfile).isDisplayed());
    }

    @Step("Нажатие на кнопку Конструктора")
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("Нажатие по логотипу Stellar Burgers.")
    public void clickButtonStellarBurgers() {
        driver.findElement(buttonStellarBurgers).click();
    }

    @Step("Нажатие на кнопку Выход")
    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }
}
