package br.ce.wcaquino.tasks.functional.server;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class endpoint_node {

    @Test
    public void teste() throws MalformedURLException {

//		WebDriver driver = new ChromeDriver();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
        navegador.navigate().to("http://staging-node-api.vati.rocks:85/");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navegador.get("http://staging-node-api.vati.rocks:85/");

        //String actualTitle = navegador.getTitle();
        //String expectedTitle = "";
        //assertEquals(expectedTitle, actualTitle);
        System.out.println("Acesso endpoint NODE - OK");
        navegador.quit();


    }

}