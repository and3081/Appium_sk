package ru.vasyukov.properties;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для работы с проперти из файла appium.properties и системными проперти
 * usage:  TestData.appium.имяМетодаКлюча()
 * Описание в файле проперти
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:appium.properties"
})
public interface Appium extends Config {
    @Key("base.url")
    String baseUrl();
}
