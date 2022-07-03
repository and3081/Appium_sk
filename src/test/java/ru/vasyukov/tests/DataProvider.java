package ru.vasyukov.tests;

import org.junit.jupiter.params.provider.Arguments;
import ru.vasyukov.properties.TestData;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
@SuppressWarnings("unused")
public class DataProvider {
    /**
     * Методы-провайдеры для тест-кейсов
     * @return  стрим аргументов: список: платформа, девайс, ОС,
     *                            тест-данные...
     */
    protected static Stream<Arguments> providerTest01() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Settings", 4));
    }

    protected static Stream<Arguments> providerTest02() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Wi-Fi", "Wi-Fi", "Wi-Fi"));
    }

    protected static Stream<Arguments> providerTest03() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Picture of the day"));
    }

    protected static Stream<Arguments> providerTest04() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "qqwweerrttyy"));
    }

    protected static Stream<Arguments> providerTest05() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Picture of the day", "Maps"));
    }

    protected static Stream<Arguments> providerTest06() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Picture of the day", "Bluetooth"));
    }

    protected static Stream<Arguments> providerTest07() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Picture of the day", "Gmail"));
    }

    protected static Stream<Arguments> providerTest08() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Picture of the day", "Messages"));
    }

    protected static Stream<Arguments> providerTest09() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Picture of the day"));
    }

    protected static Stream<Arguments> providerTest10() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "My lists"));
    }

    protected static Stream<Arguments> providerTest11() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "History"));
    }

    protected static Stream<Arguments> providerTest12() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Nearby"));
    }

    protected static Stream<Arguments> providerTest13() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Nearby", "History", "My lists"));
    }
}
