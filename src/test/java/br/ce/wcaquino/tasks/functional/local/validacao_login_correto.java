package br.ce.wcaquino.tasks.functional.local;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class validacao_login_correto {

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

        Thread.sleep(500);
        navegador.quit();
    }
}