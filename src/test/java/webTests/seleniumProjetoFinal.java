package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import utils.Evidencias;
import utils.Logs;

public class seleniumProjetoFinal {

    WebDriver driver;
    Evidencias evidencias;
    Logs logs;


    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());


    @BeforeClass
    public void antesDeIniciar() throws IOException {
        logs = new Logs();
        logs.IniciarLogCSV(dataHora);
        logs.registrarCSV(dataHora, "INICIO dos Casos De Teste", ("Teste Iniciou em " + dataHora));
    }

    @BeforeMethod
    public void inicio() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/93/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(120000, TimeUnit.MILLISECONDS);
        driver.get("https://www.submarino.com.br");
        evidencias = new Evidencias();
        logs = new Logs();

    }

    @AfterMethod
    public void fim() throws IOException {
        String dataHoraFim = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
        logs.registrarCSV(dataHora, "FIM do Caso de Teste", ("Terminou em " + dataHoraFim));
        driver.quit();
    }

    @AfterClass
    public void finalizarTudo() throws IOException {
        String dataHoraFim = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
        logs.registrarCSV(dataHora, "FIM dos Casos de Teste", ("Teste Iniciou em " + dataHora + " e Terminou em " + dataHoraFim));
    }

    @Test
    public void pesquisarCanecas() throws IOException {
        String casoDeTeste = "Caso de Teste submarino";
        evidencias.print(driver, casoDeTeste , dataHora, "Passo 1");
        logs.registrarCSV(dataHora,  "submarino","Abriu o Site");
        logs.registrarCSV(dataHora, casoDeTeste,"Iniciou o Caso de Teste");
        driver.findElement(By.id("h_search-input")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"clicou na barra de pesquisa");
        driver.findElement(By.id("h_search-input")).clear();
        logs.registrarCSV(dataHora, casoDeTeste,"limpou o campo");
        driver.findElement(By.id("h_search-input")).sendKeys("canecas");
        logs.registrarCSV(dataHora, casoDeTeste,"Digitou canecas");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo 2");
        driver.findElement(By.id("h_search-btn")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou botão Lupa");
        assertEquals(driver.findElement(By.cssSelector(".kWHUur")).getText(), "canecas");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é canecas");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo 3");
        assertEquals(driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/div/div/div[3]/div[3]/div[2]/div/div/a/h3")).getText(), "Caneca Estante de Livros");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é Caneca Estante de livros");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo 4");
        assertEquals(driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/div/div/div[3]/div[3]/div[2]/div/div/a/div[5]/span[1]")).getText(),"R$ 29,90");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é R$ 29,90");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo 5");
        driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/div/div/div[3]/div[3]/div[2]/div/div/a/div[5]/span[1]")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou no valor de R$ 29,90");
        assertEquals(driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/main/div[3]/div[1]/div[2]/h1")).getText(), "Caneca Estante De Livros");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é Caneca Estante De Livros");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo 6");
        driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/main/div[3]/div[2]/div[3]/a/span")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou em Comprar");

    }
}


