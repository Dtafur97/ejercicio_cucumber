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

import static org.junit.Assert.*;

public class CartSteps {

    private WebDriver driver;

    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By buttonLoginLocator = By.id("login-button");
    By addButtonLocator = By.id("add-to-cart-sauce-labs-bike-light");
    By removeButtonLocator = By.id("remove-sauce-labs-bike-light");
    By spanCartBadgeLocator = By.className("shopping_cart_badge");

    @Given("El usuario visualiza la pagina principal")
    public void el_usuario_visualiza_la_pagina_principal() {
        System.setProperty("webdriver.chrome.driver","./src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        driver.findElement(usernameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(buttonLoginLocator).click();

    }
    @When("El usuario agrega un producto al carrito de compras")
    public void el_usuario_agrega_un_producto_al_carrito_de_compras() {

        driver.findElement(addButtonLocator).click();

    }
    @Then("El usuario visualiza que se agrego un producto al carro de compras")
    public void el_usuario_visualiza_que_se_agrego_un_producto_al_carro_de_compras() {

        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(5));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(spanCartBadgeLocator)));

        assertEquals("1", driver.findElement(spanCartBadgeLocator).getText());
    }

    @When("El usuario remueve el producto de su carrito de compras")
    public void el_usuario_remueve_el_producto_de_su_carrito_de_compras() {
        driver.findElement(addButtonLocator).click();
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(5));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(spanCartBadgeLocator)));

        driver.findElement(removeButtonLocator).click();
    }
    @Then("El usuario visualiza que no tiene productos agregados")
    public void el_usuario_visualiza_que_no_tiene_productos_agregados() {

        assertEquals("ADD TO CART", driver.findElement(addButtonLocator).getText());
    }
}
