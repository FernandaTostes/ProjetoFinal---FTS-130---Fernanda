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

public class seleniumSimples {

    WebDriver driver;
    Evidencias evidencias;
    Logs logs;



    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    //String pattern = "yyyy-MM-dd HH-mm";
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    //String dataHora = simpleDateFormat.format(new Date());

    //static String hora = simpleDateFormat.format(new Time());
    @BeforeClass
    public void antesDeTudo() throws IOException {
        logs = new Logs();
        logs.IniciarLogCSV(dataHora);
        logs.registrarCSV(dataHora, "INICIO dos Casos De Teste",("Teste Iniciou em " + dataHora));
    }

    @BeforeMethod
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/93/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(120000, TimeUnit.MILLISECONDS);
        driver.get("https://www.iterasys.com.br");
                evidencias = new Evidencias();
        logs = new Logs();

    }

    @AfterMethod
    public void finalizar() throws IOException {
        String dataHoraFim = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
        logs.registrarCSV(dataHora, "FIM do Caso de Teste",("Terminou em " +  dataHoraFim));
        driver.quit();
    }

    @AfterClass
    public void finalizarTudo() throws IOException {
        String dataHoraFim = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
        logs.registrarCSV(dataHora, "FIM dos Casos de Teste",("Teste Iniciou em " + dataHora + " e Terminou em " +  dataHoraFim));
    }

    @Test
    public void consultarCurso() throws IOException {
        String casoDeTeste = "Caso de Teste Mantis";
        evidencias.print(driver, casoDeTeste , dataHora, "Passo1");
        logs.registrarCSV(dataHora,  "Iterasys","Abriu o Site");
        logs.registrarCSV(dataHora, casoDeTeste,"Iniciou o Caso de Teste");
        driver.findElement(By.id("searchtext")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"clicou na barra de pesquisa");
        driver.findElement(By.id("searchtext")).clear();
        logs.registrarCSV(dataHora, casoDeTeste,"limpou o campo");
        driver.findElement(By.id("searchtext")).sendKeys("mantis");
        logs.registrarCSV(dataHora, casoDeTeste,"Digitou Mantis");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo2");
        driver.findElement(By.id("btn_form_search")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou botão Lupa");
        //assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"mantis\"");
        //logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é Cursos › mantis");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo3");
        driver.findElement(By.cssSelector("span.comprar")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou em Comprar");
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Mantis");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é Mantis ");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo4");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(),"R$ 49,99");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é R$ 49,99");
    }

    @Test
    public void consultarCursoPreparatorioCTFL() throws IOException {
        String casoDeTeste = "Caso de Teste CTFL";
        evidencias.print(driver, casoDeTeste , dataHora,"Passo1");
        logs.registrarCSV(dataHora,  "Iterasys","Abriu o Site");
        logs.registrarCSV(dataHora, casoDeTeste,"Iniciou o Caso de Teste");
        driver.findElement(By.id("searchtext")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"clicou na barra de pesquisa");
        driver.findElement(By.id("searchtext")).clear();
        logs.registrarCSV(dataHora, casoDeTeste,"limpou o campo");
        driver.findElement(By.id("searchtext")).sendKeys("Preparatório CTFL");
        logs.registrarCSV(dataHora, casoDeTeste,"Digitou Preparatório CTFL");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo2");
        driver.findElement(By.id("btn_form_search")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou botão Lupa");
        //assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"Preparatório CTFL\"");
        //logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é Cursos › Preparatório CTFL");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo3");
        driver.findElement(By.cssSelector("span.comprar")).click();
        logs.registrarCSV(dataHora, casoDeTeste,"Clicou em Comprar");
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Preparatório CTFL");
        evidencias.print(driver, casoDeTeste , dataHora,"Passo4");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(),"R$ 169,00");
        logs.registrarCSV(dataHora, casoDeTeste,"Aferiu que é R$ 169,00");
    }

}
