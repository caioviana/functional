package br.ce.wcaquino.tasks.functional.local;


import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class endpoint_core {

    @Test
    public void teste() throws MalformedURLException {

        //System.setProperty ("webdriver.gecko.driver", "/Users/caioviana/drivers/geckodriver");
        //System.setProperty("webdriver.chrome.driver", "/Users/caioviana/drivers/chromedriver");
        //WebDriver navegador = new FirefoxDriver();
        //WebDriver navegador = new ChromeDriver();

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
        navegador.navigate().to("staging-core-api.vati.rocks:86");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navegador.get("http://local.core.api.jw2.vati.rocks:86/");
        navegador.get("staging-core-api.vati.rocks:86");
        String actualTitle = navegador.getTitle();
        //String expectedTitle = "Welcome to Symfony!";
        String expectedTitle = "";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Acesso endpoint CORE - OK");
        navegador.quit();

    }

}