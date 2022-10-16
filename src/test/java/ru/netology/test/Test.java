package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.data.DataBase;
import ru.netology.data.DataHelper;
import ru.netology.data.UserData;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class Test {

    UserData userData;
    LoginPage login;


    @BeforeEach
    public void setup() {
        open("http://localhost:9999/");
        userData = DataHelper.validUser();
        login = new LoginPage();
    }

    @AfterEach
    public void after() {
        DataBase.resetStatus(userData.getName());
        DataBase.resetVerifyCode();
    }

    @AfterAll
    public static void afterAll() {
        DataBase.resetBase();
    }

    @org.junit.jupiter.api.Test
    public void validData() {
        login.input(userData.getName(), userData.getPassword());
        VerificationPage verification = new VerificationPage();
        verification.input(DataHelper.validVerifyCode(userData.getName()));
        DashboardPage dashboard = new DashboardPage();
        dashboard.visiblePage();


    }

    @org.junit.jupiter.api.Test
    public void blockedInvalidPass() {
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        login.input(userData.getName(), DataHelper.invalidPass());
        login.failedInputData();
        DataHelper.assertStatus(userData.getName());
    }
}