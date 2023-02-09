package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By buttonLoginLocator = By.id("login-button");

    By spanErrorLocator = By.xpath("//div[@id='login_button_container']//form//h3");
    @Given("El usuario se encuentra en el inicio de la pagina")
    public void el_usuario_se_encuentra_en_el_inicio_de_la_pagina() {
        System.setProperty("webdriver.chrome.driver","./src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }
    @When("El usuario introduce sus credenciales correctamente")
    public void el_usuario_introduce_sus_credenciales_correctamente() {
        driver.findElement(usernameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(buttonLoginLocator).click();
    }
    @Then("El usuario visualiza la pantalla de productos de la pagina")
    public void el_usuario_visualiza_la_pantalla_de_productos_de_la_pagina() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @When("El usuario introduce sus credenciales incorrectamente")
    public void el_usuario_introduce_sus_credenciales_incorrectamente() {
        driver.findElement(usernameLocator).sendKeys("user01");
        driver.findElement(passwordLocator).sendKeys("user01");
        driver.findElement(buttonLoginLocator).click();
    }
    @Then("El usuario visualiza un mensaje de login fallido")
    public void el_usuario_visualiza_un_mensaje_de_login_fallido() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(spanErrorLocator)));

        assertTrue(driver.findElement(spanErrorLocator).isDisplayed());
    }
}
