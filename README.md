Ensimag 2A POO - TP 2015/16
============================

- src: contient les classes fournies par les enseignants 
  -> TestGUI.java : cree une fenetre graphique "Invaders", pas de simulation
  Et toutes les classes crées pour le projet

- prof/gui.jar: archive Java contenant les classes de l'interface graphique. Voir un exemple d'utilisation dans TestGUI.java

- doc_gui: la documentation (API) des classes de l'interface graphique contenues dans gui.jar. Point d'entrée: index.html

- Makefile: makefile du projet. Plusieurs commandes possibles:
	-Pour compiler puis lancer la simulation des balles
		make exeBalls
	-Pour compiler puis lancer la simulation du Jeu de la vie
		make exeJDLV
	-Pour compiler puis lancer l'automate de Schelling
		make exeSchelling
	-Pour compiler puis lancer l'automate Immigration
		make exeImmigration
	-Pour compiler puis lancer la simulation d'un groupe de boids (flock)
		make exeFlock
	-Pour compiler puis lancer la simulation deux 2 flocks
		make exePt
	-Pour supprimer les fichiers générés lors de la compilation
		make clean

-livrable.pdf: le rapport pdf de 4 pages qui détaille les choix de conception et tests réalisés lors du projet

