package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiSearch extends BasePageObject {
    private final String SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
    private final String SEARCH_EMPTY = "id:org.wikipedia:id/search_empty_view";
    private final String TITLE_RESULTS = "id:org.wikipedia:id/page_list_item_title";
    private final String TOPIC_TITLE = "id:org.wikipedia:id/view_page_title_text";

    @Step("Ввод в поле поиска: '{text}'")
    public PageWikiSearch findByText(String text) {
        waitForElementAndSendKeys(SEARCH_INPUT, text, "Поле ввода");
        return this;
    }

    @Step("Поиск и клик в результатах: '{text}'")
    public PageWikiSearch searchInResults(String text) {
        List<WebElement> list = waitForListMoreCount(TITLE_RESULTS, 0, "Результаты: '" + text + "'")
                .stream()
                .filter(el-> el.getText().equals(text))
                .limit(1)
                .collect(Collectors.toList());
        Assertions.assertEquals(1, list.size(), "Результаты для '" + text + "' не найдены");
        waitRealClick(list.get(0), text);
        return this;
    }

    @Step("Проверка title статьи: '{title}'")
    public PageWikiSearch assertTopicTitle(String title) {
        waitForElementVisibleText(TOPIC_TITLE, title, "Заголовок: '" + title + "'");
        return this;
    }

    @Step("Проверка пустого поиска для: '{text}'")
    public PageWikiSearch assertEmpty(String text) {
        waitForElementPresent(SEARCH_EMPTY, "Должен быть пустой поиск для: '" + text + "'");
        return this;
    }
}
