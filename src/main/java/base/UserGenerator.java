package base;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class UserGenerator {
    Faker faker = new Faker();

    @Step("Создание рандомного имени")
    public String createFirstName() {
        return faker.name().firstName();
    }

    @Step("Создание рандомной почты")
    public String createEmail() {
        return faker.internet().safeEmailAddress();
    }

    @Step("Создание валидного пароля")
    public String createValidPassword() {
        return faker.internet().password(8, 20);
    }

    @Step("Создание не валидного пароля")
    public String createInvalidPassword() {
        return faker.internet().password(1, 5);
    }

}
