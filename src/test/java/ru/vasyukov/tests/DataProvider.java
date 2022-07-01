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
     * Метод-провайдер для тест-кейса test01()
     * @return  стрим аргументов: список: платформа, девайс, ОС,
     *
     */
    protected static Stream<Arguments> providerTest01() {
        return Stream.of(arguments(TestData.appium.studioPlatform(),
                TestData.appium.studioDeviceName(),
                TestData.appium.studioVersionOs(),
                "Settings", 4));
    }
}
