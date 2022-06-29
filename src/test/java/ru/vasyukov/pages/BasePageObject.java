package ru.vasyukov.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.vasyukov.properties.TestData;

import java.io.File;
import java.time.Duration;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class BasePageObject {
    /**
     * объект RemoteWebDriver
     */
    protected static RemoteWebDriver driver;
    /**
     * Значение явного ожидания ms из проперти
     */
    protected static long timeoutInSeconds = Long.parseLong(TestData.appium.defaultTimeoutExplicitSec());
    /**
     * Объект явных ожиданий
     */
    protected static WebDriverWait wait;
    /**
     * Объект Actions
     */
    protected static Actions actions;

    public BasePageObject(RemoteWebDriver driver) {
        BasePageObject.driver = driver;
        wait = new WebDriverWait(driver, timeoutInSeconds);
        actions = new Actions(driver);
    }

    public WebElement waitForElementPresent(String locator, String errorMessage) {
        return wait.withMessage("Ожидание существования элемента исчерпано: " + errorMessage + ":\n" +
                        locator + "\n")
                .until(ExpectedConditions.presenceOfElementLocated(getLocatorByString(locator)));
    }

    public WebElement waitTimeoutForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {
        return new WebDriverWait(driver, timeoutInSeconds)
                .withMessage("Элемент не существует: " + errorMessage + ":\n" +
                        locator + "\n")
                .until(ExpectedConditions.presenceOfElementLocated(getLocatorByString(locator)));
    }

    public WebElement waitForElementVisible(String locator, String errorMessage) {
        return wait.withMessage("Ожидание видимости элемента исчерпано: " + errorMessage + ":\n" +
                        locator + "\n")
                .until(ExpectedConditions.visibilityOfElementLocated(getLocatorByString(locator)));
    }

    public WebElement waitForElementClickable(String locator, String errorMessage) {
        return wait.withMessage("Ожидание кликабельного элемента исчерпано: " + errorMessage + ":\n" +
                        locator + "\n")
                .until(ExpectedConditions.elementToBeClickable(getLocatorByString(locator)));
    }

    public WebElement waitForElementAndClick(String locator, String errorMessage) {
        WebElement el = waitForElementClickable(locator, errorMessage);
        waitRealClick(el, locator);
        return el;
    }

    public WebElement waitForElementAndSendKeys(String locator, String text, String errorMessage) {
        WebElement el = waitForElementVisible(locator, errorMessage);
        waitRealSend(el, locator, text);
        return el;
    }

    public boolean waitForElementNotPresent(String locator, String errorMessage) {
        By by = this.getLocatorByString(locator);
        return wait.withMessage("Ожидание отсутствия элемента исчерпано: " + errorMessage + ":\n" +
                        locator + "\n")
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage) {
        WebElement el = waitForElementVisible(locator, errorMessage);
        el.clear();
        return el;
    }

    public void swipeUp(int timeOfSwipeMs) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);

            action.press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipeMs)))
                    .moveTo(PointOption.point(x, end_y))
                    .release()
                    .perform();
        }
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpToFindElement(String locator, String errorMessage, int max_swipes) {
        int already_swiped = 0;
        while (getAmountOfElements(locator) == 0) {
            if (already_swiped > max_swipes){
                waitTimeoutForElementPresent(locator,
                        "Swipe Up- поиск элемента\n" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public void swipeUpTillElementAppear(String locator, String errorMessage, int max_swipes) {
        int already_swiped = 0;
        while (!isElementLocatedOnTheScreen(locator)) {
            if(already_swiped > max_swipes){
                Assertions.assertTrue(isElementLocatedOnTheScreen(locator),errorMessage);
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator) {
        int element_location_by_y = waitTimeoutForElementPresent(locator,"", 1)
                .getLocation().getY();
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }

    public void clickElementToTheRightSide(String locator, String errorMessage) {
        if (driver instanceof AppiumDriver) {
            WebElement el = waitForElementVisible(locator + "/..", errorMessage);
            int middle_y = el.getLocation().getY() + el.getSize().getHeight() / 2;
            int point_to_click_x = (el.getLocation().getX() + el.getSize().getWidth()) - 3;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            action.tap(PointOption.point(point_to_click_x, middle_y)).perform();
        }
    }

    public void swipeElementToLeft(String locator, String errorMessage) {
        if (driver instanceof AppiumDriver) {
            WebElement el = waitForElementVisible(locator, errorMessage);
            int middle_y = el.getLocation().getY() + el.getSize().getHeight() / 2;
            int left_x = el.getLocation().getX();
            int right_x = left_x + el.getSize().getWidth();
            TouchAction action = new TouchAction((AppiumDriver) driver);
            action.press(PointOption.point(right_x, middle_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(left_x, middle_y))
                    .release()
                    .perform();
        }
    }

    public int getAmountOfElements(String locator) {
        return driver.findElements(getLocatorByString(locator)).size();
    }

    public boolean isElementPresent(String locator) {
        return getAmountOfElements(locator) > 0;
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage) {
        return waitForElementPresent(locator, errorMessage).getAttribute(attribute);
    }

    private By getLocatorByString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);

        if (exploded_locator.length != 2) {
            throw new IllegalArgumentException("В локаторе нет одного символа ':'\n" + locator_with_type);
        }
        String by_type = exploded_locator[0];

        switch (by_type) {
            case "xpath":
                return By.xpath(exploded_locator[1]);
            case "id":
                return By.id(exploded_locator[1]);
            case "css":
                return By.cssSelector(exploded_locator[1]);
            default:
                throw new IllegalArgumentException("Неправильный тип в локаторе\n" + locator_with_type);
        }
    }

    public String takeScreenshotToFile(String filename) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = TestData.appium.pathScreenshot() + "/" + filename + "_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("Скриншот сделан: " + path);
        } catch (Exception e) {
            System.out.println("Скриншот не сделан: " + e.getMessage());
        }
        return path;
    }

    @SuppressWarnings("unused")
    @Attachment(value = "{nameScreenshot}")
    public static byte[] windowScreenshot(String nameScreenshot) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("unused")
    @Attachment(value = "{nameScreenshot}")
    public static byte[] elementScreenshot(WebElement el, String nameScreenshot) {
        return el.getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Ожидание и выполнение реального клика, при ElementClickInterceptedException (перекрытие элемента)
     * отправляется ESC в фокус для попытки снятия попапа
     * @param el     элемент для клика
     * @param locator  для попытки заново получить элемент
     * @return true- клик сделан
     */
    @SuppressWarnings("UnusedReturnValue")
    public boolean waitRealClick(WebElement el, String locator) {
        boolean[] isClick = new boolean[]{false};
        boolean[] isCatch = new boolean[]{false};

        wait.withMessage("Ожидание клика на элемент исчерпано (клик чем-то закрыт):\n" + locator + "\n")
                .until((ExpectedCondition<Boolean>) driver -> {
                    try {
                        if (isCatch[0]) {
                            assert driver != null;
                            driver.findElement(getLocatorByString(locator)).click();  // попытка заново получить элемент
                        } else {
                            el.click();
                        }
                    } catch (ElementClickInterceptedException e) {
                        actions.sendKeys(Keys.ESCAPE).perform();  // попытка снять попап
                        isCatch[0] = false;
                        return false;
                    } catch (Exception e) {
                        isCatch[0] = true; return false;
                    }
                    isClick[0] = true; return true; });
        return isClick[0];
    }

    /**
     * Ожидание и выполнение реального send
     * @param el     элемент для send
     * @param locator  для попытки заново получить элемент
     * @param text   текст для send
     * @return true- send сделан
     */
    @SuppressWarnings("UnusedReturnValue")
    public boolean waitRealSend(WebElement el, String locator, String text) {
        boolean[] isSend = new boolean[]{false};
        boolean[] isCatch = new boolean[]{false};

        wait.withMessage("Ожидание send '"+ text +"' в элемент исчерпано:\n" + locator + "\n")
                .until((ExpectedCondition<Boolean>) driver -> {
                    try {
                        if (isCatch[0]) {
                            assert driver != null;
                            driver.findElement(getLocatorByString(locator)).sendKeys(text);  // попытка заново получить элемент
                        } else {
                            el.sendKeys(text);
                        }
                    } catch (Exception e) {
                        isCatch[0] = true; return false;
                    }
                    isSend[0] = true; return true; });
        return isSend[0];
    }
}