to do pour Valentin pour rappel :
* ligne et colonnes dynamique pour jdlv et imi
* Calcul de la taille de la fenêtre en fonction du nb ligne/col : ajout d'une méthode pour cela dans AutomateSimulator en mode static!
* Pas besoin de passer les param height et width comme je l'ai fait pour schelling, pour avoir les valeurs :
this.height = gui.getPanelHeight() - 200;
		this.width = gui.getPanelWidth() - 100;
A corriger donc dans SchellingSimulator où j'ai un constructeur avec GUI, width, height.


Sinon à faire :
# Boids
* Regarder Vector.java, vérifier mon code et ajoutter commentaire si besoin
* Regarder flock, comprendre, vérifier et commenter.
* Faire la méthode drawFlock dans flockSimulator qui prend en compte les angles!
* Commencer  à tester la simu en gardant que la règle 1.


# Rapport :
* On fait ça en markdown? On peut convertir en LaTeX après! A discutter.
* Faire des schémas pour présenter nos class


-- 

