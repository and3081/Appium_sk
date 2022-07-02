package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.hooks.BaseTest;
import ru.vasyukov.pages.BasePageObject;

public class Tests extends BaseTest {
    @DisplayName("Тестирование Wiki - изменение Settings")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest01")
    public void test01(String platform, String deviceName, String versionOS,
                           String title, int counts) {
        connect(platform, deviceName, versionOS);
        BasePageObject.initPageMain(driver)
                .clickButtonMenu()
                .clickItemSettings()
                .nextPageWikiSettings()
                .checkTitle(title)
                .listSettings(counts)
                .switchAllSettings()
                .checkAllSettings()
                .switchAllSettings()
                .checkAllSettings();
    }

    @DisplayName("Тестирование Wiki - поиск")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest02")
    public void test02(String platform, String deviceName, String versionOS,
                       String textSearch, String searchResultText, String title) {
        connect(platform, deviceName, versionOS);
        BasePageObject.initPageMain(driver)
                .initSearch()
                .nextPageWikiSearch()
                .findByText(textSearch)
                .searchInResults(searchResultText)
                .assertTopicTitle(title);
    }

    @DisplayName("Тестирование Wiki - свайп до title, клик картинки")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest03")
    public void test03(String platform, String deviceName, String versionOS,
                       String title) {
        connect(platform, deviceName, versionOS);
        BasePageObject.initPageMain(driver)
                .swipeUpToTitleAndClick(title)
                .checkGalleryImage();
    }

    @DisplayName("Тестирование Wiki - неудачный поиск")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest04")
    public void test04(String platform, String deviceName, String versionOS,
                       String searchText) {
        connect(platform, deviceName, versionOS);
        BasePageObject.initPageMain(driver)
                .initSearch()
                .nextPageWikiSearch()
                .findByText(searchText)
                .assertEmpty(searchText);
        pause(2000);
    }
}
