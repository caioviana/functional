package br.sp.caioviana.tasks.functional.server;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;
import static org.junit.Assert.assertEquals;

public class TasksTest {


	private WebDriverWait wait;

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

	@Test
	public void validacao_login_errado() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-webapp.vati.rocks/");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();

		String textElement = navegador.findElement(By.className("v-messages__wrapper")).getText();
		//assertEquals("This field is required", textElement);
		System.out.println("Validação acesso sem nenhuma credencial inserida - OK");

		navegador.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("email_errado@email.com");
		navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("pedro");
		navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();
		wait = new WebDriverWait(navegador, 15);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-alert__content")));

		System.out.println("Validação digitado email errado - OK");
		textElement = navegador.findElement(By.className("v-alert__content")).getText();
		//assertEquals("Invalid username or password", textElement);

	}

	@Test
	public void validacao_login_sem_email() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-webapp.vati.rocks/");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
	}

	@Test
	public void validacao_login_coreto() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
		navegador.navigate().to("http://staging-webapp.vati.rocks/");
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		navegador.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("pedro@email.com");
		navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("pedro");
		//Thread.sleep(500);
		navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();
		System.out.println("Validação acesso com email - OK");
		//wait = new WebDriverWait(navegador, 15);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='v-btn__content'][contains(.,'Logout')]")));

		String textElement = navegador.findElement(By.className("v-main")).getText();
		//assertEquals("Home", textElement);
		System.out.println("Validação acesso endpoint WEB_APP - OK");
	}

	@Test
	public void test_completo_login_unico() throws MalformedURLException, InterruptedException {

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			WebDriver navegador = new RemoteWebDriver(new URL("http://172.17.2.201:4444/wd/hub"), cap);
			navegador.navigate().to("http://staging-webapp.vati.rocks/");
			navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			navegador.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("pedro@email.com");
			navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("pedro");
			//Thread.sleep(500);
			navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Login')]")).click();
			System.out.println("Validação acesso com email - OK");
			//wait = new WebDriverWait(navegador, 15);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='v-btn__content'][contains(.,'Logout')]")));

			String textElement = navegador.findElement(By.className("v-main")).getText();
			//assertEquals("Home", textElement);
			System.out.println("Validação acesso endpoint WEB_APP - OK");
			sleep(3000);
			//navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Logout')]")).click();
			//navegador.quit();

			navegador.findElement(By.xpath("//div[@class='v-list-item__subtitle'][contains(.,'pedro@email.com')]")).click();
			navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'CDP')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'CDP')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'Contents')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'Contents')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Projects')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Projects')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Master')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Master')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Admin')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Admin')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Manager')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Manager')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//img[@src='noavatarurl']")).click();
			sleep(500);
			//navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-bell theme--dark')]")).click();
			//Thread.sleep(500);
			//navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-bell theme--dark')]")).click();
			//Thread.sleep(500);
			//navegador.findElement(By.xpath("//button[@type='button'][contains(.,'TOGGLE')]")).click();
			sleep(500);

			navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'FORM MODAL')]")).click();
			sleep(500);

			navegador.findElement(By.xpath("(//input[contains(@type,'text')])[1]")).sendKeys("LOGO");
			sleep(500);
			navegador.findElement(By.xpath("(//input[contains(@type,'text')])[2]")).sendKeys("KEY");

			sleep(500);
			navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("password");
			sleep(500);
			navegador.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys("CAMPO TITULO");
			sleep(500);
			navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-menu-down theme--light')]")).click();
			//Thread.sleep(500);
			navegador.findElement(By.xpath("(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[1]")).click();
			//Thread.sleep(500);
			navegador.findElement(By.xpath("(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[2]")).click();
			//(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[1]
			//Thread.sleep(500);
			navegador.findElement(By.xpath("(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[3]")).click();
			navegador.findElement(By.xpath("(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[4]")).click();
			navegador.findElement(By.xpath("(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[1]")).click();
			navegador.findElement(By.xpath("(//div[@class='v-list-item__title'][contains(.,'[object Object]')])[2]")).click();


			//navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Delivery')]")).click();
			//Thread.sleep(500);
			//navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Projects')]")).click();
			//Thread.sleep(500);
			//navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Contents')]")).click();
			//Thread.sleep(500);
			//navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'CDP')]")).click();
			//Thread.sleep(500);
			navegador.findElement(By.xpath("//span[@class='headline']")).click();
			//Thread.sleep(500);
			//navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Save')])")).click();
			//navegador.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//span[contains(.,'Save')]")).click();

			//navegador.findElement(By.xpath("(//span[@class='v-btn__content'][contains(.,'Save')])[1]")).click();


			navegador.findElement(By.xpath("(//span[@class='v-btn__content'][contains(.,'Close')])[2]")).click();
			sleep(1000);
/*
        navegador.findElement(By.xpath("//button[@type='button'][contains(.,'DELETE MODAL')]")).click();
        wait = new WebDriverWait(navegador, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-btn__content")));
        navegador.findElement(By.xpath("//span[contains(.,'Close')]")).click();
        navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Remove')]")).click();
        Thread.sleep(500);


        navegador.findElement(By.xpath("//button[@type='button'][contains(.,'DELETE MODAL')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//button[@type='button'][contains(.,'DELETE MODAL')]")).click();
        wait = new WebDriverWait(navegador, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-btn__content")));
        //navegador.findElement(By.xpath("//span[contains(.,'Remove')]")).click();
 */
			sleep(500);
			navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-arrow-left theme--dark white--text')]")).click();
			sleep(500);
			navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-arrow-right theme--dark white--text')]")).click();
			sleep(500);

			navegador.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-circle-slice-5 theme--dark']")).click();
			sleep(500);
			navegador.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-bell theme--dark']")).click();
			sleep(500);

			navegador.findElement(By.xpath("//div[@class='v-list-item__title title'][contains(.,'Pedro')]")).click();
			navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Logout')]")).click();
		}
	}