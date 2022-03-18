package system.pages;

import system.helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class FiltrarProdutosPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    private By labels = By.className("filters__filter__title__textLabel");
    private By resultadoBusca = By.cssSelector("a[class=\"item-card__description__product-name\"]>span");
    private By mensagemDeErro = By.cssSelector("div[class='wrapper']>h2");


    public FiltrarProdutosPage(){
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    public String NomeSecao(){
        By secao = By.cssSelector(".search-query");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(secao));
        WebElement tituloDaSecao = this.driver.findElement(secao);
        return tituloDaSecao.getText();
    }

    public List<String> labelFiltro() {
        List<WebElement> nomeLabel = this.driver.findElements(labels);
        List<String> nomeFiltro = new ArrayList<String>();
        for (int i = 0; i < nomeLabel.size(); i++) {
            if (nomeLabel.get(i).getText().isEmpty() == false){
                nomeFiltro.add(nomeLabel.get(i).getText());
            }
        }
        return nomeFiltro;
    }


    public void selecionarFiltro(String field, String value) {
        By labelFiltro = By.cssSelector("label[for='"+field+"-"+value+"']");
        WebElement filtroAplicado = this.driver.findElement(labelFiltro);
        filtroAplicado.click();
    }

    public String filtroAplicado(){
        By filtroAplicadoNome = By.cssSelector("li[value='28-31']");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(filtroAplicadoNome));
        WebElement filtro = this.driver.findElement(filtroAplicadoNome);
        return filtro.getText();
    }


    public List<String> listaDeResultados(){
        List<WebElement> busca = driver.findElements(resultadoBusca);
        List<String> listaDeProdutos = new ArrayList<String>();
        for(int i = 0; i < busca.size(); i++){
            listaDeProdutos.add(busca.get(i).getText());
        }
        return listaDeProdutos;
    }

    public String erroMensagem(){
        WebElement tituloDoErro = this.driver.findElement(mensagemDeErro);
        return tituloDoErro.getText();
    }


}
