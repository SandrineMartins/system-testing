package system.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import system.pages.BuscarProdutosPage;
import system.pages.FiltrarProdutosPage;

import java.util.*;
import static system.helpers.Constants.MENSAGEM_ERRO;

public class buscarProdutos_step {

    private BuscarProdutosPage buscarProdutosPage = new BuscarProdutosPage();
    private FiltrarProdutosPage filtrarProdutoPage = new FiltrarProdutosPage();

    @After
    public void tearDown(){
        buscarProdutosPage.fecharNavegador();
    }

    @Given("Acesso a home page da página da loja")
    public void accessMainPage() {
        buscarProdutosPage.acessarPagina();
    }

    @Given("Eu clico na barra de pesquisa")
    public void clicarBarraBusca() {
        buscarProdutosPage.clicarNaBarraDeBusca();
    }

    @When("Digito o nome do produto {string}")
    public void procurarProduto(String produto) {
        buscarProdutosPage.inserirProdutoParaBusca(produto);
    }

    @When("Clico no botão de pesquisa")
    public void clicarBotaoBusca() {
        buscarProdutosPage.clicarBotaoBuscar();
    }

    @Then("Verifico que a lista de produtos relacionados está de acordo com a pesquisa de {string}")
    public void verificaListaBusca(String produto) {
        List<String> resultadoBusca = filtrarProdutoPage.listaDeResultados();

        for(int i = 0; i < resultadoBusca.size(); i++){
            String resultadoBuscaProduto = resultadoBusca.get(i).toLowerCase();
            Assertions.assertTrue(resultadoBuscaProduto.contains(produto.toLowerCase()));
        }
    }

    @Then("Verifico que uma mensagem de erro informando que não há resultados para o produto pesquisado é mostrada")
    public void verificaMensagemErro() {
        String mensagem = filtrarProdutoPage.erroMensagem();
        Assertions.assertEquals(MENSAGEM_ERRO, mensagem.toLowerCase());

    }



}
