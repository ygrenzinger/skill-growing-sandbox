# Projet Montee en competence Carbon IT 19/02/2015

Projet separee en trois couches:

	1.ecommerceProviderJpa ==> Modele de donnees + acces base de donnees
	2.ecommerceProviderService ==> Couche Metier
	3.ecommerceWebApp ==> Couche Front
	
Avant de lancer l'application, il est necessaire d'avoir un contexte qui va bien.
Pour cela, lancer les scripts sql se trouvant dans le projet ecommerceProviderJpa (createTable.sql puis createReferenceSize.sql et 
enfin createItems.sql). Ils permettront de charger votre base de donnees H2 avec les donnees minimums requis.
