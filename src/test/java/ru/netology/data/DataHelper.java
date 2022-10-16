package ru.netology.data;

import com.github.javafaker.Faker;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataHelper {

    private static final Faker faker = new Faker();

    public static UserData validUser() {
        return new UserData("vasya", "qwerty123");
    }

    public static String validVerifyCode(String login) {
        return DataBase.getValidVerifyCode(login);
    }

    public static String invalidPass() {
        return faker.internet().password();
    }

    public static void assertStatus(String login) {
        String expected = "blocked";
        String actual = DataBase.userStatus(login);
        assertEquals(expected, actual);
    }

}