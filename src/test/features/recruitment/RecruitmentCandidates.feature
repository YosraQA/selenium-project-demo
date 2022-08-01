@recruitment
Feature: Consultation et mise à jour de la liste de candidats
  En tant qu utilisateur, je veux me connecter sur l application OrangeHRM afin de consulter et effectuer des modifications sur
  la liste des candidats, soit par l ajout d un nouveau candidat soit par la suppression d un candidat deja existant.

  Background: 
    Given Je me connecte a l application OrangeHRM
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And Je clique sur le bouton login
    And Je clique sur le module Recruitment

  @suppression_candidats
  Scenario Outline: Recherche et suppression d un ou plusieurs candidats
    When Je saisis le nom du candidat dans le champ Candidate Name "<candidate_Name>"
    And Je clique sur le bouton Search afin de lancer la recherche du candidat
    And Je clique sur le checkbox qui correspond au candidat selectionne
    And Je clique sur le bouton Delete afin de supprimer le candidat de la liste
    And Je clique sur le bouton OK dans la boite de dialogue qui s affiche
    Then Je verifie que le candidat selectionne a ete bien supprime de la liste "<candidate_Name>"

    Examples: 
      | candidate_Name   |
      | Jennifer Clinton |
      | gonetone 03      |

  @ajout_candidats
  Scenario Outline: Ajout d un ou plusieurs nouveaux candidats
    When Je clique sur le bouton Add afin d ajouter un nouveau candidat
    Then Je me suis redirigee vers la page "Add Candidate"
    When Je sais le prenom du candidat dans le champ First Name "<first_Name>"
    And Je saisis le deuxieme nom dans le champ Middle Name "<middle_Name>"
    And Je saisis le nom dans le champ Last Name "<last_Name>"
    And Je saisis l E-mail du nouveau candidat dans le champ E-mail "<email>"
    And Je sais le numero de contact dans le champ Contact No "<contact_No>"
    And Je saisis le titre de poste tout en utilisant la liste deroulante Job Vacancy "<job_Vacancy>"
    And Je fait joindre le curriculum vitae du candidat dans le champ Resume "<resume>"
    And Je saisis des mots cles dans le champ Keywords "<keywords>"
    And Je saisis un commentaire dans le champ Comment "<comment>"
    And Je saisis la date d application dans le champ Date of Application "<date_Application>"
    And Je clique sur le chekbox afin de confirmer le consentement de conserver les données
    And Je clique sur le bouton Save afin de sauvegarder les donnees saisies
    Then Je verifie que le candidat a ete bien ajoute a la liste "Status: Application Initiated"
    When Je clique sur le bouton Back pour que je puisse ajouter un nouveau candidat
    And Je clique sur le bouton Add afin d ajouter un nouveau candidat

    Examples: 
      | first_Name | middle_Name | last_Name | email                 | contact_No   | job_Vacancy       | resume                                                                                       | keywords | comment | date_Application |
      | Yosra      | yosra       | WELHAZI   | yosrawelhazi@yahoo.fr | +21629663428 | Software Engineer | C:\\Users\\user\\Desktop\\Formation QA Automation Engineer\\COURS SELENIUM\\recruitment.docx | nothing  | nothing | 2022-07-31       |
      | Yos        | yosra11111  | WEL       | yosrawelhazi@yahoo.fr | +2161        | Software Engineer | C:\\Users\\user\\Desktop\\Formation QA Automation Engineer\\COURS SELENIUM\\recruitment.docx | nothing  | nothing | 2020-08-28       |
