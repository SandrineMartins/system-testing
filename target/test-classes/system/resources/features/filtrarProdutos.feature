
@FiltrarProdutosPage
Feature: Filtro no resultado da busca por produtos
    Como uma cliente da Zattini
    Eu quero poder filtar uma lista de produtos
    Para encontrar facilmente o produto que eu quero


    Background: SETUP
        Given Acesso a home page da página da loja


    Scenario: Verificar os filtros da página de "Novidades"
        Given eu clico no menu de Novidades
        When  estou na seção de "Novidades"
        Then devo ser capaz de visualizar os tipos de filtro
            |Tamanho        |
            |Gênero         |
            |Tipo de Produto|
            |Marca          |
            |Cor Principal  |
            |Cor            |
            |Personagem     |
            |Preço          |
            |Promoções      |
            |Desconto       |
            |Avaliação      |
            |Altura do Salto|
            |Material       |
            |Tipo de Salto  |
            |Departamento   |
            |Altura do Cano |
            |Tipo de Bico   |
            |Modelo da Bolsa|
            |Alça           |
            |Modelagem      |
            |Manga          |
            |Circunferência do Cano|
            |Tipo           |



    Scenario: Verificar que um filtro foi aplicado
        Given eu clico no menu de Novidades
        When estou na seção de "Novidades"
        And eu seleciono o filtro
            |tamanho          |28-31    |
        Then o filtro selecionado deve ser mostrado


