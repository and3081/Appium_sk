package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiSettings extends BasePageObject {
    private final String TITLE = "id:org.wikipedia:id/action_bar";
    private final String LIST_SETTINGS = "id:org.wikipedia:id/list";
    private final String ATTR_SWITCH_ITEM = "org.wikipedia:id/switchWidget";
    private final String CHILDS = "xpath:.//*";

    private List<WebElement> listSettings = null;

    @Step("Проверка Title")
    public PageWikiSettings checkTitle(String title) {
        WebElement el = waitForElementVisible(TITLE, "Title");
        List<WebElement> list = waitForChildElementVisible(el, CHILDS, "Title")
                .stream()
                .filter(el1-> el1.getText().equals(title))
                .limit(1)
                .collect(Collectors.toList());
        Assertions.assertEquals(1, list.size(), "Не найден title '" + title + "'");
        Assertions.assertEquals(title, list.get(0).getText(), "Не найден title '" + title + "'");
        return this;
    }

    @Step("Список опций")
    public PageWikiSettings listSettings(int counts) {
        WebElement el = waitForElementVisible(LIST_SETTINGS, "Список опций");
        listSettings = waitForChildElementVisible(el, CHILDS, "Список опций")
                .stream()
                .filter(el1-> {
                    String attr = el1.getAttribute("resource-id");
                    return attr!=null && attr.equals(ATTR_SWITCH_ITEM);})
                .collect(Collectors.toList());
        Assertions.assertEquals(counts, listSettings.size(), "Неправильное количество опций");
        return this;
    }

    @Step("Все опции switch")
    public PageWikiSettings switchListSettings() {
        if (listSettings != null) {
            System.out.println(listSettings.get(0).getText());
            listSettings.forEach(el -> waitRealClick(el, null));
            System.out.println(listSettings.get(0).getText());
        } else {
            Assertions.fail("Список опций не найден");
        }
        return this;
    }
}
