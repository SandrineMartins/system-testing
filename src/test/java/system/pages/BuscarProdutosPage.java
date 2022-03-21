package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import static system.pages.URLPage.PAGINA_PRINCIPAL;

public class BuscarProdutosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    DriverManager manager = new DriverManager();

    private By logoZattini = By.cssSelector(".logo > h1");
    private By barraDeBusca = By.id("search-input");
    private By botaoBuscar = By.cssSelector("button[alt='Buscar']");
    private By secao = By.xpath("//a[normalize-space()='Novidades']");


    public BuscarProdutosPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    public void acessarPagina(){
        driver.get(PAGINA_PRINCIPAL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoZattini));
        driver.manage().window().maximize();
    }

    public void clicarNaSecao(){
        WebElement abaSecao = this.driver.findElement(secao);
        abaSecao.click();
    }

    public void clicarNaBarraDeBusca(){
        By secao = By.xpath("//a[normalize-space()='Novidades']");
        WebElement abaSecao = this.driver.findElement(secao);
        this.wait.until(ExpectedConditions.elementToBeClickable(abaSecao));
        abaSecao.click();

    }

    public void inserirProdutoParaBusca(String produto){
        WebElement pesquisar = this.driver.findElement(barraDeBusca);
        pesquisar.sendKeys(produto);
    }

    public void clicarBotaoBuscar(){
        WebElement buscarBotao = this.driver.findElement(botaoBuscar);
        buscarBotao.click();
    }

    public void fecharNavegador(){
        manager.quitDriver();
    }
}