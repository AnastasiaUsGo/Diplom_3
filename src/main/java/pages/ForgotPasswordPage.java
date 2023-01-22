package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    //Кнопка Войти
    private final By buttonEnter = By.xpath("//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Войти")
    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
}
