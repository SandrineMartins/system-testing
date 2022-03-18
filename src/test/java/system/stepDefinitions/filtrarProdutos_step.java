package system.stepDefinitions;
import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import system.pages.BuscarProdutosPage;
import system.pages.FiltrarProdutosPage;


public class filtrarProdutos_step {

    FiltrarProdutosPage filtrarProdutosPage = new FiltrarProdutosPage();
    BuscarProdutosPage buscarProdutosPage = new BuscarProdutosPage();

    @Given("eu clico no menu de Novidades")
    public void eu_clico_no_menu_de_novidades(){
        buscarProdutosPage.clicarNaSecao();
    }

    @When("estou na seção de {string}")
    public void estou_na_secao_de_novidades(String secao){
        Assertions.assertEquals(secao.toLowerCase(), filtrarProdutosPage.NomeSecao().toLowerCase());
    }

    @Then("devo ser capaz de visualizar os tipos de filtro")
    public void devo_ser_capaz_de_visualizar_os_tipos_de_filtro(DataTable dataTable) {
        Assertions.assertEquals(dataTable.asList(), filtrarProdutosPage.labelFiltro());
    }

    @When("eu seleciono o filtro")
    public void eu_seleciono_o_filtro(DataTable dataTable) {
        for (int i = 0; i < dataTable.height(); i++){
            filtrarProdutosPage.selecionarFiltro(dataTable.column(0).get(i).toString(), dataTable.column(1).get(i).toString());
        }
    }

    @Then("o filtro selecionado deve ser mostrado")
    public void o_filtro_selecionado_deve_ser_mostrado() {
            Assertions.assertEquals("28/31", filtrarProdutosPage.filtroAplicado());
        }
    }


