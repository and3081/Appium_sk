package ru.vasyukov.properties;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс экзекутор для работы с проперти
 * usage:  TestData.props.имяМетодаКлюча()
 */
public class TestData {
    /**
     * static метод для работы с проперти из файла appium.properties
     */
    public static Appium appium = ConfigFactory.create(Appium.class);
}
