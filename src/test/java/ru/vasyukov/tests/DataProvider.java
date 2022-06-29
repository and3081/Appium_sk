package ru.vasyukov.tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Класс провайдера данных для тестов
 */
@SuppressWarnings("unused")
public class DataProvider {
    /**
     * Метод-провайдер для тест-кейса testSearchPositive()
     * @return  стрим аргументов: список: платформа, девайс, ОС,
     *                                    поиск, результат в поиске, результат в статье
     */
    protected static Stream<Arguments> providerTest01() {
        return Stream.of(arguments("android", "ver10", "10.0",
                "Java", "Island of Indonesia", "Island in Indonesia"));
    }

    /**
     * Метод-провайдер для тест-кейса testSearchNegative()
     * @return  стрим аргументов: список: платформа, девайс, ОС,
     *                                    поиск, результат в поиске
     */
    protected static Stream<Arguments> providerSearchNegative() {
        return Stream.of(arguments("android", "ver10", "10.0",
                "wfewfewfwegweg"));
    }
}
