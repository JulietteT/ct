package ru.netology;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CardOrderTest {

    private WebDriver webdriver;

    @BeforeAll

    public static void setupAll () {
        WebDriverManager.chromedriver ().setup();

        @BeforeEach
                public void beforeEach () {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments ("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get ("http://localhost:9999");
        }
        @AfterEach
                public void afterEach ();
        driver.quit();
        driver = null;
    }
    @Test
    public void shouldBeSuccessfulForm () {
        driver.get("http://localhost:9999");
        WebElement form = driver.findElement(By.cssSelector("[class] form"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петров Петр");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79999999999");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("[type=button]")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }
}