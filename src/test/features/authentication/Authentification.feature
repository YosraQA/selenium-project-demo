@authentification
Feature: Je me connecte à l'application OrangeHRM
  En tant que utilisateur, je souhaite m'authentifier à l'application Orange

  @connexion_ok
  Scenario: Authentification à l'application OrangeHRM
    Given Je me connecte a l application OrangeHRM
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And Je clique sur le bouton login
    Then Je me redirige vers la page home "Welcome"
