# TP QUALITE LOGICIELS GL4

## Contenu du repository 

- TP1_QL : Les principes SOLID
- TP2_SELENIUM : Une manipulation en utilisant l'outil de test automatique SELENIUM
- TP3_SELENIUM_JUNIT5 : Utiliser SELENIUM avec JUNIT

## Les principes SOLID 
 
_SOLID_ regroupe cinq principes de conception destinés à produire des architectures logicielles plus compréhensibles, flexibles et maintenables.

- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle


## SELENIUM 
 
La maipulation consiste à un petit scenario sur le site [TunisiaNet](https://www.tunisianet.com.tn/).

- Création d'un Compte.
- Authentification.
- Choix d'un produit.
- Confirmation de l'ordre.

## SELENIUM et JUNIT
 
Utilser _SELENIUM_ sur le site [TodoMVC](https://todomvc.com/).

#### Le scénarrio de test

- Choisir une technologie. 
- Remplire une liste avec **6** Todo's.
- Cocher **3** tâches.
- Vérifier que le nombre des tâches non terminées est égal à **3**.

#### Génération du rapport des tests

Pour visualiser le rapport des tests on ajoute dans `pom.xml` les plugins `maven-surfire-plugin` et `maven-surefire-report-plugin`.
On ajoute aussi le plugin `maven-site-plugin` pour créer le site contenant le rapport.

pour générer le rapport il suffit de lancer la commande
``` 
mvn clean test site
```

Afin de visualiser le rapport des tests, on peut soit : 
- Lancez `target/site/index.html` pour un rapport complet sur une interface web
- Consultez `target/surefire-reports` pour un rapport en XML
