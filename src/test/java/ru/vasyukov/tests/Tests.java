package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.hooks.BaseTest;
import ru.vasyukov.pages.BasePageObject;

public class Tests extends BaseTest {
//    @DisplayName("Тестирование Wiki - изменение Settings")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest01")
//    public void test01(String platform, String deviceName, String versionOS,
//                           String title, int counts) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .clickButtonMenu()
//                .clickItemSettings()
//                .nextPageWikiSettings()
//                .checkTitle(title)
//                .listSettings(counts)
//                .switchAllSettings()
//                .checkAllSettings()
//                .switchAllSettings()
//                .checkAllSettings();
//    }
//
//    @DisplayName("Тестирование Wiki - поиск")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest02")
//    public void test02(String platform, String deviceName, String versionOS,
//                       String textSearch, String searchResultText, String title) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .initSearch()
//                .nextPageWikiSearch()
//                .findByText(textSearch)
//                .searchInResults(searchResultText)
//                .assertTopicTitle(title);
//    }
//
//    @DisplayName("Тестирование Wiki - свайп до title, клик картинки")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest03")
//    public void test03(String platform, String deviceName, String versionOS,
//                       String title) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .swipeUpForTitleAndClickImage(title)
//                .checkGalleryImage();
//    }
//
//    @DisplayName("Тестирование Wiki - неудачный поиск")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest04")
//    public void test04(String platform, String deviceName, String versionOS,
//                       String searchText) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .initSearch()
//                .nextPageWikiSearch()
//                .findByText(searchText)
//                .assertEmpty(searchText);
//    }
//
//    @DisplayName("Тестирование Wiki - свайп до title, Поделиться, Maps")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest05")
//    public void test05(String platform, String deviceName, String versionOS,
//                       String title, String name) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .swipeUpForTitleAndClickShare(title)
//                .nextPageWikiShare()
//                .checkShareButtonName(name);
//    }
//
//    @DisplayName("Тестирование Wiki - свайп до title, Поделиться, Bluetooth")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest06")
//    public void test06(String platform, String deviceName, String versionOS,
//                       String title, String name) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .swipeUpForTitleAndClickShare(title)
//                .nextPageWikiShare()
//                .checkShareButtonName(name);
//    }
//
//    @DisplayName("Тестирование Wiki - свайп до title, Поделиться, Gmail")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest07")
//    public void test07(String platform, String deviceName, String versionOS,
//                       String title, String name) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .swipeUpForTitleAndClickShare(title)
//                .nextPageWikiShare()
//                .checkShareButtonName(name);
//    }
//
//    @DisplayName("Тестирование Wiki - свайп до title, Поделиться, Messages")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest08")
//    public void test08(String platform, String deviceName, String versionOS,
//                       String title, String name) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .swipeUpForTitleAndClickShare(title)
//                .nextPageWikiShare()
//                .checkShareButtonName(name);
//    }
//
//    @DisplayName("Тестирование Wiki - свайп до title, Download")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest09")
//    public void test09(String platform, String deviceName, String versionOS,
//                       String title, String name) {
//        connect(platform, deviceName, versionOS);
//        BasePageObject.initPageMain(driver)
//                .swipeUpForTitleAndClickDownload(title)
//                .checkButtonAllow();
//    }

    @DisplayName("Тестирование Wiki - свайп до title, Download")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest10")
    public void test10(String platform, String deviceName, String versionOS,
                       String title, String name) {
        connect(platform, deviceName, versionOS);
        BasePageObject.initPageMain(driver)
                .swipeUpForTitleAndClickDownload(title)
                .checkButtonAllow();
        pause(2000);
    }
}
