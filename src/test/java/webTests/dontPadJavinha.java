package webTests;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class dontPadJavinha {
    WebDriver driver;
    String textao = "package webTests;\n" +
            "\n" +
            "\n" +
            "import cucumber.api.java.After;\n" +
            "import cucumber.api.java.Before;\n" +
            "import cucumber.api.java.pt.*;\n" +
            "import org.openqa.selenium.By;\n" +
            "import org.openqa.selenium.Keys;\n" +
            "import org.openqa.selenium.WebDriver;\n" +
            "\n" +
            "import org.openqa.selenium.chrome.ChromeDriver;\n" +
            "import org.openqa.selenium.support.ui.ExpectedConditions;\n" +
            "import org.openqa.selenium.support.ui.WebDriverWait;\n" +
            "\n" +
            "import java.util.concurrent.TimeUnit;\n" +
            "\n" +
            "import static org.testng.Assert.assertEquals;";

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/93/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize(); // Maximizar a janela
        System.out.println("0 - Antes do Teste iniciar");
    }
    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Z - Depois do Teste finalizar");
    }


    @Dado("^que acesso o site do DontPad Javinha$")
    public void queAcessoOSiteDoDontPadJavinhaNaURL(){
        driver.get("http://dontpad.com/testejavinha");
        System.out.println("1 - Acessou o site");
    }

    @Quando("^Limpo o campo texto$")
    public void limpoOCampoTexto() {
    }

    @E("^digito um monte de texto$")
    public void digitoUmMonteDeTexto() {

        driver.findElement(By.id("text")).click();                //Opcional
        driver.findElement(By.id("text")).clear();                //Opcional
        driver.findElement(By.id("text")).sendKeys(textao);
        System.out.println("2 - Digitou o TEXTAO ");
        System.out.println(textao);
    }

    @Entao("^vejo esse texto gigante listado$")
    public void vejoEsseTextoGiganteListado() {
        assertEquals(driver.findElement(By.id("text")).getText(),textao);
        System.out.println("4 - Esta Exibindo o texto corretamente");

    }
}
