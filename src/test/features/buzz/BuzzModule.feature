@authenticationWithBuzzModule
Feature: Authentification sur l application OrangeHRM
  En tant qu utilisateur, je veux me connecter sur l application OrangeHRM afin de poster une mise à jour de statut, telecharger des images et partager des vidéos tout en utilisant le module Buzz.

  Background: 
    Given Je me connecte a l application OrangeHRM
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And Je clique sur le bouton login
    And Je clique sur le module Buzz

  @post_a_status_update
  Scenario: Authentification sur l application OrangeHRM et publication de mise à jour de statut via le module Buzz
    When Je cree une mise a jour de statut dans le champ dont le placeholder est What s on your mind ? "Hello everyone !!"
    And Je clique sur le bouton Post
    Then Je verifie que mon statut est bien affiche sur la page "Hello everyone !!"
    When Je clique sur l icone logout
    And Je clique sur le bouton logout
    Then Je verifie que je me suis redirigee vers la page d acceuil Orange HRM

  @upload_Images
  Scenario: Authentification sur l application OrangeHRM et telechargement des images
    When Je clique sur le module Upload Images
    And J ecris une breve description de l image a telecharger "Funny image !!"
    And Je clique sur le bouton Upload Images et je vais entrer l image "C:\Users\user\Desktop\Formation QA Automation Engineer\COURS SELENIUM\FB_IMG_1657007739183.jpg"
    And Je clique sur le bouton Post du module Upload Images
    Then Je verifie que l image ainsi que sa description sont bien affichees "Funny image !!"
    When Je clique sur l icone logout
    And Je clique sur le bouton logout
    Then Je verifie que je me suis redirigee vers la page d acceuil Orange HRM

  @share_Video
  Scenario: Authentification sur l application OrangeHRM et partage des videos
    When Je clique sur le module Share Video
    And Je copie l url de la video a partager "https://www.youtube.com/watch?v=8w7g4vF9wUY&list=RD8w7g4vF9wUY&start_radio=1"
    And Je clique sur le bouton Save Video
    Then Je verifie que la video est bien partagee "https://www.youtube.com/watch?v=8w7g4vF9wUY&list=RD8w7g4vF9wUY&start_radio=1"
    When Je clique sur l icone logout
    And Je clique sur le bouton logout
    Then Je verifie que je me suis redirigee vers la page d acceuil Orange HRM
