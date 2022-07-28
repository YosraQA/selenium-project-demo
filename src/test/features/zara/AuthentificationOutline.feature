@outline
Feature: Authentification sur l application Zara
  En tant qu utilisateur, je souhaite m authentifier sur l application avec un scenario outline

  @login
  Scenario Outline: Authentification sur l application Zara avec plusieurs utilisateurs
    Given Je me connecte sur l application Zara "https://www.zara.com/tn/"
    When Je clique sur se connecter
    Then Je me redirige vers la page "DÉMARRER LA SESSION"
    When Je saisis l adresse mail "<email>"
    And Je saisis le mot de passe de l utilisateur "<password>"
    And Je clique sur se connecter
    #Then Je me redirige vers mon compte zara "sameh"

    Examples: 
      | email                    | password    |
      | samehaouichaoui@yahoo.fr | samah2020AB |
      | yosrawelhazi@yahoo.fr    | Yosra2023@  |
      | sarroura@yahoo.fr        | Yosra2023@  |
