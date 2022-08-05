@signInXlsx
Feature: Je me connecte a l application OrangeHRM avec un fichier Excel
  En tant qu'utilisateur, je souhaite m'authentifier à l'application Orange

  @signIn
  Scenario: Authentification à l'application OrangeHRM
    Given Je me connecte a l application OrangeHRM
    When je m authentifie avec un fichier Excel