package integracao;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIResults;

public class Login {

    public static WebDriver driver;
    public static String url = "https://trello.com/";

    @Before
    public void openBrowser() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void valida() throws Exception {
        try {
            driver.get(url);
            driver.findElement(By.cssSelector("a.global-header-section-button")).click();
            driver.findElement(By.id("user")).sendKeys("fulaninhodoteste@gmail.com");
            driver.findElement(By.id("password")).sendKeys("fulano62doteste");
            driver.findElement(By.id("login")).click();
            if (driver.findElement(By.cssSelector("span.header-btn-text")) == null) {
                throw new Exception("Elemento \"Quadros\" não encontrado");
            }
            Integracao.updateResults("Novo caso de teste", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception e) {
            Integracao.updateResults("Novo caso de teste", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
