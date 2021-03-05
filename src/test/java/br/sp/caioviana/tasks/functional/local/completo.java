package br.sp.caioviana.tasks.functional.local;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class completo {

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
        Thread.sleep(3000);
        //navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'Logout')]")).click();
        //navegador.quit();

        navegador.findElement(By.xpath("//div[@class='v-list-item__subtitle'][contains(.,'pedro@email.com')]")).click();
        navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'CDP')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'CDP')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'Contents')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__content'][contains(.,'Contents')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Projects')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Projects')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Master')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Master')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Admin')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Admin')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Manager')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Manager')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//img[@src='noavatarurl']")).click();
        Thread.sleep(500);
        //navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-bell theme--dark')]")).click();
        //Thread.sleep(500);
        //navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-bell theme--dark')]")).click();
        //Thread.sleep(500);
        //navegador.findElement(By.xpath("//button[@type='button'][contains(.,'TOGGLE')]")).click();
        Thread.sleep(500);

        navegador.findElement(By.xpath("//span[@class='v-btn__content'][contains(.,'FORM MODAL')]")).click();
        Thread.sleep(500);

        navegador.findElement(By.xpath("(//input[contains(@type,'text')])[1]")).sendKeys("LOGO");
        Thread.sleep(500);
        navegador.findElement(By.xpath("(//input[contains(@type,'text')])[2]")).sendKeys("KEY");

        Thread.sleep(500);
        navegador.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("password");
        Thread.sleep(500);
        navegador.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys("CAMPO TITULO");
        Thread.sleep(500);
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
        Thread.sleep(500);
        navegador.findElement(By.xpath("//span[contains(.,'Save')]")).click();

        //navegador.findElement(By.xpath("(//span[@class='v-btn__content'][contains(.,'Save')])[1]")).click();


        navegador.findElement(By.xpath("(//span[@class='v-btn__content'][contains(.,'Close')])[2]")).click();
        Thread.sleep(1000);
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
        Thread.sleep(500);
        navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-arrow-left theme--dark white--text')]")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//i[contains(@class,'v-icon notranslate mdi mdi-arrow-right theme--dark white--text')]")).click();
        Thread.sleep(500);

        navegador.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-circle-slice-5 theme--dark']")).click();
        Thread.sleep(500);
        navegador.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-bell theme--dark']")).click();
        Thread.sleep(500);

        navegador.findElement(By.xpath("//div[@class='v-list-item__title title'][contains(.,'Pedro')]")).click();
        navegador.findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'Logout')]")).click();
        Thread.sleep(500);
        navegador.quit();
    }
}