package ru.vasyukov.pages;

import io.qameta.allure.Step;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiMain extends BasePageObject {
    private final String MENU_BUTTON = "id:org.wikipedia:id/menu_overflow_button";
    private final String MENU_ITEM_SETTINGS = "id:org.wikipedia:id/explore_overflow_settings";
    private final String INIT_SEARCH = "id:org.wikipedia:id/search_container";
    private final String TITLE_CARD_IMAGE =
            "xpath://android.widget.LinearLayout" +
                    "[//android.widget.TextView[@resource-id='org.wikipedia:id/view_card_header_title' and @text='{TEXT}']]" +
                    "//*[@resource-id='org.wikipedia:id/view_featured_image_card_image']";
    private final String GALLERY_IMAGE = "id:org.wikipedia:id/gallery_image";
    private final String TITLE_CARD_SHARE =
            "xpath://android.widget.LinearLayout" +
                    "[//android.widget.TextView[@resource-id='org.wikipedia:id/view_card_header_title' and @text='{TEXT}']]" +
                    "//*[@resource-id='org.wikipedia:id/view_card_action_footer_share_button']";

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

    @Step("Swipe до title {title} и клик картинки")
    public PageWikiMain swipeUpForTitleAndClickImage(String title) {
        swipeUpToFindElementAndClick(templateByText(TITLE_CARD_IMAGE, title), 10, "title '" + title + "'");
        return this;
    }

    @Step("Проверка картинки галереи")
    public PageWikiMain checkGalleryImage() {
        waitForElementVisible(GALLERY_IMAGE, "Картинка");
        return this;
    }

    @Step("Swipe до title {title} и клик поделиться")
    public PageWikiMain swipeUpForTitleAndClickShare(String title) {
        swipeUpToFindElementAndClick(templateByText(TITLE_CARD_SHARE, title), 10, "title '" + title + "'");
        return this;
    }
}
