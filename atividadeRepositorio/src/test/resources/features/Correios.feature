#Author: Diego Augusto diegorosah.hc@gmail.com
Feature: Testar busca de cep no site dos correios

  Background: Abrir site dos correios
    Given abrir site dos correios

  Scenario: Buscando diferentes ceps no site do correio
    When digitar o cep
    And clicar em buscar
    Then validar endereco
