package ru.vasyukov.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiSettings extends BasePageObject {
    private final String TITLE = "id:org.wikipedia:id/action_bar";
    private final String LIST_SETTINGS = "id:org.wikipedia:id/list";
    private final String ATTR_SWITCH_ITEM = "org.wikipedia:id/switchWidget";
    private final String CHILDS = "xpath:.//*";

    private List<WebElement> listSettings = null;
    private List<String> listOldValuesSettings = null;
    private List<String> listNewValuesSettings = null;

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

    private void readValuesSettings(List<String> list) {
        if (listSettings != null) {
            listSettings.forEach(el -> list.add(el.getText()));
        } else {
            Assertions.fail("Список опций не найден");
        }
    }

    @Step("Switch всех опций")
    public PageWikiSettings switchAllSettings() {
        if (listSettings != null) {
            listOldValuesSettings = new ArrayList<>(listSettings.size());
            readValuesSettings(listOldValuesSettings);
            listSettings.forEach(el -> waitRealClick(el, null));
            listNewValuesSettings = new ArrayList<>(listSettings.size());
            readValuesSettings(listNewValuesSettings);
        } else {
            Assertions.fail("Список опций не найден");
        }
        return this;
    }

    @Step("Проверка изменения всех опций")
    public PageWikiSettings checkAllSettings() {
        if (listSettings != null) {
            for (int i=0; i<listSettings.size(); i++) {
                if ((!listOldValuesSettings.get(i).equals("ON") && !listOldValuesSettings.get(i).equals("OFF")) ||
                        (!listNewValuesSettings.get(i).equals("ON") && !listNewValuesSettings.get(i).equals("OFF")) ||
                        listNewValuesSettings.get(i).equals(listOldValuesSettings.get(i))) {
                    Assertions.fail(String.format("Опция %d неправильна или не изменилась: %s -> %s",
                            i+1, listOldValuesSettings.get(i), listNewValuesSettings.get(i)));
                }
            }
        } else {
            Assertions.fail("Список опций не найден");
        }
        return this;
    }
}
