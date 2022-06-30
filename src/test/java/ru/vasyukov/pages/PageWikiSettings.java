package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiSettings extends BasePageObject {
    private final String TITLE = "id:org.wikipedia:id/action_bar";
    private final String TITLE_TEXT = "xpath:.//*"; //android.widget.TextView";

    @Step("Проверка Title")
    public PageWikiSettings checkTitle(String title) {
        WebElement el = waitForElementVisible(TITLE, "Title");
        List<WebElement> list = waitForChildElementVisible(el, TITLE_TEXT, "Title")
                .stream()
                .filter(el1-> el1.getText().equals(title))
                .limit(1)
                .collect(Collectors.toList());
        Assertions.assertEquals(1, list.size(), "Не найден title '" + title + "'");
        Assertions.assertEquals(title, list.get(0).getText(), "Не найден title '" + title + "'");
        return this;
    }

}
