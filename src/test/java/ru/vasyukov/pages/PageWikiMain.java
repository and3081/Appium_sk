package ru.vasyukov.pages;

import io.qameta.allure.Step;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiMain extends BasePageObject {
    private final String MENU_BUTTON = "id:org.wikipedia:id/menu_overflow_button";
    private final String MENU_ITEM_SETTINGS = "id:org.wikipedia:id/explore_overflow_settings";
    private final String INIT_SEARCH = "id:org.wikipedia:id/search_container";

    @Step("Клик Кнопка меню")
    public PageWikiMain clickButtonMenu() {
        waitForElementAndClick(MENU_BUTTON, "Кнопка меню");
        return this;
    }

    @Step("Клик Пункт Settings")
    public PageWikiMain clickItemSettings() {
        waitForElementAndClick(MENU_ITEM_SETTINGS, "Пункт Settings");
        return this;
    }

    @Step("Вход в поиск")
    public PageWikiMain initSearch() {
        waitForElementAndClick(INIT_SEARCH, "Вход в поиск");
        return this;
    }
}
