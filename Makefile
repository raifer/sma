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

exeBalls: balls
	java -cp "prof/gui.jar:bin/" balls.TestBallsSimulator

jdlv:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/automate/TestJDLVSimulator.java

exeJdlv : jdlv
	java -cp "prof/gui.jar:bin/" automate.TestJDLVSimulator

immigration:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/automate/TestImmigrationSimulator.java

exeImmigration : immigration
	java -cp "prof/gui.jar:bin/" automate.TestImmigrationSimulator

schelling:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/automate/TestSchellingSimulator.java

exeSchelling : schelling
	java -cp "prof/gui.jar:bin/" automate.TestSchellingSimulator

flock:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/boids/TestFlockSimulator.java

exeFlock : flock
	java -cp "prof/gui.jar:bin/" boids.TestFlockSimulator

pt:
	javac -d bin -sourcepath "src/" -cp "prof/gui.jar:bin/" src/boids/TestPPSimulator.java

exePt : pt
	java -cp "prof/gui.jar:bin/" boids.TestPPSimulator

clean:
	rm -rf bin/*.class

