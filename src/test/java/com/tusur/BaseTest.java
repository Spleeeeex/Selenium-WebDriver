package com.tusur;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    public static void globalSetup() {
        // Автоматическое управление версиями
        WebDriverManager.chromedriver().setup();

        // Настройка опций Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeEach
    public void slowDown() throws InterruptedException {
        // Добавляем задержку перед каждым тестом (2 секунды)
        Thread.sleep(2000);
    }

    @AfterEach
    public void afterTest() {
        try {
            // Создаем уникальное имя файла
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
            // Создаем скриншот
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,
                    new File("target" + File.separator + "screenshots" + File.separator + "test_" + timestamp + ".png"));

            // Пауза 2 секунды
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Не удалось сделать скриншот: " + e.getMessage());
        }
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        if (driver != null) {
            // Добавляем задержку 10 секунд перед закрытием
            Thread.sleep(10000);
            driver.quit();
        }
    }
}