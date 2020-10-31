#Author: Diego Augusto diegorosah.hc@gmail.com
Feature: Testar busca de cep no site dos correios

  Background: Abrir site dos correios
    Given abrir site dos correios

  Scenario Outline: Buscando diferentes endereço através do cep
    When digitar o <cep>
    And clicar em buscar
    Then validar end<endereco>

    Examples: 
      | cep         | endereco                             |
      | "04141-001" | "Rua Guiratinga - de 611/612 ao fim" |
      | "18760-080" | "Rua Padre José Julianeti"           |

  Scenario Outline: Buscando cep através do endereço
    When digitar o <endereco>
    And clicar em buscar
    Then validar cep<cep>

    Examples: 
      | endereco                             | cep         |
      | "Rua Guiratinga - de 611/612 ao fim" | "04141-001" |
      | "Rua Padre José Julianeti"           | "18760-069" |