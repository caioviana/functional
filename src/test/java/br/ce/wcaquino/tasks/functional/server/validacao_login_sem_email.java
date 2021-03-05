package br.ce.wcaquino.tasks.functional.server;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class validacao_login_sem_email {

    private String strng;

    @Test
    public void teste() throws InterruptedException, MalformedURLException {

//		WebDriver driver = new ChromeDriver();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
        navegador.navigate().to("http://staging-webapp.vati.rocks/");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        navegador.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("pedro");
        navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("pedro");
        textElement = navegador.findElement(By.className("v-messages__wrapper")).getText();
        assertEquals("Invalid email", textElement);
        navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();
        System.out.println("Validação acesso sem email - OK");

        System.out.println("Validação digitado email errado - OK");
        textElement = navegador.findElement(By.className("v-messages__wrapper")).getText();
        assertEquals("Invalid email", textElement);
        //Thread.sleep(2000);


        Thread.sleep(1000);
        navegador.quit();
    }
}