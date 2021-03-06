package br.sp.caioviana.tasks.functional.server;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TasksTest {


	@Test
	public void endpoint_node() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-node-api.vati.rocks:85/");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void endpoint_core() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-core-api.vati.rocks:86/");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void endpoint_cdp() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-cdp-api.vati.rocks:8888");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void endpoint_web_app() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-webapp.vati.rocks/");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}




