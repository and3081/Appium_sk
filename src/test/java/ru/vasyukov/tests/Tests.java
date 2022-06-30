package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.hooks.BaseTest;
import ru.vasyukov.pages.BasePageObject;
import ru.vasyukov.pages.PageWikiMain;

public class Tests extends BaseTest {
    @DisplayName("Тестирование Wiki - ")
    @ParameterizedTest(name = "{arguments}")
    @MethodSource("ru.vasyukov.tests.DataProvider#providerTest01")
    public void test01(String platform, String deviceName, String versionOS,
                           String title) {
        connect(platform, deviceName, versionOS);
        BasePageObject.initPageMain(driver)
                .clickButtonMenu()
                .clickItemSettings()
                .nextPageWikiSettings()
                .checkTitle(title);
        pause(2000);

//        //
//        onboardingPage.skipOnboarding();
//        // click на search поле - переход на страницу поиска
//        startPage.initSearch();
//        // ввод в поиск Java - ищется сразу по вводу
//        searchPage.findByText(searchText);
//        // ищем в рез-тах "Island of Indonesia" и кликаем - выдается статья
//        searchPage.selectByText(searchResultText);
//        // проверка в статье "Island in Indonesia"
//        searchPage.assertByText(topicResultText);
    }

//    @DisplayName("Тестирование Wiki - поиск 'wfewfewfwegweg'")
//    @ParameterizedTest(name = "{arguments}")
//    @MethodSource("ru.vasyukov.tests.DataProvider#providerSearchNegative")
//    public void testSearchNegative(String platform, String deviceName, String versionOS,
//                                   String searchText) {
//        connect(platform, deviceName, versionOS);
        // созд.объектов в зависимости от платформы
//        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver, platform);
//        IStartPageObject startPage = StartPageFactory.get(this.driver, platform);
//        ISearchPageObject searchPage = SearchPageFactory.get(this.driver, platform);
//
//        //
//        onboardingPage.skipOnboarding();
//        // click на search поле - переход на страницу поиска
//        startPage.initSearch();
//        // ввод в поиск wfewfewfwegweg - ищется сразу по вводу
//        searchPage.findByText(searchText);
//        // проверка No results found
//        searchPage.assertEmpty(searchText);
//    }
}
