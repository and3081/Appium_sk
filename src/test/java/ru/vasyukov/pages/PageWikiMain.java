package ru.vasyukov.pages;

import io.qameta.allure.Step;

@SuppressWarnings("FieldCanBeLocal")
public class PageWikiMain extends BasePageObject {
    private final String MENU_BUTTON = "id:org.wikipedia:id/menu_overflow_button";
    private final String MENU_ITEM_SETTINGS = "id:org.wikipedia:id/explore_overflow_settings";
    private final String INIT_SEARCH = "id:org.wikipedia:id/search_container";
    private final String TITLE_CARD_IMAGE =
            "xpath://android.widget.LinearLayout" +
                    "[./*/*/*/android.widget.TextView[@resource-id='org.wikipedia:id/view_card_header_title' and @text='{TEXT}']]" +
                    "//*[@resource-id='org.wikipedia:id/view_featured_image_card_image']";
    private final String GALLERY_IMAGE = "id:org.wikipedia:id/gallery_image";
    private final String TITLE_CARD_SHARE =
            "xpath://android.widget.LinearLayout" +
                    "[./*/*/*/android.widget.TextView[@resource-id='org.wikipedia:id/view_card_header_title' and @text='{TEXT}']]" +
                    "//*[@resource-id='org.wikipedia:id/view_card_action_footer_share_button']";
    private final String TITLE_CARD_DOWNLOAD =
            "xpath://android.widget.LinearLayout" +
                    "[./*/*/*/android.widget.TextView[@resource-id='org.wikipedia:id/view_card_header_title' and @text='{TEXT}']]" +
                    "//*[@resource-id='org.wikipedia:id/view_card_action_footer_button']";
    private final String DOWNLOAD_BUTTON_ALLOW = "id:com.android.permissioncontroller:id/permission_allow_button";
    private final String FOOTER_BUTTON_MY_LISTS =
            "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    private final String FOOTER_BUTTON_HISTORY =
            "xpath://android.widget.FrameLayout[@content-desc='History']";
    private final String FOOTER_BUTTON_NEARBY =
            "xpath://android.widget.FrameLayout[@content-desc='Nearby']";
    private final String HEADER_TEXT =
            "xpath://android.view.ViewGroup" +
                    "[@resource-id='org.wikipedia:id/single_fragment_toolbar']//*[@text='{TEXT}']";

    @Step("???????? ???????????? ????????")
    public PageWikiMain clickButtonMenu() {
        waitForElementAndClick(MENU_BUTTON, "???????????? ????????");
        return this;
    }

    @Step("???????? ?????????? Settings")
    public PageWikiMain clickItemSettings() {
        waitForElementAndClick(MENU_ITEM_SETTINGS, "?????????? Settings");
        return this;
    }

    @Step("???????? ?? ??????????")
    public PageWikiMain initSearch() {
        waitForElementAndClick(INIT_SEARCH, "???????? ?? ??????????");
        return this;
    }

    @Step("Swipe ???? title {title} ?? ???????? ????????????????")
    public PageWikiMain swipeUpForTitleAndClickImage(String title) {
        swipeUpToFindElementAndClick(templateByText(TITLE_CARD_IMAGE, title), 10, "title '" + title + "'");
        return this;
    }

    @Step("???????????????? ???????????????? ??????????????")
    public PageWikiMain checkGalleryImage() {
        waitForElementVisible(GALLERY_IMAGE, "????????????????");
        windowScreenshot("????????????????");
        return this;
    }

    @Step("Swipe ???? title {title} ?? ???????? ????????????????????")
    public PageWikiMain swipeUpForTitleAndClickShare(String title) {
        swipeUpToFindElementAndClick(templateByText(TITLE_CARD_SHARE, title), 10, "title '" + title + "'");
        return this;
    }

    @Step("Swipe ???? title {title} ?? ???????? Download")
    public PageWikiMain swipeUpForTitleAndClickDownload(String title) {
        swipeUpToFindElementAndClick(templateByText(TITLE_CARD_DOWNLOAD, title), 10, "title '" + title + "'");
        return this;
    }

    @Step("???????????????? ?? Download ???????????? Allow")
    public PageWikiMain checkButtonAllow() {
        waitForElementClickable(DOWNLOAD_BUTTON_ALLOW, "Download - Allow");
        windowScreenshot("Download - Allow");
        return this;
    }

    @Step("???????? ?? ???????????? ???????????? My Lists")
    public PageWikiMain clickFooterButtonMyLists() {
        waitForElementAndClick(FOOTER_BUTTON_MY_LISTS, "My lists");
        return this;
    }

    @Step("???????? ?? ???????????? ???????????? History")
    public PageWikiMain clickFooterButtonHistory() {
        waitForElementAndClick(FOOTER_BUTTON_HISTORY, "History");
        return this;
    }

    @Step("???????? ?? ???????????? ???????????? Nearby")
    public PageWikiMain clickFooterButtonNearby() {
        waitForElementAndClick(FOOTER_BUTTON_NEARBY, "Nearby");
        return this;
    }

    @Step("???????????????? ?? Header ?????????????????? {title}")
    public PageWikiMain checkHeaderTitle(String title) {
        waitForElementVisible(templateByText(HEADER_TEXT, title), title);
        windowScreenshot(title);
        return this;
    }
}
