@authentification
Feature: Je me connecte à l'application OrangeHRM
  En tant qu'utilisateur, je souhaite m'authentifier à l'application Orange

  Background: 
    Given Je me connecte a l application OrangeHRM
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And Je clique sur le bouton login

  @connexion_ok
  Scenario: Authentification à l'application OrangeHRM
    Then Je me redirige vers la page home "Welcome"

  @deconnexion
  Scenario: Vérifier la déconnexion
    When Je clique sur l icone logout
    And Je clique sur le bouton logout
