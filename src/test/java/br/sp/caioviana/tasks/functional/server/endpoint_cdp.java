package br.sp.caioviana.tasks.functional.server;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class endpoint_cdp {

    @Test
    public void teste() throws MalformedURLException {

//		WebDriver driver = new ChromeDriver();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
        navegador.get("http://staging-cdp-api.vati.rocks:8888");
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navegador.get("http://local.cdp.api.jw2.vati.rocks:8888/");

        System.out.println("Acesso endpoint CDP - OK");
        navegador.quit();

    }
}