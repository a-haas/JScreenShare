# Instructions de compilation

Lancer le serveur sur une machine (compilation java classique + méthode main contenue dans WSPublisher.java)

cd client

Lancer la commande : wsimport -s . http://<ip>:8080/WS/RobotAPI?wsdl

Cette commande permet de récupérer l'adresse ip et l'interface afin que celles-ci soient prise en compte dans le programme.

Compiler les fichiers contenues au sein du package client du dossier client (compilation java classique)

Lancer RobotAPIClient (méthode main du client)