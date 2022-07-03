package ru.vasyukov.pages;

import io.qameta.allure.Step;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiShare extends BasePageObject {
    private final String SHARE_BUTTON_TMPL =
            "xpath://android.widget.ListView[@resource-id='android:id/resolver_list']" +
                    "//*[@resource-id='android:id/text1' and @text='{TEXT}']";

    @Step("Проверка кнопки в Поделиться: {name}")
    public PageWikiShare checkShareButtonName(String name) {
        waitForElementVisible(templateByText(SHARE_BUTTON_TMPL, name),"name '" + name + "'");
        windowScreenshot("Кнопка " + name);
        return this;
    }
}
