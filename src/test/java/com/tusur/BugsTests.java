package com.tusur;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class BugsTests extends BaseTest {

    @Test
    public void testDoubleClickToClean() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Нажимаем кнопку очистки
        driver.findElement(By.name("reset")).click();
        // Дублируем нажатие
        driver.findElement(By.name("reset")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Кнопка «Очистить поля» при всех пустых полях заполняет нулями')]")
        ));

        assertEquals("Кнопка «Очистить поля» при всех пустых полях заполняет нулями", result.getText());
    }

    @Test
    public void testBCFieldRealNumbers() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("10");
        driver.findElement(By.name("b")).sendKeys("6,5");
        driver.findElement(By.name("c")).sendKeys("7");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Поле ВC принимает вещественные числа')]")
        ));

        assertEquals("Поле ВC принимает вещественные числа", result.getText());
    }

    @Test
    public void testACFieldRange1To99() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("2");
        driver.findElement(By.name("c")).sendKeys("99");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Поле AС имеет диапазон от 1 до 99')]")
        ));

        assertEquals("Поле AС имеет диапазон от 1 до 99", result.getText());
    }

    @Test
    public void testACFieldNotCheckedForCompleteness() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("1");
        driver.findElement(By.name("c")).sendKeys("");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Поле AС не проверяется на заполненность')]")
        ));

        assertEquals("Поле AС не проверяется на заполненность", result.getText());
    }
}