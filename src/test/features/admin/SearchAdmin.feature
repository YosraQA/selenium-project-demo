@admin
Feature: Je cherche un utilisateur
  En tant qu utilisateur, je souhaite verifier la presence d un utilisateur

  Background: 
    Given Je me connecte a l application OrangeHRM
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And Je clique sur le bouton login

  @search_admin
  Scenario: Verifier la presence d un utilisateur
    When Je clique sur le bouton admin
    And Je saisis "admin" dans le champ Username
    And Je clique sur le bouton Search
    Then Je verifie la presence de l utilisateur dans le tableau
    When Je clique sur l icone logout
    And Je clique sur le bouton logout
