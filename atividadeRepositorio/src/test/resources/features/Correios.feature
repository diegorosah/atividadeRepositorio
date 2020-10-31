#Author: Diego Augusto diegorosah.hc@gmail.com
Feature: Testar busca de cep no site dos correios

  Background: Abrir site dos correios
    Given abrir site dos correios

  Scenario Outline: Buscando diferentes ceps no site do correio
    When digitar o <cep>
    And clicar em buscar
    Then validar <endereco>

    Examples: 
      | cep       | endereco                             |
      | 04141-001 | "Rua Guiratinga - de 611/612 ao fim" |
      | 18760-080 | "Rua Padre José Julianeti"           |
