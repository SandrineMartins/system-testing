
@BuscarProdutosPage
Feature: Pesquisar Produtos
         Como um cliente da loja Zattini
         Quero pesquisar por podutos
         Para que eu possa encontrar o que eu desejo comprar

  Background: SETUP
    Given Acesso a home page da página da loja


  Scenario: Pesquisar um produto existente
    Given Eu clico na barra de pesquisa
    When  Digito o nome do produto "Sapatênis Osklen Riva Masculino - Preto"
    And   Clico no botão de pesquisa
    Then  Verifico que a lista de produtos relacionados está de acordo com a pesquisa de "Sapatênis Osklen Riva Masculino - Preto"


  Scenario: Pesquisar por produto que não existe
    Given Eu clico na barra de pesquisa
    When  Digito o nome do produto "não existe"
    And   Clico no botão de pesquisa
    Then  Verifico que uma mensagem de erro informando que não há resultados para o produto pesquisado é mostrada


