@job_list
Feature: Ajout d une metier
  En tant qu utilisateur, je veux me connecter sur l application OrangeHRM afin de consulter la liste des metiers et
  ajouter une nouvelle metier

  Background: 
    Given Je me connecte a l application OrangeHRM
    When Je saisis le username "Admin"
    And Je saisis le mot de passe "admin123"
    And Je clique sur le bouton login
    And Je clique sur le bouton admin
    And Je clique sur le bouton job
    And Je clique sur le bouton job titles

  # @add_job
  # Scenario Outline: Ajout un ou plusieurs metier
   #  When Je clique sur le bouton Add
   #  Then La page "Add Job Title" s affiche
   #  When Je saisis le nom de metier dans le champ job title  "<job_title>"
  #   And Je saisis la description du metier dans le champ job description "<job_description>"
   #  And Je fais joindre  un fichier du specification du metier dans le champ job specification "<job_specification>"
   #  And Je saisis une note dans le champ note "<note>"
 #   #  Then Je verifie que le metier a ete ajoute dans la liste "<job_title>"
   #  And Je clique sur le bouton Add

   #  Examples: 
    #   | job_title | job_description      | job_specification                                                                   | note              |
   #   | AAAA      | livrer les courriers | C:\\Users\\user\\Desktop\\Formation QA Automation Engineer\\COURS SELENIUM\\pom.txt | Nouvelle metier 1 |

  # | Technicien reseaux informatique | Maintenance reseaux informatique | C:\\Users\\user\\Desktop\\Formation QA Automation Engineer\\COURS SELENIUM\\pom.txt | Nouvelle metier 2 |
  
  @delete_job
  Scenario Outline: Supprimer un ou plusieurs metiers
    When Je clique sur la case a cocher qui correspond au metier qu souhaite supprimer "<job_To_Delete>"
    And Je clique sur le bouton Delete
    And Je confirme la suppression du metier par un simple clic sur le bouton OK qui s affiche dans le boite de dialogue
    Then Je verifie que le metier a ete bien supprime du tableau "<job_To_Delete>"
    
    Examples: 
      | job_To_Delete  |
      | Software Engineer |
      | AAAA      |
      | Analyst     |