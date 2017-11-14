# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
# 3. gui.jar est dans le dossier prof 
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

balls:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/balls/TestBallsSimulator.java

runBalls: balls
	java -cp "prof/gui.jar:bin/" balls.TestBallsSimulator


jdlv:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/automate/TestJDLVSimulator.java

runJdlv : jdlv
	java -cp "prof/gui.jar:bin/" automate.TestJDLVSimulator
	

testImmigration:
	javac -d bin -classpath bin:binProf/gui.jar -sourcepath src src/automate/TestImmigrationSimulator.java
testSchelling:
	javac -d bin -classpath bin:binProf/gui.jar -sourcepath src src/automate/TestSchellingSimulator.java
testFlockSimulator:
	javac -d bin -classpath bin:binProf/gui.jar -sourcepath src src/boids/TestFlockSimulator.java

testPPSimulator:
	javac -d bin -classpath bin:binProf/gui.jar -sourcepath src src/boids/TestPPSimulator.java
# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exeBalls:
	java -classpath bin/balls/:binProf/gui.jar TestBallsSimulator

exeJDLV:
	java -classpath bin:binProf/gui.jar TestJDLVSimulator
exeImmigration:
	java -classpath bin:binProf/gui.jar TestImmigrationSimulator
exeSchelling:
	java -classpath bin:binProf/gui.jar TestSchellingSimulator
exeFlockSimulator:
	java -classpath bin:binProf/gui.jar TestFlockSimulator
exePPSimulator:
	java -classpath bin:binProf/gui.jar TestPPSimulator
clean:
	rm -rf bin/*.class

