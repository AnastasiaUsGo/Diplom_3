package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class HomePage {

    private final WebDriver driver;
    //Кнопка в раздел булки
    private final By buttonBun = By.xpath("//span[text()='Булки']");
    //Кнопка в раздел Соусы
    private final By buttonSauce = By.xpath("//span[text()='Соусы']");
    //Кнопка в раздел Начинки
    private final By buttonFilling = By.xpath("//span[text()='Начинки']");
    //Кнопка Личный кабинет
    private final By buttonPersonalAccount = By.xpath("//a[@href='/account']/p[text()='Личный Кабинет']");
    //Кнопка Войти в аккаунт
    private final By buttonSignInAccount = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка Оформить заказ
    private final By buttonMakeOrder = By.xpath("//button[text()='Оформить заказ']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вход в Личный кабинет")
    public void clickPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Нажатие по кнопке Войти в аккаунт")
    public void clickButtonSignAccount() {
        driver.findElement(buttonSignInAccount).click();
    }

    @Step("Нажатие на раздел Булки")
    public void clickSectionBun() {
        driver.findElement(buttonBun).click();
    }

    @Step("Нажатие на раздел Соусы")
    public void clickSectionSauce() {
        driver.findElement(buttonSauce).click();
    }

    @Step("Нажатие на раздел Начинки")
    public void clickSectionFilling() {
        driver.findElement(buttonFilling).click();
    }

    @Step("Проверка, что открыт раздел Булки")
    public void checkSectionBun() {
        String expectedText = "Булки";
        String actualText = driver.findElement(buttonBun).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Step("Проверка, что открыт раздел Соусы")
    public void checkSectionSauce() {
        String expectedText = "Соусы";
        String actualText = driver.findElement(buttonSauce).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Step("Проверка, что открыт раздел Начинки")
    public void checkSectionFilling() {
        String expectedText = "Начинки";
        String actualText = driver.findElement(buttonFilling).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Step("Проверка успешного входа в аккаунт (появилась кнопка Оформить заказ)")
    public void checkingAccountLogin() {
        Assert.assertTrue(driver.findElement(buttonMakeOrder).isDisplayed());
    }

    @Step("Проверка выхода (вместо кнопки Оформить заказ кнопка Войти в аккаунт)")
    public void checkingExitingAccount() {
        Assert.assertTrue(driver.findElement(buttonSignInAccount).isDisplayed());
    }
}
