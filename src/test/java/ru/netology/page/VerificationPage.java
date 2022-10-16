package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {

    private SelenideElement verificationCodeField = $("[data-test-id=\"code\"] .input__control");
    private SelenideElement buttonEnter = $("[data-test-id=\"action-verify\"] .button__text");

    public void input(String code) {
        verificationCodeField.val(code);
        buttonEnter.click();
    }

}