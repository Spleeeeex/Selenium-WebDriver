package com.tusur;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveTests extends BaseTest {

    @Test
    public void testRightAngledTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("3");
        driver.findElement(By.name("b")).sendKeys("4");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
         WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                 By.xpath("//li[contains(., 'Прямоугольный треугольник')]")
         ));

         assertEquals("Прямоугольный треугольник", result.getText());
    }

    @Test
    public void testEquilateralTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("5");
        driver.findElement(By.name("b")).sendKeys("5");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Равносторонний треугольник')]")
        ));

        assertEquals("Равносторонний треугольник", result.getText());
    }

    @Test
    public void testIsoscelesTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("3");
        driver.findElement(By.name("b")).sendKeys("3");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Равнобедренный треугольник')]")
        ));

        assertEquals("Равнобедренный треугольник", result.getText());
    }

    @Test
    public void testAcuteTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("6");
        driver.findElement(By.name("b")).sendKeys("7");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Остроугольный треугольник')]")
        ));

        assertEquals("Остроугольный треугольник", result.getText());
    }

    @Test
    public void testObtuseTriangle() {
        // Открываем страницу
        driver.get("https://do.tusur.ru/qa-test2/");

        // Очищаем поле (для надежности)
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
        driver.findElement(By.name("c")).clear();

        // Вводим значения сторон треугольника
        driver.findElement(By.name("a")).sendKeys("10");
        driver.findElement(By.name("b")).sendKeys("7");
        driver.findElement(By.name("c")).sendKeys("5");

        // Нажимаем кнопку расчета
        driver.findElement(By.name("calc")).click();

        // Ожидаем появления результата и проверяем его
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(., 'Тупоугольный треугольник')]")
        ));

        assertEquals("Тупоугольный треугольник", result.getText());
    }
}