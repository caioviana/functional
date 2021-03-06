package br.sp.caioviana.tasks.functional.local;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class validacao_login_errado {

    private String strng;

    @Test
    public void teste() throws InterruptedException, MalformedURLException {

        System.setProperty ("webdriver.gecko.driver", "/Users/caioviana/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/Users/caioviana/drivers/chromedriver");
        //WebDriver navegador = new FirefoxDriver();
        WebDriver navegador = new ChromeDriver();
        DesiredCapabilities cap = DesiredCapabilities.chrome();

        Dimension n = new Dimension(1280, 800);
        //Dimension n = new Dimension (640, 640);
        navegador.manage().window().setSize(n);

        navegador.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
        navegador.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        navegador.manage().timeouts().setScriptTimeout(150, TimeUnit.SECONDS);
        WebDriverWait wait;

        //navegador.get("http://localhost:8080/login");
        navegador.get("http://staging-webapp.vati.rocks/");
        String actualTitle = navegador.getTitle();
        String expectedTitle = "jw2_web_2app";
        //Thread.sleep(500);
        System.out.println("Acesso endpoint - OK");

        navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();
        //Thread.sleep(1000);

        String textElement = navegador.findElement(By.className("v-messages__wrapper")).getText();
        assertEquals("This field is required", textElement);
        //Thread.sleep(1000);
        System.out.println("Validação acesso sem nenhuma credencial inserida - OK");

        navegador.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("email_errado@email.com");
        navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("pedro");
        //Thread.sleep(500);
        navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();
        wait = new WebDriverWait(navegador, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-alert__content")));

        System.out.println("Validação digitado email errado - OK");
        textElement = navegador.findElement(By.className("v-alert__content")).getText();
        assertEquals("Invalid username or password", textElement);
        //Thread.sleep(2000);

        Thread.sleep(500);
        navegador.quit();
    }
}