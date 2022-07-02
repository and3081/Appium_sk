package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiSearch extends BasePageObject {
    private final String SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
    private final String SEARCH_EMPTY = "id:org.wikipedia:id/search_empty_view";
    private final String RESULT_ELEMENT_BY_TEXT = "xpath://*[./*[contains(@text,'{TEXT}')]]";
    private final String TOPIC_TITLE = "id:org.wikipedia:id/view_page_title_text";

    @Step("Ввод в поле поиска: '{text}'")
    public PageWikiSearch findByText(String text) {
        waitForElementAndSendKeys(SEARCH_INPUT, text, "Поле ввода");
        return this;
    }

    @Step("Поиск и клик в результатах: '{text}'")
    public PageWikiSearch searchInResults(String text) {
        waitForElementAndClick(templateByText(RESULT_ELEMENT_BY_TEXT, text), "Результат: '" + text + "'");
        return this;
    }

    public PageWikiSearch assertTopicTitle(String title) {
        waitForElementVisibleText(TOPIC_TITLE, title, "Заголовок: '" + title + "'");
        return this;
    }

//    public void assertEmpty(String text) {
//        this.waitForElementPresent(SEARCH_EMPTY,
//                "Expected No results found, but Results found for: '" + text + "'");
//    }
}
