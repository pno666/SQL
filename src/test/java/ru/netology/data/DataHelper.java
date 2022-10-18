package ru.netology.data;

import com.github.javafaker.Faker;


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


}