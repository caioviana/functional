package br.ce.wcaquino.tasks.functional.local;


import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class endpoint_node {

    @Test
    public void teste() throws MalformedURLException {

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

        //navegador.get("http://local.node.api.jw2.vati.rocks:85/");
        navegador.get("http://staging-node-api.vati.rocks:85/");

        String actualTitle = navegador.getTitle();
        String expectedTitle = "";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Acesso endpoint NODE - OK");
        navegador.quit();


    }

}