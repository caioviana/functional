package br.sp.caioviana.tasks.functional.local;


import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class endpoint_cdp {

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

        //navegador.get("http://local.cdp.api.jw2.vati.rocks:8888/");
        navegador.get("staging-cdp-api.vati.rocks:8888");
        String actualTitle = navegador.getTitle();
        String expectedTitle = "";
        assertEquals(expectedTitle, actualTitle);
        System.out.println("Acesso endpoint CDP - OK");
        navegador.quit();

    }

    private void assertEquals(String expectedTitle, String actualTitle) {
    }

}