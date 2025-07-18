package com.tusur;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class NegativeTests extends BaseTest {

    @Test
    public void testLargeValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("125");
        driver.findElement(By.name("b")).sendKeys("125");
        driver.findElement(By.name("c")).sendKeys("125");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='text-danger' and contains(., 'Стороны могут иметь длину от 1 до 100')]")
        ));

        assertEquals("Стороны могут иметь длину от 1 до 100", result.getText());
    }

    @Test
    public void testRealValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("10");
        driver.findElement(By.name("b")).sendKeys("7");
        driver.findElement(By.name("c")).sendKeys("6,5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Вещественные значения')]")
        ));

        assertEquals("Вещественные значения", result.getText());
    }

    @Test
    public void testBoundaryValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("1");
        driver.findElement(By.name("c")).sendKeys("1");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Граничные значения')]")
        ));

        assertEquals("Граничные значения", result.getText());
    }

    @Test
    public void testEmptyFields() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("");
        driver.findElement(By.name("b")).sendKeys("1");
        driver.findElement(By.name("c")).sendKeys("1");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='text-danger' and contains(., 'Не все обязательные поля для ввода были заполнены')]")
        ));

        assertEquals("Не все обязательные поля для ввода были заполнены", result.getText());
    }

    @Test
    public void testEmptyFields2() {
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
                By.xpath("//li[contains(., 'Одно поле пустое')]")
        ));

        assertEquals("Одно поле пустое", result.getText());
    }

    @Test
    public void testNotTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("2");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Не выполнилось условие треугольника')]")
        ));

        assertEquals("Не выполнилось условие треугольника", result.getText());
    }

    @Test
    public void testNonNumericValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("10");
        driver.findElement(By.name("b")).sendKeys("7");
        driver.findElement(By.name("c")).sendKeys("A");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Нечисловые значения')]")
        ));

        assertEquals("Нечисловые значения", result.getText());
    }

    @Test
    public void testNegativeValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("1");
        driver.findElement(By.name("c")).sendKeys("-1");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Отрицательные значения')]")
        ));

        assertEquals("Отрицательные значения", result.getText());
    }

    @Test
    public void testCleanValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("1");
        driver.findElement(By.name("c")).sendKeys("1");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();
        // Нажимаем кнопку очистки
        driver.findElement(By.name("reset")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Очистить поля')]")
        ));

        assertEquals("Очистить поля", result.getText());
    }

    @Test
    public void testZeroValues() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("0");
        driver.findElement(By.name("b")).sendKeys("1");
        driver.findElement(By.name("c")).sendKeys("1");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Проверка 0')]")
        ));

        assertEquals("Проверка 0", result.getText());
    }

    @Test
    public void testItsNotTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("1");
        driver.findElement(By.name("b")).sendKeys("2");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='text-danger' and contains(., 'Треугольник не возможно построить')]")
        ));

        assertEquals("Треугольник не возможно построить", result.getText());
    }
}