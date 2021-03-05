package br.sp.caioviana.tasks.prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIT {

	@Test
	public void healthCheck() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		try {
			navegador.navigate().to("http://staging-webapp.vati.rocks/");
			navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String version = navegador.findElement(By.xpath("//div[contains(@class,'v-responsive__content')]")).getText();
			//Assert.assertTrue(version.startsWith("build"));
		} finally {
			navegador.quit();
		}
	}
}
